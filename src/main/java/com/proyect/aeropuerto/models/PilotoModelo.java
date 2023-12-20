package com.proyect.aeropuerto.models;

import com.proyect.aeropuerto.config.GenericPilotoID;
import lombok.Data;

@Data
public class PilotoModelo {
	private String id;
	private String dni;
	private String name;
	private String lastname;
	private String address;
	private String birthday;
	public PilotoModelo(String dni, String name, String lastname, String address, String birthday) {
		this.id = GenericPilotoID.getNextId();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.birthday = birthday;
	}
}
