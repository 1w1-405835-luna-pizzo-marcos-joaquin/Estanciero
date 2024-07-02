package com.Grupo2.Estanciero.src.controllers;

import com.Grupo2.Estanciero.src.dtos.MatchDto;
import com.Grupo2.Estanciero.src.dtos.players.PlayerDto;
import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.Dificultad;
import com.Grupo2.Estanciero.src.models.Jugador;
import com.Grupo2.Estanciero.src.models.Match;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/match/{id}")
    public ResponseEntity<ArrayList<PlayerDto>> getPlayer(@PathVariable("id") Long id){

         ArrayList<JugadorService> players = playerService.getPlayerByMatch(id);
         ArrayList<PlayerDto> playersDto = new ArrayList<>();

         for(JugadorService j : players){
             PlayerDto p = modelMapper.map(j, PlayerDto.class);
             playersDto.add(p);
         }

        return ResponseEntity.ok(playersDto);
    }

    @DeleteMapping("/deleteAll")
    public  void deleteAll(){

        playerService.deleteAll();

    }


    @GetMapping("getAll")
    public ResponseEntity<ArrayList<PlayerDto>> gatPlayers(){
        ArrayList<Jugador> players = playerService.getAll();
        ArrayList<PlayerDto> playersDtos = new ArrayList<>();

        for(Jugador j : players){
            PlayerDto playerDto = modelMapper.map(j, PlayerDto.class);
            playersDtos.add(playerDto);
        }

        return ResponseEntity.ok(playersDtos);

    }
}
