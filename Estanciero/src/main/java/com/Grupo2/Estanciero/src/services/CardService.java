package com.Grupo2.Estanciero.src.services;

import com.Grupo2.Estanciero.src.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CardService {

    ArrayList<Card> getAll();


}
