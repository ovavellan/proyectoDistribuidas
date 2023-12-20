package com.proyect.aeropuerto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyect.aeropuerto.models.CategoriaModelo;
import com.proyect.aeropuerto.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaModelo> getAllCards() {
        return categoriaService.getCategories();
    }
    
    @GetMapping("/{categoryId}")
    public CategoriaModelo getCategory(@PathVariable String categoryId) {
        return categoriaService.getCategoryById(categoryId);
    }
}


