package com.kleyton.gerenciador_de_pautas_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_pautas_api.dto.ReuniaoDto;
import com.kleyton.gerenciador_de_pautas_api.models.Reuniao;
import com.kleyton.gerenciador_de_pautas_api.service.ReuniaoService;
import com.kleyton.gerenciador_de_pautas_api.utils.MapperUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/reunioes")
@RequiredArgsConstructor
public class ReuniaoController {

	private final ReuniaoService reuniaoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ReuniaoDto salvaReuniao(@RequestBody @Valid ReuniaoDto reuniaoDto) {

		return MapperUtils.map(reuniaoService.criaReuniao(MapperUtils.map(reuniaoDto, Reuniao.class)),
				ReuniaoDto.class);

	}

	@GetMapping
	public List<Reuniao> listarReunioes() {
		return reuniaoService.listarReunioes();

	}

}