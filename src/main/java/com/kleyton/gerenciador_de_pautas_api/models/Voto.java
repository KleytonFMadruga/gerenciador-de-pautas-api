package com.kleyton.gerenciador_de_pautas_api.models;

import com.kleyton.gerenciador_de_pautas_api.enums.VotoEnum;

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
@Table(name = "VOTOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "idPauta" }) })
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idAssociado", referencedColumnName = "id")
	private Associado associado;

	@ManyToOne
	@JoinColumn(name = "idPauta", referencedColumnName = "id")
	private Pauta pauta;

	private VotoEnum favoravel;

}