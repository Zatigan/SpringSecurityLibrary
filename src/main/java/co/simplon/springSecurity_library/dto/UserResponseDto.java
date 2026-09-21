package co.simplon.springSecurity_library.dto;

import java.util.UUID;

public record UserResponseDto(
        String username,
        String email
) {
}
