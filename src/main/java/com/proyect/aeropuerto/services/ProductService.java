package com.proyect.aeropuerto.services;

import org.springframework.stereotype.Service;
import com.proyect.aeropuerto.models.VueloModelo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<VueloModelo> vueloModelos = new ArrayList<>();

    public List<VueloModelo> getAllProducts() {
        return vueloModelos;
    }

    public VueloModelo getProductById(String id) {
        return vueloModelos.stream()
                .filter(card -> card.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public VueloModelo addProduct(VueloModelo vueloModelo) {
    	vueloModelos.add(vueloModelo);
        return vueloModelo;
    }

    public VueloModelo updateProduct(String productId, VueloModelo updatedVueloModelo) {
    	VueloModelo existingVueloModelo =  this.getAllProducts().stream()
                .filter(vueloModelo -> vueloModelo.getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingVueloModelo != null) {
        	existingVueloModelo.setName(updatedVueloModelo.getName());
        	existingVueloModelo.setDescription(updatedVueloModelo.getDescription());
        	existingVueloModelo.setPrice(updatedVueloModelo.getPrice());
        	existingVueloModelo.setCaducity(updatedVueloModelo.getCaducity());
        	existingVueloModelo.setCategoryId(updatedVueloModelo.getCategoryId());
        	
        }
        return existingVueloModelo;
    }

    public void deleteProduct(String id) {
        vueloModelos.removeIf(card -> card.getId().equals(id));
    }
}

