package com.example.demo.services;

import com.example.demo.entidade.Curtida;
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
    
    public boolean remove(Integer idUsuarioCurtiu, Integer idPostCurtido) {
        Curtida curtida = curtidaRepository.findByIdPostCurtidoAndIdUsuarioCurtiu(idPostCurtido, idUsuarioCurtiu);
        if(curtida != null){
            curtidaRepository.delete(curtida);
            return true;
        }
        return false;
    }

    public boolean verificaCurtida(Integer idUsuarioCurtiu, Integer idPostCurtido){
        Curtida curtida = curtidaRepository.findByIdPostCurtidoAndIdUsuarioCurtiu(idPostCurtido, idUsuarioCurtiu);
        if(curtida == null){
            return false;
        }
        return true;
    }
}
