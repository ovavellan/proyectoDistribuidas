package com.proyect.aeropuerto.services;

import org.springframework.stereotype.Service;
import com.proyect.aeropuerto.models.CardModel;
import com.proyect.aeropuerto.models.AvionModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private List<CardModel> cardModels = new ArrayList<>();

    public List<CardModel> getAllCards() {
        return cardModels;
    }

    public CardModel getCardByCardNumber(String cardNumber) {
        return cardModels.stream()
                .filter(cardModel -> cardModel.getCardNumber().equals(cardNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean addCard(CardModel cardModel) {
    	try {
    		cardModels.add(cardModel);
    		return true;    		
    	} catch(Exception e){
    		return false;
    	}
    }

    public CardModel updateCard(String cardNumber, int roomId, String employeeId, AvionModel avionModel) {
        CardModel existingCardModel = cardModels.stream()
                .filter(cardModel -> cardModel.getCardNumber().equals(cardNumber))
                .findFirst()
                .orElse(null);

        if (existingCardModel != null) {
            existingCardModel.setAvionModel(avionModel);
            existingCardModel.setPilotoId(employeeId);
            existingCardModel.setTipoAvionId(roomId);
        }

        return existingCardModel;
    }

    public void deleteCard(String cardNumber) {
        cardModels.removeIf(cardModel -> cardModel.getCardNumber().equals(cardNumber));
    }
}

