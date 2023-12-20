package com.proyect.aeropuerto.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.aeropuerto.config.Adult;
import com.proyect.aeropuerto.models.CardModel;
import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.services.CardService;
import com.proyect.aeropuerto.services.PilotoService;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
	@Autowired
    private PilotoService pilotoService;
	@Autowired
    private CardService cardService;
	
	@GetMapping()
	public List<PilotoModelo> getAll() {
		return pilotoService.getAll();
	}
	
	@PostMapping()
	public Map<String, Object> create(@RequestBody PilotoModelo pilotoModelo){
		try {
			Adult adult = new Adult();
			if(!adult.verify(pilotoModelo.getBirthday())) {
				return Map.of("result", false, "message", "El piloto debe ser mayor de edad");
			}
			if(pilotoService.save(pilotoModelo)) {
				return Map.of("result", true, "message", "Piloto agregado correctamente");
			} else {
				return Map.of("result", false, "message", "Ya existe un piloto con esa cédula");
			}
		} catch(Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido agregar al piloto");
		}
	}
	
	@PutMapping("/{employeeId}")
	public Map<String, Object> update(@PathVariable String employeeId, @RequestBody PilotoModelo pilotoModelo){
		try {
			Adult adult = new Adult();
			if(!adult.verify(pilotoModelo.getBirthday())) {
                          System.out.println("Los datos ingresados en el sistema son correctos");
				
				return Map.of("result", false, "message", "Piloto debe ser mayor de edad");
			}
			if(pilotoService.update(employeeId, pilotoModelo)) {
				return Map.of("result", true, "message", "Piloto modificado correctamente");
			} else {
				return Map.of("result", false, "message", "Ya existe un piloto con esa cédula");
			}
		} catch(Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido modificar al Piloto");
		}
	}
	
	@DeleteMapping("/{employeeId}")
	public Map<String, Object> delete(@PathVariable String employeeId){
		try {
			for(CardModel cardModel : cardService.getAllCards()) {
				if(cardModel.getPilotoId().equals(employeeId)) {
					return Map.of("result", false, "message", "No es posible eliminar este piloto porque tiene registros vinculados");
				}
			}
			
			if(pilotoService.delete(employeeId)) {
				return Map.of("result", true, "message", "Piloto eliminado correctamente");
			} else {
				return Map.of("result", false, "message", "No existe piloto con ese id");
			}
			
		} catch(Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido eliminar al piloto");
		}
	}
}
