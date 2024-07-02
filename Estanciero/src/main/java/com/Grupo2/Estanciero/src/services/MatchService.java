package com.Grupo2.Estanciero.src.services;

import com.Grupo2.Estanciero.src.dtos.MatchDto;
import com.Grupo2.Estanciero.src.models.Dificultad;
import org.springframework.stereotype.Service;
import com.Grupo2.Estanciero.src.models.Match;

import java.util.ArrayList;

@Service
public interface MatchService {

    Match createMatch(ArrayList<JugadorService> players, int difficulty, int modo, int capitalParaGanar);
    Match getMatchById(Long id);
    Match getMatch();
    void deleteMatch(Long id);
    void updateMatch(Match match);


}
