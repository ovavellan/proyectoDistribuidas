package com.proyect.aeropuerto.models;
import lombok.Data;

import java.util.UUID;

@Data
public class VueloModelo {
	private String id = UUID.randomUUID().toString();
	private String name;
	private String categoryId;
	private String caducity;
	private String description;
	private double price;

	public VueloModelo(String name, String categoryId, String caducity, String description, double price) {
		super();
		this.name = name;
		this.categoryId = categoryId;
		this.caducity = caducity;
		this.description = description;
		this.price = price;
	}
}
