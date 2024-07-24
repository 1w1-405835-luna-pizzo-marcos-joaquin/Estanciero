package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.MatchEntity;
import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.*;
import com.Grupo2.Estanciero.src.repositories.MatchRepository;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MatchServiceImpTest {

    @MockBean
    private MatchRepository matchRepository;

    @SpyBean
    MatchService matchService;

    @MockBean
    Tablero tablero;

    @MockBean
    EntityManager entityManager;

    @Test
    void createMatchTest() {

        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setDificultad(Dificultad.EASY);
        matchEntity.setModo(1);

        when(matchRepository.save(Mockito.any())).thenReturn(matchEntity);

        ArrayList<JugadorService> playersService = new ArrayList<>();

        Match matchResult = matchService.createMatch(playersService, 1, 1, 1);
        Assertions.assertNotNull(matchEntity);
        assertEquals(Dificultad.EASY, matchResult.getDificultad());
        assertEquals(1, matchResult.getModo());

    }

    @Test
    void getMatchByIdTest() {

        when(matchRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> matchService.getMatchById(1L));

        MatchEntity matchEntity = new MatchEntity();
        when(matchRepository.findById(2L)).thenReturn(Optional.of(matchEntity));
        Match matchResult = matchService.getMatchById(2L);
        Assertions.assertNotNull(matchResult);

    }

    @Test
    void getMatchTest() {

        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setMatchStatus(MatchStatus.FINISH);
        matchEntity.setModo(2);
        matchEntity.setDificultad(Dificultad.HARD);
        matchEntity.setPlayers(new ArrayList<>());


        List<MatchEntity> matchEntities = new ArrayList<>();
        matchEntities.add(matchEntity);
        when(matchRepository.findAll()).thenReturn(matchEntities);
        Match testResult = matchService.getMatch();
        Assertions.assertNotNull(testResult);
        Assertions.assertEquals(Dificultad.HARD, testResult.getDificultad());
        Assertions.assertEquals(2, testResult.getModo());
        Assertions.assertEquals(MatchStatus.FINISH, testResult.getMatchStatus());
    }

    @Test
    void deleteMatchTest() {
        matchService.deleteMatch(1L);
        verify(matchRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateMatchTest() {

        // CASO 1: No encontro ningun match para actualizar
        Match match = new Match();
        match.setId(1L);
        match.setPlayers(new ArrayList<>());

        when(matchRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> matchService.updateMatch(match));

        //CASO 2: Si lo encontro y lo actualiza
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setMatchStatus(MatchStatus.FINISH);
        matchEntity.setModo(2);
        matchEntity.setDificultad(Dificultad.HARD);
        matchEntity.setPlayers(new ArrayList<>());

        when(matchRepository.findById(1L)).thenReturn(Optional.of(matchEntity));

        matchService.updateMatch(match);
        verify(entityManager, times(1)).merge(matchEntity);
        verify(entityManager, times(1)).flush();
    }
}