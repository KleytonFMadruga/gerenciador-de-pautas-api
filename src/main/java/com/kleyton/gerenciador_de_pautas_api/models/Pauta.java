package com.kleyton.gerenciador_de_pautas_api.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PAUTAS", uniqueConstraints = @UniqueConstraint(columnNames = { "idReuniao", "idPauta" }))
public class Pauta {

	@JsonCreator
	public Pauta(String descricao) {
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPauta;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReuniao", referencedColumnName = "idReuniao", nullable = false)
	private Reuniao reuniao;

	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime inicioDeSessao;

	private Integer votosFavoraveis;

	private Integer votosContra;

	private Integer duracaoVotacaoEmMinutos;

}