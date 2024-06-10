package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.repositories.PautaRepository;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PautaServiceImplement implements PautaService {

	private final PautaRepository pautaRepository;

	@Override
	public Pauta criaPauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	@Override
	public void abreSessaoDeVotacao(Long idPauta, Long tempoDeSessaoEmMin) throws SessaoJaIniciadaException {
		long tempoMin = 1;
		if (tempoDeSessaoEmMin > 0) {
			tempoMin = tempoDeSessaoEmMin;
		}
		LocalDateTime inicioSessao = LocalDateTime.now();
		LocalDateTime fimSessao = LocalDateTime.now().plusMinutes(tempoMin);
		Optional<Pauta> pautaOpt = pautaRepository.findById(idPauta);
		Pauta pauta = pautaOpt.orElse(null);
		if (pauta.getInicioDeSessao() != null) {
			throw new SessaoJaIniciadaException("A sessão de votação já foi iniciada para a pauta com id " + idPauta);
		}
		pautaRepository.updateSessao(idPauta, inicioSessao, fimSessao);

	}

	@SuppressWarnings("serial")
	public class SessaoJaIniciadaException extends Exception {
		public SessaoJaIniciadaException(String message) {
			super(message);
		}
	}

	@Override
	public Pauta getPauta(Long id) {
		Optional<Pauta> pautaOpt = pautaRepository.findById(id);
		return pautaOpt.orElse(null);
	}

}