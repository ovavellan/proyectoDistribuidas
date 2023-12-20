package com.proyect.aeropuerto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyect.aeropuerto.models.TipoAvionModelo;
import com.proyect.aeropuerto.repositories.TipoAvionRepository;

@Service
public class TipoAvionService {
	private TipoAvionRepository roomRepository = new TipoAvionRepository();
	
	public List<TipoAvionModelo> getRooms() {
		return roomRepository.rooms();
	}
}
