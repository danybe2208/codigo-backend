package com.example.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Trabalho {
    private String nomeInstituicao;
    private String cidadeOndeTrabalha;
    private String estadoOndeTrabalha;
}
