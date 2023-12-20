package com.proyect.aeropuerto.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyect.aeropuerto.models.TipoAvionModelo;

@Configuration
public class TipoAvionRepository {
	@Bean
	public List<TipoAvionModelo> rooms() {
		List<TipoAvionModelo> roomsList = new ArrayList<>();
		roomsList.add(new TipoAvionModelo(1, "Privado", 0));
		roomsList.add(new TipoAvionModelo(2, "Comercial", 5));
		return roomsList;
	}
}
