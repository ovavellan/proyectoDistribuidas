package com.proyect.aeropuerto.repositories;

import java.util.ArrayList;
import java.util.List;

import com.proyect.aeropuerto.models.PilotoModelo;

public class PilotoRepository {
	private List<PilotoModelo> pilotoModelos = new ArrayList<>();
	
	public List<PilotoModelo> getAll() {
		return this.pilotoModelos;
	}
}
