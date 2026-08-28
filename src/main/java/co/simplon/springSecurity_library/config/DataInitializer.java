package co.simplon.springSecurity_library.config;

import co.simplon.springSecurity_library.entity.BookEntity;
import co.simplon.springSecurity_library.entity.UserEntity;
import co.simplon.springSecurity_library.repository.UserRepository;
import co.simplon.springSecurity_library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DataInitializer(
            UserRepository userRepositoryInjected,
            BookRepository bookRepositoryInjected) {
        this.userRepository = userRepositoryInjected;
        this.bookRepository = bookRepositoryInjected;
    }

    @Override
    public void run(String... args) throws Exception {
        // Construction d'une entité de façon classique
        this.bookRepository.save(new BookEntity(null, "Ilium", "Dan Simmons", "Science-fiction", Year.of(2003), Byte.valueOf("1")));

        // Utilisation de l'annotation Builder de Lombok pour créer une même entité
        this.bookRepository.save(BookEntity.builder()
                .title("Olympos")
                .author("Dan Simmons")
                .category("Science-fiction")
                .publishedYear(Year.of(2008))
                .availableCopies((byte) 2)
                .build());

        UserEntity user1 = new UserEntity("Pierre", "moi@example.com", "123456");
        userRepository.save(user1);
        UserEntity user2 = new UserEntity("Autre", "lui@example.com", "123456");
        userRepository.save(user2);
    }
}
