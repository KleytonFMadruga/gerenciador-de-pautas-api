package com.kleyton.gerenciador_de_pautas_api.dto;

import com.kleyton.gerenciador_de_pautas_api.enums.VotoEnum;

import lombok.Data;

@Data
public class VotoDto {
	private VotoEnum valor;
}
