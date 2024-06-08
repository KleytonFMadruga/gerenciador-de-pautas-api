package com.kleyton.gerenciador_de_pautas_api.dto;

import java.util.List;

import com.kleyton.gerenciador_de_pautas_api.models.Voto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssociadoDto {

	private Long id;

	private List<Voto> pautasVotadas;

	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;

}