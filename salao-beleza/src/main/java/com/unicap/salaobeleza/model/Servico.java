package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String descricao;

    @Positive
    private double preco;

	
    
    
}

