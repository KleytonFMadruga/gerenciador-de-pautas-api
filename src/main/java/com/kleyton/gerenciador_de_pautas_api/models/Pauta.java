package com.kleyton.gerenciador_de_pautas_api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PAUTAS", uniqueConstraints = @UniqueConstraint(columnNames = { "idReuniao", "idPauta" }))
public class Pauta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPauta;

	@ManyToOne
	@JoinColumn(name = "idReuniao", referencedColumnName = "idReuniao", nullable = false)
	private Reuniao reuniao;

	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	private Date inicioDeSessao;

	private Integer votosFavoraveis;

	private Integer votosContra;

	private Integer duracaoVotacaoEmMinutos;

}