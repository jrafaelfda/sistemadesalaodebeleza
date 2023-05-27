package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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



