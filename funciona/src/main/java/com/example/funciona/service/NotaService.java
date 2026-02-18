package com.example.funciona.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.funciona.model.User;
import com.example.funciona.model.Note;
import com.example.funciona.repository.NoteRepository;

@Service
public class NotaService {
    
private NoteRepository repository;

public NotaService(NoteRepository repository) {
    this.repository = repository;
}

private User getUser(){
    return(User) SecurityContextHolder
    .getContext().getAuthentication().getPrincipal();
}

public List<Note> getMyNotes(){
     return repository.findByUser(getUser());
}

public void create(String titulo, String conteudo){
        Note n = new Note();
        n.setTitulo(titulo);
        n.setConteudo(conteudo);
        n.setUser(getUser());

        repository.save(n);
}

}
