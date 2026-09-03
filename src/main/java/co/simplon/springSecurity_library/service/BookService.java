package co.simplon.springSecurity_library.service;

import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.entity.BookEntity;
import co.simplon.springSecurity_library.mappers.BookMapper;
import co.simplon.springSecurity_library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    BookService(BookRepository bookRepositoryInjected,
                BookMapper bookMapperInjected) {
        this.bookRepository = bookRepositoryInjected;
        this.bookMapper = bookMapperInjected;
    }

    public List<BookResponseDTO> getAllBooks() {
        List<BookEntity> allBooks = bookRepository.findAll();
        return allBooks.stream()
                .map(book -> bookMapper.fromEntitytoDto(book))
                .toList();
    }

    public BookResponseDTO getOneBook(UUID id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow();
        return bookMapper.fromEntitytoDto(book);
    }
}
