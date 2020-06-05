package com.example.demo.controller;

import com.example.demo.entidade.Pessoa;
import com.example.demo.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cientista/")
@CrossOrigin("*")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("cadastro")
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @PostMapping("login")
    public Pessoa login(@RequestBody Pessoa pessoa){
        return pessoaService.login(pessoa);
    }

    @GetMapping("listaTodos")
    public List<Pessoa> readAll(){
        return pessoaService.findAll();
    }

    @GetMapping("procuraPorId/{id}")
    public Pessoa readById(@PathVariable Integer id){
        return pessoaService.findById(id);
    }

    @GetMapping("listaExceto/{email}")
    public List<Pessoa> readExcept(@PathVariable String email){
        return pessoaService.findAllExcept(email);
    }

    @GetMapping("procuraPorEmail/{email}")
    public Pessoa readByEmail(@PathVariable String email){
        return pessoaService.findByEmail(email);
    }

    @PutMapping("atualizaCientista")
    public Pessoa update(@RequestBody Pessoa pessoa) {
        return  pessoaService.updatePessoa(pessoa);
    }

    @GetMapping("seguindo/{id}")
    public List<Pessoa> seguindo(@PathVariable Integer id) {
        return pessoaService.findSeguindo(id);
    }

    @GetMapping("seguidores/{id}")
    public List<Pessoa> seguidores(@PathVariable Integer id) {
        return pessoaService.findSeguidores(id);
    }

    @GetMapping("verificaFollow/{id}/{idASeguir}")
    public boolean verificaFollow(@PathVariable Integer id, @PathVariable Integer idASeguir){
        return pessoaService.verificaFollow(id, idASeguir);
    }

    @GetMapping("follow/{idSeguindo}/{id}")
    public List<Pessoa> follow(@PathVariable Integer id, @PathVariable Integer idSeguindo) {
        return pessoaService.followPessoa(id, idSeguindo);
    }

}
