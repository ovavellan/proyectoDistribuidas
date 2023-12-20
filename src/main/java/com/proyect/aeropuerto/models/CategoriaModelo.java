package com.proyect.aeropuerto.models;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoriaModelo {
	private String id = UUID.randomUUID().toString();
	private String name;

	public CategoriaModelo(String name) {
		this.name = name;
	}
}
