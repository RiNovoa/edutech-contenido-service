package com.edutech.contenido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.contenido.model.Contenido;
import com.edutech.contenido.service.ContenidoService;

@RestController
@RequestMapping("/api/v1/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public ResponseEntity<List<Contenido>> listarContenidos() {
        List<Contenido> contenidos = contenidoService.getContenidos();
        return contenidos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(contenidos);
    }

    @PostMapping
    public ResponseEntity<Contenido> agregarContenido(@RequestBody Contenido contenido) {
        Contenido nuevo = contenidoService.saveContenido(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerContenido(@PathVariable int id) {
        try {
            return ResponseEntity.ok(contenidoService.getContenido(id));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

 @PutMapping("/{id}")
public ResponseEntity<Contenido> actualizarContenido(@PathVariable Integer id, @RequestBody Contenido contenido) {
    try {
        contenidoService.getContenido(id); // valida si existe
        contenido.setId(id);
        return ResponseEntity.ok(contenidoService.saveContenido(contenido));
    } catch (Exception ex) {
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarContenido(@PathVariable int id) {
        try {
            contenidoService.deleteContenido(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
