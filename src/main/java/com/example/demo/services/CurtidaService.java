package com.example.demo.services;

import com.example.demo.entidade.Curtida;
import com.example.demo.entidade.Post;
import com.example.demo.repositorio.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {
    @Autowired
    private CurtidaRepository curtidaRepository;

    public Curtida createCurtida(Curtida curtida){
        return curtidaRepository.save(curtida);
    }

    public List<Curtida> readAllCurtida(){
        return curtidaRepository.findAll();
    }

    public Curtida readById(Integer id){
        return curtidaRepository.findById(id).get();
    }

    public Curtida readByIdPostCurtido(Integer idPostCurtido){
        return curtidaRepository.findByIdPostCurtido(idPostCurtido);
    }

    public boolean removeCurtida(Post post){
        if(readByIdPostCurtido(post.getId()) != null){
            Curtida c = curtidaRepository.findByIdPostCurtido(post.getId());
            curtidaRepository.delete(c);
            return true;
        }
        return false;
    }
}
