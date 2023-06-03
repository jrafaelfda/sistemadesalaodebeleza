package com.unicap.salaobeleza.dto;

import com.unicap.salaobeleza.model.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PacoteServicosDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private Set<Servico> servicos;

    public PacoteServicosDTO(Long id, String nome, Set<Servico> servicos) {
        this.id = id;
        this.nome = nome;
        this.servicos = servicos;
    }
}
