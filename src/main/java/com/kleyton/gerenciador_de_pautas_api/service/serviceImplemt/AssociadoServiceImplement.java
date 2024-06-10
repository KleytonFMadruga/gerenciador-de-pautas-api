package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.repositories.AssociadoRepository;
import com.kleyton.gerenciador_de_pautas_api.service.AssociadoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImplement implements AssociadoService {

	private final AssociadoRepository associadoRepository;

	@Override
	public Associado cadastraAssociado(Associado associado) {
		return associadoRepository.save(associado);

	}

	@Override
	public Associado getAssociado(Long id) {
		Optional<Associado> associadoOpt = associadoRepository.findById(id);
		return associadoOpt.orElse(null);

	}

}