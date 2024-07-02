package com.Grupo2.Estanciero.src.entities;

import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import com.Grupo2.Estanciero.src.models.Dificultad;
import com.Grupo2.Estanciero.src.models.MatchStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "matches")
public class MatchEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "match",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PlayerEntity> players;

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

    @Column
    private int modo;

    @Column
    private int montoGanador;

    @Column
    private LocalDateTime createAt;
    @Column
    private LocalDateTime updateAt;

}
