package com.proyect.aeropuerto.services;

import org.springframework.stereotype.Service;
import com.proyect.aeropuerto.models.CategoriaModelo;
import com.proyect.aeropuerto.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

	private List<CategoriaModelo> categories;

    public CategoriaService() {
        this.setCategories(new CategoriaRepository().categories());
    }

	public List<CategoriaModelo> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoriaModelo> categories) {
		this.categories = categories;
	}
	
	public CategoriaModelo getCategoryById(String id) {
        return categories.stream()
                .filter(card -> card.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}


