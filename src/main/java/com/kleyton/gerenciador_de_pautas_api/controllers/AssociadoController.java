package com.kleyton.gerenciador_de_pautas_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.service.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoController {

	@Autowired
	public AssociadoService associadoService;

	@PostMapping
	public ResponseEntity<?> salvaCadastro(@RequestBody Associado associado) {

		try {
			Associado novoAssociado = associadoService.cadastraAssociado(associado);
			return new ResponseEntity<>(novoAssociado, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("Erro ao cadastrar associado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
