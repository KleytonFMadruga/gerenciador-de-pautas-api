package com.kleyton.gerenciador_de_pautas_api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.dto.PautaDto;
import com.kleyton.gerenciador_de_pautas_api.models.Pauta;
import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.service.PautaService;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;
import com.kleyton.gerenciador_de_pautas_api.utils.MapperUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class PautaController {

	private final PautaService pautaService;

	private final ReuniaoService reuniaoService;

	@PostMapping(value = "reunioes/{id_reuniao}/pautas")
	@ResponseStatus(HttpStatus.CREATED)
	public PautaDto salvaPauta(@RequestBody @Valid PautaDto pautaDto,
			@PathVariable(value = "id_reuniao") Long idReuniao) {
		Reuniao reuniao = reuniaoService.getReuniao(idReuniao);
		pautaDto.setReuniao(reuniao);
		return MapperUtils.map(pautaService.criaPauta(MapperUtils.map(pautaDto, Pauta.class)), PautaDto.class);
	}

	@GetMapping(value = "reunioes/{id_reuniao}/pautas")
	public List<Pauta> pautas(@PathVariable(value = "id_reuniao") Long idReuniao) {
		Reuniao reuniao = reuniaoService.getReuniao(idReuniao);
		return reuniao.getPautas();
	}

	@GetMapping(value = "reunioes/{id_reuniao}/pautas/{id_pauta}")
	public Pauta exibePauta(@PathVariable(value = "id_reuniao") Long idReuniao,
			@PathVariable(value = "id_pauta") Long idPauta) {
		Reuniao reuniao = reuniaoService.getReuniao(idReuniao);
		Pauta pauta = reuniao.getPautas().stream().filter(p -> p.getId().equals(idPauta)).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Pauta inexistente " + idPauta));

		return pauta;
	}

	@PostMapping(value = "pautas/{id_pauta}/sessao_de_votacao")
	public ResponseEntity<String> abreSessaoDeVotacao(@PathVariable(value = "id_pauta") Long idPauta,
			@RequestBody Map<String, Object> body) throws Exception {

		Long tempoDuracaoMin = Long.parseLong(body.get("tempoDuracaoMin").toString());

		pautaService.abreSessaoDeVotacao(idPauta, tempoDuracaoMin);

		return ResponseEntity.ok("Sessão liberada para votação");
	}

	@GetMapping(value = "pautas/{id_pauta}/votos_apurados")
	public String votosApurados(@PathVariable(value = "id_pauta") Long idPauta) {
		return pautaService.contagemDeVotos(idPauta);
	}
}
