package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.MatchEntity;
import com.Grupo2.Estanciero.src.models.Dificultad;
import com.Grupo2.Estanciero.src.models.Match;
import com.Grupo2.Estanciero.src.models.MatchStatus;
import com.Grupo2.Estanciero.src.repositories.MatchRepository;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MatchServiceImpTest {

    @Autowired
    private MatchRepository matchRepository;

    @InjectMocks
    MatchServiceImp matchService;

    @Autowired
    TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void createMatchTest() {

    }

    @Test
    void getMatchByIdTest() {

    }

    @Test
    void getMatchTest() {
    }

    @Test
    void deleteMatchTest() {
    }

    @Test
    void updateMatchTest() {
    }
}