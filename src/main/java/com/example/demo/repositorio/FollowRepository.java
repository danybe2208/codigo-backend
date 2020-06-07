package com.example.demo.repositorio;

import com.example.demo.entidade.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    List<Follow> findAllByPessoaSeguindo(Integer idPessoaSeguindo);
    List<Follow> findAllByPessoaSeguidores(Integer id);
}
