package com.proyect.aeropuerto.models;

import com.proyect.aeropuerto.config.GenericID;
import lombok.Data;

@Data
public class CardModel {
	private String cardNumber = GenericID.generateUniqueCode();
	private AvionModel avionModel;
	private String pilotoId;
	private int tipoAvionId;
	
	public CardModel(String pilotoId, int tipoAvionId, AvionModel avionModel) {
        this.avionModel = avionModel;
        this.pilotoId = pilotoId;
        this.tipoAvionId = tipoAvionId;
    }
}
