package com.proyect.aeropuerto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyect.aeropuerto.config.Adult;
import com.proyect.aeropuerto.models.CardModel;
import com.proyect.aeropuerto.models.AvionModel;
import com.proyect.aeropuerto.services.CardService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<CardModel> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{cardNumber}")
    public CardModel getCardByCardNumber(@PathVariable String cardNumber) {
        return cardService.getCardByCardNumber(cardNumber);
    }

    @PostMapping("/{tipoAvionId}/{pilotoId}")
    public Map<String, Object> addCard(@PathVariable("tipoAvionId") int tipoAvionId,@PathVariable("pilotoId") String pilotoId, @RequestBody AvionModel avionModel) {
    	for(CardModel cardModel : cardService.getAllCards()) {
    		if(cardModel.getAvionModel().getNumero().equals(avionModel.getNumero())){
    			return Map.of("result", false, "message", "Ya existe un avión con ese número");
    		}
    	}
    	
    	Adult adult = new Adult();
		if(!adult.verify(avionModel.getCreacion())) {
			return Map.of("result", false, "message", "Avión No puede ser tan moderno");
		}
    	
    	CardModel cardModel = new CardModel(pilotoId, tipoAvionId, avionModel);
        cardService.addCard(cardModel);
        return Map.of("result", true, "message", "Avión agregado correctamente");
    }

    @PutMapping("/{cardNumber}/{tipoAvionId}/{pilotoId}")
    public Map<String, Object> updateCard(
		@PathVariable("cardNumber") String cardNumber, 
		@PathVariable("tipoAvionId") int tipoAvionId,
		@PathVariable("pilotoId") String pilotoId,
		@RequestBody AvionModel avionModel
    ) {
    	for(CardModel cardModel : cardService.getAllCards()) {
    		if(cardModel.getAvionModel().getNumero().equals(avionModel.getNumero()) && !cardModel.getCardNumber().equals(cardNumber)){
    			return Map.of("result", false, "message", "Ya existe un avión con esa cédula");
    		}
    	}
    	
    	Adult adult = new Adult();
		if(!adult.verify(avionModel.getCreacion())) {
			return Map.of("result", false, "message", "Avión debe ser mas antiguo");
		}
    	
        cardService.updateCard(cardNumber, tipoAvionId, pilotoId, avionModel);
        return Map.of("result", true, "message", "Avión actualizado correctamente");
    }

    @DeleteMapping("/{cardNumber}")
    public Map<String, Object> deleteCard(@PathVariable String cardNumber) {
    	try {
    		cardService.deleteCard(cardNumber);
    		return Map.of("result", true, "message", "Avión ha sido eliminado correctamente");
    	} catch(Exception e) {
    		return Map.of("result", false, "message", "Error: No se ha podido eliminar el avión");
    	}
    }
}

