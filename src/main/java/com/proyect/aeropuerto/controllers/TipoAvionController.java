package com.proyect.aeropuerto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.aeropuerto.models.TipoAvionModelo;
import com.proyect.aeropuerto.services.TipoAvionService;

@RestController
@RequestMapping("/tipoAvion")
public class TipoAvionController {
	@Autowired
    private TipoAvionService tipoAvionService;
	
	@GetMapping()
	public List<TipoAvionModelo>getRooms() {
		return tipoAvionService.getRooms();
	}
}
