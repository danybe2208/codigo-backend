package com.example.demo.controller;

import com.example.demo.entidade.Follow;
import com.example.demo.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cientista/")
@CrossOrigin("*")

public class FollowController {
    @Autowired
    private FollowService followService;

    @GetMapping("seguindo/{id}")
    public List<Follow> seguindo(@PathVariable Integer id) {
        return followService.findSeguindo(id);
    }

    @GetMapping("seguidores/{id}")
    public List<Follow> seguidores(@PathVariable Integer id) {
        return followService.findSeguidores(id);
    }

    @GetMapping("verificaFollow/{idSegue}/{idSeguindo}")
    public boolean verificaFollow(@PathVariable Integer idSegue, @PathVariable Integer idSeguindo){
        return followService.verificaFollow(idSegue, idSeguindo);
    }

    @GetMapping("follow/{idSegue}/{idSeguindo}")
    public List<Follow> follow(@PathVariable Integer idSegue, @PathVariable Integer idSeguindo) {
        return followService.followPessoa(idSegue, idSeguindo);
    }

    @GetMapping("unfollow/{idSegue}/{idSeguindo}")
    public List<Follow> unfollow(@PathVariable Integer idSegue, @PathVariable Integer idSeguindo) {
        return followService.undoFollowPessoa(idSegue, idSeguindo);
    }
}
