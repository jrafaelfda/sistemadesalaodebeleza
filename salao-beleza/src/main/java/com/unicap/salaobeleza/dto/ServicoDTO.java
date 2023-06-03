package com.unicap.salaobeleza.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class ServicoDTO {

    private Long id;

    @NotEmpty
    private String descricao;

    @Positive
    private double preco;

    public ServicoDTO(Long id, String descricao, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }
}
