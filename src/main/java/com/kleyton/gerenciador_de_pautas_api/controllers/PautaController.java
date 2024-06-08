package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;

@RestController
@RequestMapping(value = "/pautas")
public class PautaController {

	@Autowired
	public PautaService pautaService;

	@PostMapping
	public ResponseEntity<?> salvaPauta(@RequestBody Pauta pauta) {

		try {
			Pauta novaPauta = pautaService.criaPauta(pauta);
			return new ResponseEntity<>(novaPauta, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}