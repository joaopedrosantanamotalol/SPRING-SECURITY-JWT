package com.example.funciona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.funciona.service.NotaService;

import org.springframework.ui.Model;


@Controller
public class NoteController {

    private NotaService service;    

    public NoteController(NotaService service) {
        this.service = service;
    }

    @GetMapping("/notes")
    public String page(Model model){

        model.addAttribute("notes",
            service.getMyNotes());

        return "notes";
    }

    @PostMapping("/notes")
    public String create(String titulo,String conteudo){

        service.create(titulo,conteudo);

        return "redirect:/notes";
    }
}
