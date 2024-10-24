package com.kleyton.gerenciador_de_pautas_api.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "REUNIOES")
public class Reuniao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "reuniao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pauta> pautas;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataHora;

	private String tema;

	public Reuniao(LocalDateTime dataHora, String tema) {
		this.dataHora = dataHora;
		this.tema = tema;
		this.pautas = new ArrayList<Pauta>();
	}

}