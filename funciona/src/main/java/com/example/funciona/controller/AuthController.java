package com.example.funciona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.funciona.service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    private AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
public String login(String email, String senha, HttpServletResponse response, Model model) {
    try {
        // AuthService vai validar e gerar token
        String token = auth.login(email, senha);

        // criar cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return "redirect:/notes"; // login ok
    } catch (Exception e) {
        model.addAttribute("error", "Usuário ou senha incorretos");
        return "login";
    }
}
@GetMapping("/logout")
public String logout(HttpServletResponse response) {
    // Cria um cookie vazio com mesmo nome, com expiração imediata
    Cookie cookie = new Cookie("token", null);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(0); // expira imediatamente
    response.addCookie(cookie);

    return "redirect:/login"; // manda de volta pro login
}

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(String email, String senha, Model model) {
        try {
            auth.register(email, senha);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao registrar usuário: " + e.getMessage());
            return "register";
        }
    }
}
