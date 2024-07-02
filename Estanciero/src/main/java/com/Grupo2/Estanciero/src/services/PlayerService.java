package com.Grupo2.Estanciero.src.services;

import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.Jugador;
import com.Grupo2.Estanciero.src.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PlayerService {

    public ArrayList<JugadorService> getPlayerByMatch(Long id);
    public ArrayList<Jugador> getAll();

    void deleteAll();

}
