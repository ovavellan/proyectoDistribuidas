package com.proyect.aeropuerto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyect.aeropuerto.models.VueloModelo;
import com.proyect.aeropuerto.services.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public List<VueloModelo> getAllProducts() {
        return ProductService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public VueloModelo getProductByProductNumber(@PathVariable String productId) {
        return ProductService.getProductById(productId);
    }

    @PostMapping
    public Map<String, Object> addProduct(@RequestBody VueloModelo VueloModelo) {
        try {
        	ProductService.addProduct(VueloModelo);
        	return Map.of("result", true, "message", "Producto agregado correctamente"); 
        } catch(Exception e) {
        	return Map.of("result", false, "message", "Error: No se ha podido agregar el producto"); 
        }
    }

    @PutMapping("/{productId}")
    public Map<String, Object> updateProduct(@PathVariable String productId, @RequestBody VueloModelo updatedVueloModelo) {
    	try {
    		ProductService.updateProduct(productId, updatedVueloModelo);
    		return Map.of("result", true, "message", "Producto actualizado correctamente");
    	} catch(Exception e) {
    		return Map.of("result", false, "message", "Error: No se ha podido actualizar el producto"); 
    	}
    }

    @DeleteMapping("/{productId}")
    public Map<String, Object> deleteProduct(@PathVariable String productId) {
        try {
        	ProductService.deleteProduct(productId);
        	return Map.of("result", true, "message", "Producto eliminado correctamente");
        } catch(Exception e) {
        	return Map.of("result", false, "message", "Error: No se ha podido eliminar el producto");
        }
    }
}

