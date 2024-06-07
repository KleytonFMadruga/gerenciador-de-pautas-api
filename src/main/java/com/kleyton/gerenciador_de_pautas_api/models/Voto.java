package com.kleyton.gerenciador_de_pautas_api.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "VOTOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "idAssociado", "idPauta" }) })
public class Voto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVoto;

	@ManyToOne
	@JoinColumn(name = "idAssociado", referencedColumnName = "idAssociado")
	private Associado associado;

	@ManyToOne
	@JoinColumn(name = "idPauta", referencedColumnName = "idPauta")
	private Pauta pauta;

}