package com.kleyton.gerenciador_de_pautas_api.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.models.Voto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PautaDto {

	private Long id;

	private Reuniao reuniao;

	@NotNull
	private String descricao;

	private List<Voto> votos;

	private LocalDateTime inicioDeSessao;

	private LocalDateTime fimDeSessao;
}
