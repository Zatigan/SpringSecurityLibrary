package co.simplon.springSecurity_library.dto;

public record UserCreationDto(
        String username,
        String email,
        String password
) {
}
