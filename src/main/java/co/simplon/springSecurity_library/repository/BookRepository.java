package co.simplon.springSecurity_library.repository;

import co.simplon.springSecurity_library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {

    public Optional<BookEntity> findById(UUID id);
}
