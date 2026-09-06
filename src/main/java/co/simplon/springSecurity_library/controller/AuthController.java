package co.simplon.springSecurity_library.controller;

import co.simplon.springSecurity_library.dto.UserCreationDto;
import co.simplon.springSecurity_library.dto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public AuthController() {}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserCreationDto user) {
        return userService.createNewUser(user);
    }


}
