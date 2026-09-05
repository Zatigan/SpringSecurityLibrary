package co.simplon.springSecurity_library.controller;

import co.simplon.springSecurity_library.dto.BookInputDto;
import co.simplon.springSecurity_library.dto.BookResponseDTO;
import co.simplon.springSecurity_library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructeur du controller pour pouvoir l'utiliser ensuite
    public BookController(BookService bookServiceInjected) {
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
    public BookResponseDTO createBook(@RequestBody BookInputDto book) { //possiblement c'est unn bookCreationDTO plutôt que un bookENtity (logique de protection oblige)
        return bookService.addOneBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookResponseDTO updateBook(
            @RequestBody BookInputDto updatedBook,
            @PathVariable UUID id) {
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    // Version brutasse sans retour utilisateur
    public void deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }
}

