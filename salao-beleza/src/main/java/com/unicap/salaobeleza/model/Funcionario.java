package com.unicap.salaobeleza.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Servico> getServicosHabilitados() {
		return servicosHabilitados;
	}

	public void setServicosHabilitados(Set<Servico> servicosHabilitados) {
		this.servicosHabilitados = servicosHabilitados;
	}
    
    
}

