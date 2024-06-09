package com.kleyton.gerenciador_de_pautas_api.models;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "PAUTAS", uniqueConstraints = @UniqueConstraint(columnNames = { "idReuniao", "id" }))
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReuniao", referencedColumnName = "id", nullable = false)
	private Reuniao reuniao;

	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime inicioDeSessao;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fimDeSessao;

	public Pauta(String descricao) {
		this.descricao = descricao;
	}

}