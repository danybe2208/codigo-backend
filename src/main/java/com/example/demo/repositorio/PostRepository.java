package com.example.demo.repositorio;

import com.example.demo.entidade.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByEmailAutor(String emailAutor);
}
