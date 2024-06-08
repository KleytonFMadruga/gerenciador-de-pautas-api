package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.repositories.PautaRepository;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;

@Service
public class PautaServiceImplement implements PautaService {

	@Autowired
	PautaRepository pautaRepository;

	@Override
	public Pauta criaPauta(Pauta pauta) {
		try {
			return pautaRepository.save(pauta);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar pauta", e);
		}

	}

}