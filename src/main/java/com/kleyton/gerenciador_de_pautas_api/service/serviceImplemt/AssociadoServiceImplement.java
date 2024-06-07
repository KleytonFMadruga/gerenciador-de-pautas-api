package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.repositories.AssociadoRepository;
import com.kleyton.gerenciador_de_pautas_api.service.AssociadoService;

@Service
public class AssociadoServiceImplement implements AssociadoService {

	@Autowired
	AssociadoRepository associadoRepository;

	@Override
	public Associado cadastraAssociado(Associado associado) {

		try {
			return associadoRepository.save(associado);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("CPF já cadastrado", e);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar associado", e);
		}

	}

}
