package com.unicap.salaobeleza.model;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

	
    
}



