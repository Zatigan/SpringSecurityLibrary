package co.simplon.springSecurity_library.dto;

import java.time.Year;
import java.util.UUID;

public record BookResponseDTO(
        UUID id,
        String title,
        String author,
        String category,
        Year publishedYear,
        Byte availableCopies
) { }
