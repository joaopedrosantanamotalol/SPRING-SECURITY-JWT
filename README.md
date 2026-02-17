# SPRING-SECURITY-JWT

Estrutura do projeto
```
src/main/java/com/seuprojeto/
│
├── controller/
│   ├── AuthController.java          # Login e registro (HTML)
│   └── NoteController.java          # Páginas de notas
│
├── model/
│   ├── User.java                    # Usuário
│   └── Note.java                    # Nota
│
├── repository/
│   ├── UserRepository.java
│   └── NoteRepository.java
│
├── service/
│   ├── AuthService.java             # Lógica de login/registro
│   ├── NoteService.java             # Lógica de CRUD de notas
│   └── JwtService.java              # Geração e validação de token
│
├── security/
│   ├── JwtFilter.java               # Intercepta requests e valida JWT
│   └── SecurityConfig.java          # Configuração Spring Security
│
├── config/
│   └── PasswordConfig.java          # Bean BCryptPasswordEncoder
│
└── dto/
    ├── NoteDTO.java                 # Dados para criar nota
    ├── LoginDTO.java                # Dados do login
    ├── RegisterDTO.java             # Dados do registro
    └── AuthResponse.java            # Resposta do login (token)

```
Dependências Principais
```
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-security
spring-boot-starter-thymeleaf
jjwt
```
