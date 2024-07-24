package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.CardEntity;
import com.Grupo2.Estanciero.src.models.Card;
import com.Grupo2.Estanciero.src.models.Tablero;
import com.Grupo2.Estanciero.src.repositories.CardRepository;
import com.Grupo2.Estanciero.src.services.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CardServiceImpTest {

    @SpyBean
    CardService cardService;

    @MockBean
    CardRepository cardRepository;

    @MockBean
    Tablero tablero;

    @Test
    void getAll() {

        List<CardEntity> cartas = new ArrayList<>();
        CardEntity carta1 = new CardEntity();
        CardEntity carta2 = new CardEntity();
        CardEntity carta3 = new CardEntity();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);


        when(cardRepository.findAll()).thenReturn(cartas);
        ArrayList<Card> cartResult = cardService.getAll();
        Assertions.assertNotNull(cartResult);
        Assertions.assertEquals(3, cartResult.size());

    }
}