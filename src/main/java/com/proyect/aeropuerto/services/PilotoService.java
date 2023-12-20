package com.proyect.aeropuerto.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.repositories.PilotoRepository;

@Service
public class PilotoService {
	private PilotoRepository empRepository = new PilotoRepository();
	
	public List<PilotoModelo> getAll() {
		return empRepository.getAll();
	}
	
	public boolean save(PilotoModelo pilotoModelo) {
		for(PilotoModelo emp: empRepository.getAll()) {
			if(emp.getDni().equals(pilotoModelo.getDni())) {
				return false;
			}
		}
		empRepository.getAll().add(pilotoModelo);
		return true;
	}
	
	public boolean update(String employeeId, PilotoModelo pilotoModelo) {
		for(PilotoModelo emp: empRepository.getAll()) {
			if(emp.getDni().equals(pilotoModelo.getDni()) && !emp.getId().equals(employeeId)) {
				return false;
			}
		}
		
		for(int i = 0; i <= empRepository.getAll().size(); i++) {
			PilotoModelo selectedPilotoModelo = empRepository.getAll().get(i);
			if(selectedPilotoModelo.getId().equals(pilotoModelo.getId())) {
				empRepository.getAll().set(i, pilotoModelo);
				return true;
			}
		}		
		throw new NullPointerException("Ocurrió un error");
	}
	
	public PilotoModelo getById(String employeeId) {
		for(PilotoModelo emp: empRepository.getAll()) {
			if(emp.getDni().equals(employeeId)) {
				return emp;
			}
		}
		return null;
	}
	
	public boolean delete(String employeeId) {
		Iterator<PilotoModelo> iterador = empRepository.getAll().iterator();
        while (iterador.hasNext()) {
        	PilotoModelo objetoActual = iterador.next();
            if (objetoActual.getId().equals(employeeId)) {
                iterador.remove();
                return true;
            }
        }
        
        return false;
	}
}








