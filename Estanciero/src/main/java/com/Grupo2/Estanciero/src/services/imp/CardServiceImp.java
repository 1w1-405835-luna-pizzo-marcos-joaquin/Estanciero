package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.CardEntity;
import com.Grupo2.Estanciero.src.models.Card;
import com.Grupo2.Estanciero.src.repositories.CardRepository;
import com.Grupo2.Estanciero.src.services.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImp implements CardService {


    @Autowired
    CardRepository cardRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<Card> getAll() {

        List<CardEntity> cardsEntity = cardRepository.findAll();

        ArrayList<Card> cards = new ArrayList<>();

        for (CardEntity c : cardsEntity) {
            Card card = modelMapper.map(c, Card.class);
            cards.add(card);
        }

        return cards;
    }
}
