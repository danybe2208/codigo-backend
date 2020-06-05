package com.example.demo.services;

import com.example.demo.entidade.Pessoa;
import com.example.demo.model.Informacao;
import com.example.demo.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Integer id) {
        if (pessoaRepository.existsById(id)){
            return pessoaRepository.findById(id).get();
        }
        return null;
    }

    public Pessoa findByEmail(String email) {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        for (Pessoa pessoa: pessoas){
            if (pessoa.getInformacao().getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }

    public Pessoa login(Pessoa pessoa) {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        String email = pessoa.getInformacao().getEmail();
        String senha = pessoa.getInformacao().getSenha();

        for (Pessoa p: pessoas){
            if (p.getInformacao().getEmail().equals(email)
            && p.getInformacao().getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    public Pessoa updatePessoa(Pessoa pessoa) {
        if (pessoaRepository.existsById(pessoa.getId())) {
            Pessoa pessoa_update = pessoaRepository.findById(pessoa.getId()).get();

            pessoa_update.setCurriculo(pessoa.getCurriculo());
            pessoa_update.setFormacao(pessoa.getFormacao());
            pessoa_update.setInfoAdicionais(pessoa.getInfoAdicionais());
            pessoa_update.setInformacao(pessoa.getInformacao());
            pessoa_update.setInteresses(pessoa.getInteresses());
            pessoa_update.setTrabalho(pessoa.getTrabalho());

            return pessoaRepository.save(pessoa_update);
        }

        return null;
    }

    public List<Pessoa> findAllExcept(String email) {
        List<Pessoa> lista = pessoaRepository.findAll();
        Pessoa pessoa = findByEmail(email);
        if (pessoa != null){
            for(Pessoa p: lista){
                if (p == pessoa){
                    lista.remove(p);
                    return lista;
                }
            }
        }
        return null;
    }

    public List<Pessoa> findSeguindo(Integer id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoa.setSeguindo("2");

        if(!(pessoa.getSeguindo() == null || pessoa.getSeguindo() == "")){
            List<String> seguindo = Arrays.asList(pessoa.getSeguindo().split(","));
            List<Pessoa> aux = new ArrayList<>();
            for (int i = 0; i < seguindo.size(); i++) {
                aux.add(pessoaRepository.findById(Integer.parseInt(seguindo.get(i))).get());
            }
            return aux;
        }
        return null;
    }

    public List<Pessoa> findSeguidores(Integer id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoa.setSeguindo("2");

        if(!(pessoa.getSeguidores() == null || pessoa.getSeguidores() == "")){
            List<String> seguidores = Arrays.asList(pessoa.getSeguidores().split(","));
            List<Pessoa> aux = new ArrayList<>();
            for (int i = 0; i < seguidores.size(); i++) {
                aux.add(pessoaRepository.findById(Integer.parseInt(seguidores.get(i))).get());
            }
            return aux;
        }
        return null;
    }
}
