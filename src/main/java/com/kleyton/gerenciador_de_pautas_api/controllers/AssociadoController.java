package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.dto.AssociadoDto;
import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.service.AssociadoService;
import com.kleyton.gerenciador_de_pautas_api.utils.MapperUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/associados")
@RequiredArgsConstructor
public class AssociadoController {

	private final AssociadoService associadoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AssociadoDto salvaCadastro(@RequestBody @Valid AssociadoDto associadoDto) {
		return MapperUtils.map(associadoService.cadastraAssociado(MapperUtils.map(associadoDto, Associado.class)),
				AssociadoDto.class);

	}

}
