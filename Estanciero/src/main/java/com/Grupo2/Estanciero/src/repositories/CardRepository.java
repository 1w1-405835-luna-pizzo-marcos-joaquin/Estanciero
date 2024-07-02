package com.Grupo2.Estanciero.src.repositories;

import com.Grupo2.Estanciero.src.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
