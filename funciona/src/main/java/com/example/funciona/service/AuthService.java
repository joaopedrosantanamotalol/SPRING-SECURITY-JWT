package com.example.funciona.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.funciona.model.User;
import com.example.funciona.repository.UserRepository;

@Service
public class AuthService {
    
private UserRepository repo;
private BCryptPasswordEncoder encoder;
private JwtService jwt;

public AuthService(UserRepository repo, BCryptPasswordEncoder encoder, JwtService jwt) {
    this.repo = repo;
    this.encoder = encoder;
    this.jwt = jwt;
}

  public void register(String email,String senha){
        User u = new User();
        u.setEmail(email);
        u.setPassword(encoder.encode(senha));
        repo.save(u);
    }

    public String login(String email,String senha){

        User user = repo.findByEmail(email)
            .orElseThrow();

        if(!encoder.matches(senha,user.getPassword()))
            throw new RuntimeException();

        return jwt.generateToken(email);
    }


}
