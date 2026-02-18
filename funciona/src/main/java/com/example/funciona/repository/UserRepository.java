package com.example.funciona.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funciona.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
