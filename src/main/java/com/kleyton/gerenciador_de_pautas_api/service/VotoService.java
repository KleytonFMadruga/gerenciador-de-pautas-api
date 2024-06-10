package com.kleyton.gerenciador_de_pautas_api.service;

import org.springframework.http.ResponseEntity;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.models.Pauta;

public interface VotoService {
	ResponseEntity<String> votarPauta(Associado associado, Pauta pauta, String voto) throws Exception;
}
