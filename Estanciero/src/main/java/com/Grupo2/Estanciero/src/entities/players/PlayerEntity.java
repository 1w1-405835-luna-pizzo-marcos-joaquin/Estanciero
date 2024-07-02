package com.Grupo2.Estanciero.src.entities.players;

import com.Grupo2.Estanciero.src.entities.MatchEntity;
import com.Grupo2.Estanciero.src.entities.PropertyEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class PlayerEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id",  nullable = false)
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    @Column
    private String nombre;

    @Column
    private int dinero;


    @Column
    private int capitalTotal;

    @Column
    private int casillaActual;

    @Column
    private boolean preso;

    @Column
    private int turnosPreso;

    @Column
    Integer turno;

    @Column
    String tipo;
}
