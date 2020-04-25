package com.example.demo.controller;

import com.example.demo.entidade.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/post/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("criar")
    public Post create(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping("listaTodos")
    public List<Post> readAll(){
        return postService.findAll();
    }

    @GetMapping("listaPorEmailAutor/{emailAutor}")
    public List<Post> readByEmailAutor(@PathVariable String emailAutor){
        return postService.findByEmailAutor(emailAutor);
    }

    @PutMapping("editarPost")
    public Post updatePost(@RequestBody Post post){
        return postService.atualizaPost(post);
    }

    @GetMapping("listaPorId/{id}")
    public Post readById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @DeleteMapping("deletaPost/{idPost}")
    public boolean delelePost(@PathVariable Integer idPost){
        return postService.deletePost(idPost);
    }
}
