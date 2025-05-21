package com.edutech.contenido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.contenido.model.Contenido;
import com.edutech.contenido.repository.ContenidoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContenidoService {

    @Autowired
    private ContenidoRepositoryJPA contenidoRepository;

    public List<Contenido> getContenidos() {
        return contenidoRepository.findAll();
    }

    public Contenido saveContenido(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public Contenido getContenido(int id) throws Exception {
        return contenidoRepository.findById(id)
            .orElseThrow(() -> new Exception("Contenido no encontrado con id " + id));
    }

    public void deleteContenido(int id) {
        contenidoRepository.deleteById(id);
    }
}
