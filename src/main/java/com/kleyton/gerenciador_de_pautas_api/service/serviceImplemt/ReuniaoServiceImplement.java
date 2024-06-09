package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.repositories.ReuniaoRepository;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReuniaoServiceImplement implements ReuniaoService {

	private final ReuniaoRepository reuniaoRepository;

	@Override
	public Reuniao criaReuniao(Reuniao reuniao) {
		return reuniaoRepository.save(reuniao);
	}

	public List<Reuniao> listarReunioes() {
		return reuniaoRepository.findAll();
	}

	@Override
	public Reuniao getReuniao(Long id) {
		Optional<Reuniao> reuniaoOpt = reuniaoRepository.findById(id);
		return reuniaoOpt.orElse(null);
	}
}