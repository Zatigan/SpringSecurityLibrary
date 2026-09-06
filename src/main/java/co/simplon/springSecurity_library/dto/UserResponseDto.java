package co.simplon.springSecurity_library.dto;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String username,
        String email,
        String password
) {
}
