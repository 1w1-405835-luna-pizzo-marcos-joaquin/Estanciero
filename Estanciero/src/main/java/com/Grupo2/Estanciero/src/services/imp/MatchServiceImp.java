package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.dtos.MatchDto;
import com.Grupo2.Estanciero.src.dtos.players.PlayerDto;
import com.Grupo2.Estanciero.src.entities.MatchEntity;
import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.*;
import com.Grupo2.Estanciero.src.repositories.MatchRepository;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Service
public class MatchServiceImp implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    EntityManager entityManager;

    Scanner scan = new Scanner(System.in);

    @Transactional
    @Override
    public Match createMatch(ArrayList<JugadorService> players, int difficultyInt, int modo, int capitalParaGanar) {

        String difficultyStr = "";

        switch (difficultyInt){
            case 1: difficultyStr = "easy";
                break;
            case 2: difficultyStr = "medium";
                break;
            case 3: difficultyStr = "hard";
                break;
        }

        Dificultad difficulty;
        difficulty = Dificultad.valueOf(difficultyStr.toUpperCase());

        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setModo(modo);
        matchEntity.setMontoGanador(capitalParaGanar);
        matchEntity.setMatchStatus(MatchStatus.PLAYING);
        matchEntity.setCreateAt(LocalDateTime.now());
        matchEntity.setDificultad(difficulty);


        List<PlayerEntity> playerEntities = new ArrayList<>();

        for(JugadorService player : players){
            PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
            playerEntity.setMatch(matchEntity);
            playerEntities.add(playerEntity);
        }

        matchEntity.setPlayers(playerEntities);

        MatchEntity matchSaved = matchRepository.save(matchEntity);
        ArrayList<Jugador> playerss = new ArrayList<>();

        for(PlayerEntity p : playerEntities){
            Jugador j = convert(p);
            long idLong = p.getId();
            int id = (int)idLong;
            j.setIdJugador(id);
            playerss.add(j);
        }


        Match match = modelMapper.map(matchSaved, Match.class);
        match.setPlayers(playerss);
        return match;

    }

   @Transactional
    @Override
    public Match getMatchById(Long id) {

        Optional<MatchEntity> matchEntityOptional = matchRepository.findById(id);
        if (matchEntityOptional.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return modelMapper.map(matchEntityOptional.get(), Match.class);
        }
    }
    @Transactional
    @Override
    public Match getMatch(){

        MatchEntity matchEntity =  matchRepository.findAll().stream()
                .findFirst().orElse(null);

        Match match = new Match();
        if(matchEntity != null){

            ArrayList<Jugador> players = new ArrayList<>();

            for(PlayerEntity playerEntity : matchEntity.getPlayers()){
                Jugador player = convert(playerEntity);
                long idLong = playerEntity.getId();
                int id = (int)idLong;
                player.setIdJugador(id);
                players.add(player);
            }

            match = modelMapper.map(matchEntity, Match.class);

            match.setPlayers(players);

        }

        return match;

    }

    Jugador convert(PlayerEntity p){

        String type = p.getTipo();
        Jugador player = null;

        switch(type){

            case "user": player = modelMapper.map(p, Player.class);
                player.setIdJugador(1);

                break;

            case "conservador": player = modelMapper.map(p, BotConservador.class);
                player.setIdJugador(2);
                break;

            case "equilibrado": player = modelMapper.map(p, BotEquilibrado.class);
                player.setIdJugador(3);

                break;

            case "equilibrado2": player = modelMapper.map(p, BotEquilibrado.class);
                player.setIdJugador(5);
                break;

            case "agresivo": player = modelMapper.map(p, BotAgresivo.class);
                player.setIdJugador(4);
                break;
        }
        return player;
    }


    @Transactional
    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);

    }


    @Transactional
    @Override
    public void updateMatch(Match match) {
        MatchEntity existingMatchEntity = matchRepository.findById(match.getId())
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));

        existingMatchEntity.setModo(match.getModo());
        existingMatchEntity.setMontoGanador(match.getMontoGanador());
        existingMatchEntity.setMatchStatus(match.getMatchStatus());
        existingMatchEntity.setDificultad(match.getDificultad());

        existingMatchEntity.getPlayers().clear();

        for (Jugador jugador : match.getPlayers()) {
            PlayerEntity playerEntity = modelMapper.map(jugador, PlayerEntity.class);
            playerEntity.setMatch(existingMatchEntity);
            existingMatchEntity.getPlayers().add(playerEntity);
        }

        entityManager.merge(existingMatchEntity);

        entityManager.flush();
    }


}
