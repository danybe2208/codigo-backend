package com.example.demo.entidade;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    private Curriculo curriculo;
    private Formacao formacao;
    private InfoAdicionais infoAdicionais;
    private Informacao informacao;
    private Trabalho trabalho;

    private String interesses;

    @ManyToMany
    @JoinTable(name="pessoa_seguindo", joinColumns=
            {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
            {@JoinColumn(name="pessoa_id_seguindo")})
    private List<Pessoa> listaSeguindo;

    @ManyToMany
    @JoinTable(name="pessoa_seguidor", joinColumns=
            {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
            {@JoinColumn(name="pessoa_id_seguidores")})
    private List<Pessoa> listaSeguidores;
}
