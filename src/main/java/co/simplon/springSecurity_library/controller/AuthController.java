package co.simplon.springSecurity_library.controller;

import co.simplon.springSecurity_library.dto.UserCreationDto;
import co.simplon.springSecurity_library.dto.UserResponseDto;

import co.simplon.springSecurity_library.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final AuthService authService;


    public AuthController(
            AuthenticationManager authManagerInjected,
            TokenService tokenServiceInjected,
            AuthService authServiceInjected
    ) {
        this.authManager = authManagerInjected;
        this.tokenService = tokenServiceInjected;
        this.authService = authServiceInjected;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserCreationDto user) {
        return authService.createNewUser(user);
    }


}
