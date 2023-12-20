package com.proyect.aeropuerto.repositories;

import java.util.ArrayList;
import java.util.List;

import com.proyect.aeropuerto.models.PilotoModelo;

public class PilotoRepository {
	private List<PilotoModelo> pilotoModelos = new ArrayList<>();
	
	public List<PilotoModelo> getAll() {
		System.out.println("Lista de Pilotos");
		return this.pilotoModelos;
	}
}
