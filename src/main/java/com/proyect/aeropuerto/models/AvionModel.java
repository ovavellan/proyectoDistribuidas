package com.proyect.aeropuerto.models;

import lombok.Data;

@Data
public class AvionModel {
	private String name;
	private String company;
	private String numero;
	private String pais;
	private String creacion;

*/Constructor/*
	public AvionModel(String name, String company, String numero, String pais, String creacion) {
		super();
		this.name = name;
		this.company = company;
		this.numero = numero;
		this.pais = pais;
		this.creacion = creacion;
	}
}
