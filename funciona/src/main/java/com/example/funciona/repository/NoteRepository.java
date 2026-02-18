package com.example.funciona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.funciona.model.Note;
import com.example.funciona.model.User;


public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
}
