package com.example.demo.services;

import com.example.demo.entidade.Follow;
import com.example.demo.repositorio.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public List<Follow> findSeguindo(Integer id) {
        return followRepository.findAllByPessoaSeguindo(id);
    }

    public List<Follow> findSeguidores(Integer id) {
        return followRepository.findAllByPessoaSeguidores(id);
    }

    public boolean verificaFollow(Integer idSegue, Integer idSeguindo) {
        List<Follow> lista = followRepository.findAll();
        for (Follow follow:
             lista) {
            if (follow.getPessoaSegue().equals(idSegue)
                    && follow.getPessoaSeguindo().equals(idSeguindo)){
                return true;
            }
        }

        return false;
    }

    public List<Follow> followPessoa(Integer idSegue, Integer idSeguindo) {
        Follow follow = new Follow();
        follow.setPessoaSegue(idSegue);
        follow.setPessoaSeguindo(idSeguindo);

        return null;
    }

    public List<Follow> undoFollowPessoa(Integer idSegue, Integer idSeguindo) {
        List<Follow> lista = followRepository.findAll();
        for (Follow follow:
                lista) {
            if (follow.getPessoaSegue().equals(idSegue)
                    && follow.getPessoaSeguindo().equals(idSeguindo)){
                followRepository.delete(follow);
                return lista;
            }
        }
        return null;
    }
}
