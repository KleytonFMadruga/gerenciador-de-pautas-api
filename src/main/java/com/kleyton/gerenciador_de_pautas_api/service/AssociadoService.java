package com.kleyton.gerenciador_de_pautas_api.service;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;

public interface AssociadoService {

	Associado cadastraAssociado(Associado associado);

	Associado getAssociado(Long id);

}
