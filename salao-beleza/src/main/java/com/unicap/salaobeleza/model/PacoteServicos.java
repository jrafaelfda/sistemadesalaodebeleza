package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import jakarta.validation.constraints.*;

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

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}
    
    
}
