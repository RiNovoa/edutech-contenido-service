package com.edutech.contenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutech.contenido.model.Contenido;
import com.edutech.contenido.service.ContenidoService;

@Controller
@RequestMapping("/contenidos")
public class ContenidoVistaController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public String mostrarContenidos(Model model) {
        model.addAttribute("contenidos", contenidoService.getContenidos());
        return "contenidos"; // Plantilla contenidos.html
    }

    @PostMapping("/agregar")
    public String agregarContenido(@ModelAttribute Contenido contenido) {
        contenidoService.saveContenido(contenido);
        return "redirect:/contenidos";
    }
}
