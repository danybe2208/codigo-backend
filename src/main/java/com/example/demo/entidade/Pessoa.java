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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seguindo_id", referencedColumnName = "pessoa_id", updatable = false, insertable = false)
    private Pessoa seguindo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seguindo")
    private List<Pessoa> listaSeguindo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seguidores_id", referencedColumnName = "pessoa_id", updatable = false, insertable = false)
    private Pessoa seguidores;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seguidores")
    private List<Pessoa> listaSeguidores;
}
