package com.unicap.salaobeleza.dto;

import com.unicap.salaobeleza.model.Cliente;
import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.model.PacoteServicos;
import com.unicap.salaobeleza.model.Servico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    private Long id;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private PacoteServicos pacoteServicos;
    private LocalDateTime dataHora;
}

