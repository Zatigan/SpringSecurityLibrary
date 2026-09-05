package co.simplon.springSecurity_library.mappers;

import co.simplon.springSecurity_library.dto.BookInputDto;
import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponseDTO fromEntityToDto(BookEntity book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getPublishedYear(),
                book.getAvailableCopies()
        );
    }

    public BookEntity fromDtoToEntity(BookInputDto bookData) {
    // Le pattern Builder est pertinent pour la création d'un nouvel élément
        return BookEntity
                .builder()
                .title(bookData.title())
                .author(bookData.author())
                .category(bookData.category())
                .publishedYear(bookData.publishedYear())
                .availableCopies(bookData.availableCopies())
                .build();
    }

    public void updateEntityFromDto(BookEntity book, BookInputDto bookData) {
        // Pattern d'attribution à la mano pour mettre à jour un élément existant en PUT
        book.setTitle(bookData.title());
        book.setAuthor(bookData.author());
        book.setCategory(bookData.category());
        book.setPublishedYear(bookData.publishedYear());
        book.setAvailableCopies(bookData.availableCopies());
    }
}
