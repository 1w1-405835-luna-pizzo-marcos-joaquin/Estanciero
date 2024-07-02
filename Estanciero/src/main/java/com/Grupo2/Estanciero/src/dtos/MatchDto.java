package com.Grupo2.Estanciero.src.dtos;

import com.Grupo2.Estanciero.src.dtos.players.PlayerDto;
import com.Grupo2.Estanciero.src.models.Dificultad;
import com.Grupo2.Estanciero.src.models.MatchStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private ArrayList<PlayerDto> players;

    private Dificultad dificultad;

    private MatchStatus matchStatus;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
