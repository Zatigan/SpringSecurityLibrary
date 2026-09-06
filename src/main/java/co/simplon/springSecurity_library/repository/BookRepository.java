package co.simplon.springSecurity_library.repository;

import co.simplon.springSecurity_library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    // Pas besoin d'écrire les méthods les plus simples en SQL ici.
    // JpaRepository en fourni déjà un certain nombre par défaut
}
