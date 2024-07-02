package com.Grupo2.Estanciero.src.repositories;

import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
