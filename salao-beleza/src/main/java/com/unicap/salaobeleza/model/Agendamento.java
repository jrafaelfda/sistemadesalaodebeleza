package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private PacoteServicos pacoteServicos;

    private LocalDateTime dataHora;

}
