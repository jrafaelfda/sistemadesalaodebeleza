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

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public PacoteServicos getPacoteServicos() {
		return pacoteServicos;
	}

	public void setPacoteServicos(PacoteServicos pacoteServicos) {
		this.pacoteServicos = pacoteServicos;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	@ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private PacoteServicos pacoteServicos;

    private LocalDateTime dataHora;

	

}
