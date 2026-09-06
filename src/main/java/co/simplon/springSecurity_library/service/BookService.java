package co.simplon.springSecurity_library.service;

import co.simplon.springSecurity_library.dto.BookInputDto;
import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.entity.BookEntity;
import co.simplon.springSecurity_library.exceptions.BookNotFoundException;
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
                .map(book -> bookMapper.fromEntityToDto(book))
                .toList();
    }

    public BookResponseDTO getOneBook(UUID id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow();
        return bookMapper.fromEntityToDto(book);
    }

    public BookResponseDTO updateBook(UUID id, BookInputDto submittedBook) {
        BookEntity bookToUpdate = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Identifiant invalide, livre non trouvé"));
        // Utilisation d'une erreur déjà prévue par Java / Spring

        bookMapper.updateEntityFromDto(bookToUpdate, submittedBook);

        BookEntity saveBook = bookRepository.save(bookToUpdate);

        return bookMapper.fromEntityToDto(saveBook);
    }

    public BookResponseDTO addOneBook(BookInputDto submittedBook) {
        BookEntity newBook = bookMapper.fromDtoToEntity(submittedBook);

        BookEntity saveBook = bookRepository.save(newBook);

        return bookMapper.fromEntityToDto(saveBook);
    }

    // Version brutasse de la route DELETE
    /* public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
     } */

    // Version plus élaborée de la route DELETE
    public void deleteBook(UUID id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        // Utilisation d'une erreur personnalisée

        bookRepository.deleteById(id);
    }

}
