package com.example.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Informacao {
    private String nomePessoa;
    private String email;
    private String senha;
}
