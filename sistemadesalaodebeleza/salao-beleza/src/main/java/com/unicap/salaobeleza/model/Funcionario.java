package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    @ManyToMany
    @NotEmpty
    private Set<Servico> servicosHabilitados;

	public Set<Servico> getServicosHabilitados() {
		return servicosHabilitados;
	}

	public void setServicosHabilitados(Set<Servico> servicosHabilitados) {
		this.servicosHabilitados = servicosHabilitados;
	}
    
    
}

