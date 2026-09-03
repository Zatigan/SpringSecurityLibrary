package co.simplon.springSecurity_library.mappers;

import co.simplon.springSecurity_library.dto.BookCreationDTO;
import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponseDTO fromEntitytoDto(BookEntity book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getPublishedYear(),
                book.getAvailableCopies()
        );
    }
}
