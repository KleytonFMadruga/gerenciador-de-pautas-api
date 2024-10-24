package com.kleyton.gerenciador_de_pautas_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ASSOCIADOS")
@NoArgsConstructor
public class Associado {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToMany(mappedBy = "associado", fetch = FetchType.LAZY)
	private List<Voto> pautasVotadas;

	@Getter
	@Setter
	@Column(nullable = false)
	private String nome;

	@Getter
	@Setter
	@Column(nullable = false, unique = true)
	private String cpf;

	public Associado(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

}