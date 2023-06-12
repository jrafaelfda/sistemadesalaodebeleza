package com.unicap.salaobeleza.dto;

import com.unicap.salaobeleza.model.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private Set<Servico> servicosHabilitados;

    public FuncionarioDTO(Long id, String nome, String email, String telefone, Set<Servico> servicosHabilitados) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.servicosHabilitados = servicosHabilitados;
    }
}
