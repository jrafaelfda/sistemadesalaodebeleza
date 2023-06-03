package com.unicap.salaobeleza.model;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import jakarta.persistence.*;


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

