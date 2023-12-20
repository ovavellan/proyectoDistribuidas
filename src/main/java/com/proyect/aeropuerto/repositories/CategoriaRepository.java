package com.proyect.aeropuerto.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyect.aeropuerto.models.CategoriaModelo;

@Configuration
public class CategoriaRepository {
	@Bean
    public List<CategoriaModelo> categories() {
        List<CategoriaModelo> categories = new ArrayList<>();

        CategoriaModelo categoriaModelo1 = new CategoriaModelo("Ejecutiva");
        CategoriaModelo categoriaModelo2 = new CategoriaModelo("Economica");
        CategoriaModelo categoriaModelo3 = new CategoriaModelo("Estandar");
	CategoriaModelo categoriaModelo4 = new CategoriaModelo("Baja");
	CategoriaModelo categoriaModelo5 = new CategoriaModelo("Promedio");

        categories.add(categoriaModelo1);
        categories.add(categoriaModelo2);
        categories.add(categoriaModelo3);
	categories.add(categoriaModelo4);
        categories.add(categoriaModelo5);

        return categories;
    }
}
