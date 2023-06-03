package com.unicap.salaobeleza.dto;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    public ClienteDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}

