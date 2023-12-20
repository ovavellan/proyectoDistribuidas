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
		System.out.println("Lista de Tipos de Avion ");
		
	}
}
