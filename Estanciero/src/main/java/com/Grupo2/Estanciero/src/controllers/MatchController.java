package com.Grupo2.Estanciero.src.controllers;

import com.Grupo2.Estanciero.src.dtos.MatchDto;
import com.Grupo2.Estanciero.src.models.Match;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/get/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable("id") Long id) {

        Match match = matchService.getMatchById(id);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        return ResponseEntity.ok(matchDto);
    }

    @GetMapping(("/get/All"))
    public ResponseEntity<MatchDto> getMatch() {
        Match match = matchService.getMatch();

        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        return ResponseEntity.ok(matchDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
    }


    @PostMapping("/create")
    public ResponseEntity<MatchDto> createMatch() {

        ArrayList<JugadorService> j = new ArrayList<>();

        Match match = matchService.createMatch(j, 1, 1, 50000);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        return ResponseEntity.ok(matchDto);
    }

}
