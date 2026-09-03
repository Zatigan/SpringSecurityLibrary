package co.simplon.springSecurity_library.controller;

import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.entity.BookEntity;
import co.simplon.springSecurity_library.mappers.BookMapper;
import co.simplon.springSecurity_library.repository.BookRepository;
import co.simplon.springSecurity_library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    // Constructeur du controller pour pouvoir l'utiliser ensuite
    public BookController(BookRepository bookRepositoryInjected,
                          BookService bookServiceInjected) {
        this.bookRepository = bookRepositoryInjected;
        this.bookService = bookServiceInjected;
    }

    @GetMapping("")
    public List<BookResponseDTO> getAll() {
        // Pour respecter la séparation des rôles, le Controller se contente
        // d'appeler le bookService qui contient la logique métier
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}") // Paramètre indiqué entre {} car c'est variable
    // PathVariable car c'est directement dans l'URL sans '?' (sinon ce serait un queryParams)
    public BookResponseDTO getOneBook(@PathVariable UUID id) {
        return bookService.getOneBook(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity createBook(@RequestBody BookEntity book) {
        return this.bookRepository.save(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookEntity updateBook(
            @RequestBody BookEntity updatedBook,
            @PathVariable UUID id) {
        return this.bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(updatedBook.getAuthor());
                    book.setTitle(updatedBook.getTitle());
                    book.setCategory(updatedBook.getCategory());
                    book.setPublishedYear(updatedBook.getPublishedYear());
                    book.setAvailableCopies(updatedBook.getAvailableCopies());
                    return this.bookRepository.save(book);
                })
                .orElseThrow(() -> new IllegalArgumentException("Identifiant invalide, livre non trouvé"));
    }
}

