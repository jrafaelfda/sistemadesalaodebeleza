package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PacoteServicos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String nome;

    @ManyToMany
    @NotEmpty
    private Set<Servico> servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}
    
    
}
