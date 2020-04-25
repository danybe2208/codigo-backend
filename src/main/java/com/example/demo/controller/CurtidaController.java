package com.example.demo.controller;

import com.example.demo.entidade.Curtida;
import com.example.demo.entidade.Post;
import com.example.demo.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/curtida/")
public class CurtidaController {
    @Autowired
    private CurtidaService curtidaService;

    @PostMapping("createCurtida")
    public Curtida createCurtida(@RequestBody Curtida curtida){
        return curtidaService.createCurtida(curtida);
    }

    @GetMapping("getAllCurtida")
    public List<Curtida> getAllCurtida(){
        return curtidaService.readAllCurtida();
    }

    @GetMapping("getCurtidaId/{id}")
    public Curtida getCurtidaById(@PathVariable Integer id){
        return curtidaService.readById(id);
    }

    @DeleteMapping("removeCurtida")
    public boolean removeCurtida(@RequestBody Post post){
        return curtidaService.removeCurtida(post);
    }

    @GetMapping("verificaCurtida/{idUsuario}/{idPost}")
    public boolean verificaCurtida(@PathVariable Integer idUsuario, @PathVariable Integer idPost){
        return curtidaService.verificaCurtida(idUsuario, idPost);
    }
}
