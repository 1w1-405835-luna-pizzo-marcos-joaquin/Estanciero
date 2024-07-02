package com.Grupo2.Estanciero.src.repositories;

import com.Grupo2.Estanciero.src.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

}
