package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.dto.VotoDto;
import com.kleyton.gerenciador_de_pautas_api.models.Associado;
import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.models.Voto;
import com.kleyton.gerenciador_de_pautas_api.repositories.VotoRepository;
import com.kleyton.gerenciador_de_pautas_api.service.VotoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VotoServiceImplement implements VotoService {

	private final VotoRepository votoRepository;

	@Override
	public ResponseEntity<String> votarPauta(Associado associado, Pauta pauta, VotoDto votoDto) throws VotoException {

		if (pauta.getFimDeSessao().isBefore(LocalDateTime.now())) {
			throw new VotoException("Tempo de sessão expirado!");
		}

		Voto NovoVoto = new Voto();
		NovoVoto.setAssociado(associado);
		NovoVoto.setPauta(pauta);
		NovoVoto.setFavoravel(votoDto.getValor());

		votoRepository.save(NovoVoto);

		return ResponseEntity.noContent().build();

	}

	@SuppressWarnings("serial")
	public class VotoException extends Exception {
		public VotoException(String message) {
			super(message);
		}
	}

}
