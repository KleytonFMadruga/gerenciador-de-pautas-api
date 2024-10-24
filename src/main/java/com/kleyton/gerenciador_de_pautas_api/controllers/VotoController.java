package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.dto.VotoDto;
import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.service.AssociadoService;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;
import com.kleyton.gerenciador_de_pautas_api.service.VotoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/{id_pauta}/{id_associado}/sessao_de_votacao/votos")
@RequiredArgsConstructor
public class VotoController {

	private final VotoService votoService;

	private final PautaService pautaService;

	private final AssociadoService associadoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> votarPauta(@RequestBody VotoDto votoDto,
			@PathVariable(value = "id_pauta") Long idPauta, @PathVariable(value = "id_associado") Long idAssociado)
			throws Exception {

		Associado associado = associadoService.getAssociado(idAssociado);
		Pauta pauta = pautaService.getPauta(idPauta);
		ResponseEntity<String> response = votoService.votarPauta(associado, pauta, votoDto);
		return response;

	}

}
