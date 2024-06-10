package com.kleyton.gerenciador_de_pautas_api.service;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;

public interface PautaService {

	Pauta criaPauta(Pauta pauta);

	void abreSessaoDeVotacao(Long idPauta, Long tempoDeSessaoEmMin) throws Exception;

	Pauta getPauta(Long id);

}
