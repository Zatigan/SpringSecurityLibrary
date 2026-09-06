package co.simplon.springSecurity_library.dto;

import java.time.Year;

public record BookInputDto(
    String title,
    String author,
    String category,
    Year publishedYear,
    Byte availableCopies
) { }
