package com.unicap.salaobeleza.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class PacoteServicos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany
    private Set<Servico> servicos;

}
