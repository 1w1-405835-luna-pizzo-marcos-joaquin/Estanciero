package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.dtos.players.PlayerDto;
import com.Grupo2.Estanciero.src.entities.MatchEntity;
import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.*;
import com.Grupo2.Estanciero.src.repositories.MatchRepository;
import com.Grupo2.Estanciero.src.repositories.PlayerRepository;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ArrayList<JugadorService> getPlayerByMatch(Long id) {


        Optional<MatchEntity> matchEntityOptional = matchRepository.findById(id);

        if (matchEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Match not found with id: " + id);
        }

        MatchEntity matchEntity = matchEntityOptional.get();
        List<PlayerEntity> playerEntities = matchEntity.getPlayers();

        ArrayList<JugadorService> players = new ArrayList<>();

        for (PlayerEntity p : playerEntities) {
            JugadorService player = convert(p);
            players.add(player);
        }

        return players;
    }


    Jugador convert(PlayerEntity p) {

        String type = p.getTipo();
        Jugador player = null;

        switch (type) {

            case "user":
                player = modelMapper.map(p, Player.class);
                break;

            case "conservador":
                player = modelMapper.map(p, BotConservador.class);
                break;

            case "equilibrado":
                player = modelMapper.map(p, BotEquilibrado.class);
                break;

            case "agresivo":
                player = modelMapper.map(p, BotAgresivo.class);
                break;
        }
        return player;
    }

    @Override
    public ArrayList<Jugador> getAll() {
        ArrayList<PlayerEntity> playerEntities = (ArrayList<PlayerEntity>) playerRepository.findAll();

        ArrayList<Jugador> players = new ArrayList<>();

        for (PlayerEntity p : playerEntities) {
            Jugador player = convert(p);
            players.add(player);
        }

        return players;
    }


    @Override
    public void deleteAll() {
        playerRepository.deleteAll();
    }

}
