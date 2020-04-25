package com.example.demo.services;

import com.example.demo.entidade.Post;
import com.example.demo.repositorio.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        List<Post> posts = postRepository.findAll();
        if(posts.size() > 0){
            return posts;
        }
        return null;
    }

    public List<Post> findByEmailAutor(String emailAutor) {
        return postRepository.findByEmailAutor(emailAutor);
    }

    public Post findById(Integer id) {
        return postRepository.findById(id).get();
    }

    public boolean deletePost(Integer idPost) {
        Post post = postRepository.findById(idPost).get();
        if (post != null){
            postRepository.delete(post);
            return true;
        }
        return false;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post atualizaPost(Post post) {
        if (postRepository.existsById(post.getId())){
            Post post_update = postRepository.findById(post.getId()).get();
            post_update.setConteudo(post.getConteudo());

            return postRepository.save(post_update);
        }
        return postRepository.save(post);
    }
}
