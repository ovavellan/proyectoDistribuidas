package com.proyect.aeropuerto.models;

import lombok.Data;

@Data
public class TipoAvionModelo {
	private int id;
	private String name;
	private double extra;

	public TipoAvionModelo(int id, String name, double extra) {
		super();
		this.id = id;
		this.name = name;
		this.extra = extra;
	}
}
