package co.simplon.springSecurity_library.dto;

import java.time.Year;

public record BookCreationDTO(
    String title,
    String author,
    String category,
    Year publishedYear,
    Byte availableCopies) { }
