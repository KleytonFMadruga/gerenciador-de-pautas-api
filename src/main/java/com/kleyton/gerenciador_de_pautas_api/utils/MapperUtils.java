package com.kleyton.gerenciador_de_pautas_api.utils;

import org.modelmapper.ModelMapper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MapperUtils {

	public final static ModelMapper MAPPER = new ModelMapper();

	public static <T> T map(Object source, Class<T> destClass) {
		return MAPPER.map(source, destClass);
	}
}