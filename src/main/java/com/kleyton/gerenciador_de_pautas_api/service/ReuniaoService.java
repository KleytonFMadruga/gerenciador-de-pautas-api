package com.kleyton.gerenciador_de_pautas_api.service;

import java.util.List;

import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;

public interface ReuniaoService {

	Reuniao criaReuniao(Reuniao reuniao);

	List<Reuniao> listarReunioes();

	Reuniao getReuniao(Long id);

}