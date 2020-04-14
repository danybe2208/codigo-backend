package com.example.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class InfoAdicionais {
    private String dataNascimento;
    private String dataInicioCientista;
    private String cpf;
}
