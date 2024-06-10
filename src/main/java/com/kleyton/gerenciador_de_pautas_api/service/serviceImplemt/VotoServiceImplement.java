package com.kleyton.gerenciador_de_pautas_api.service.serviceImplemt;

import static com.kleyton.gerenciador_de_pautas_api.enums.VotoEnum.NAO;
import static com.kleyton.gerenciador_de_pautas_api.enums.VotoEnum.SIM;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_pautas_api.enums.VotoEnum;
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
	public ResponseEntity<String> votarPauta(Associado associado, Pauta pauta, String voto) throws VotoException {

		if (pauta.getFimDeSessao().isBefore(LocalDateTime.now())) {
			throw new VotoException("Tempo de sessão expirado!");
		}

		VotoEnum votoEnum = null;
		if (extrairPalavra(voto).equals("SIM")) {
			votoEnum = SIM;
		}
		if (extrairPalavra(voto).equals("NAO")) {
			votoEnum = NAO;
		}
		Voto NovoVoto = new Voto();
		NovoVoto.setAssociado(associado);
		NovoVoto.setPauta(pauta);
		NovoVoto.setFavoravel(votoEnum);

		votoRepository.save(NovoVoto);

		return ResponseEntity.noContent().build();

	}

	@SuppressWarnings("serial")
	public class VotoException extends Exception {
		public VotoException(String message) {
			super(message);
		}
	}

	public static String extrairPalavra(String input) {
		Pattern pattern = Pattern.compile("\\{voto=(.*?)\\}");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}
}
