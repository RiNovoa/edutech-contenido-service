package com.edutech.contenido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.contenido.model.Contenido;

@Repository
public interface ContenidoRepositoryJPA extends JpaRepository<Contenido, Integer> {
}
