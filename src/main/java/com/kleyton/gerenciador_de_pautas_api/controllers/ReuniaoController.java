package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;

@RestController
@RequestMapping(value = "/reunioes")
public class ReuniaoController {

	@Autowired
	public ReuniaoService reuniaoService;
	@Autowired
	public PautaService pautaService;

	@PostMapping
	public ResponseEntity<?> salvaReuniao(@RequestBody Reuniao reuniao) {

		try {
			Reuniao novaReuniao = reuniaoService.criaReuniao(reuniao);
			for (Pauta pauta : reuniao.getPautas()) {
				pauta.setReuniao(novaReuniao);
				pautaService.criaPauta(pauta);
			}
			return new ResponseEntity<>(novaReuniao, HttpStatus.CREATED);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}