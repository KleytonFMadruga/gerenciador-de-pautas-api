package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.repositories.PautaRepository;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PautaServiceImplement implements PautaService {

	private final PautaRepository pautaRepository;

	@Override
	public Pauta criaPauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

}