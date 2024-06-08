package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.repositories.ReuniaoRepository;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;

@Service
public class ReuniaoServiceImplement implements ReuniaoService {

	@Autowired
	ReuniaoRepository reuniaoRepository;

	@Override
	public Reuniao criaReuniao(Reuniao reuniao) throws IllegalArgumentException {

		try {
			if (reuniao.getDataHora() == null || reuniao.getPautas().size() == 0 || reuniao.getTema() == "") {
				throw new IllegalArgumentException("Ausencia de dado(s)!");
			}
			return reuniaoRepository.save(reuniao);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Erro ao cadastrar reunião: " + e.getMessage());
		}

	}

	public List<Reuniao> listarReunioes() {
		return reuniaoRepository.findAll();
	}
}