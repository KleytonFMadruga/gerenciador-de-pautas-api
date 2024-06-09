package com.kleyton.gerenciador_de_pautas_api.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReuniaoDto {

	private Long idReuniao;

	private List<Pauta> pautas;

	@NotNull
	private LocalDateTime dataHora;

	@NotBlank
	private String tema;

}
