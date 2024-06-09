package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.dto.PautaDto;
import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;
import com.kleyton.gerenciador_de_pautas_api.utils.MapperUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/reunioes/{id_reuniao}/pautas")
@RequiredArgsConstructor
public class PautaController {

	private final PautaService pautaService;

	private final ReuniaoService reuniaoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PautaDto salvaPauta(@RequestBody @Valid PautaDto pautaDto,
			@PathVariable(value = "id_reuniao") Long idReuniao) {
		Reuniao reuniao = reuniaoService.getReuniao(idReuniao);
		pautaDto.setReuniao(reuniao);
		return MapperUtils.map(pautaService.criaPauta(MapperUtils.map(pautaDto, Pauta.class)), PautaDto.class);
	}

}