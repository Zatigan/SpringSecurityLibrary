package co.simplon.springSecurity_library.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import java.time.Year;
import java.util.UUID;

@Entity
@Getter // Génère les getters automatiquement
@Setter // Génère les setters automatiquement
@NoArgsConstructor // Génère un constructeur vide
@AllArgsConstructor // Génère un constructeur plein
@Builder
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    @Column(length = 250,
            nullable = false)
    private String title;

    @Nonnull
    @Column(length = 150,
            nullable = false)
    private String author;

    @Nonnull
    @Column(length = 100,
            nullable = false)
    private String category;

    @Nonnull
    @Column(length = 4,
            nullable = false)
    private Year publishedYear;

    @Column
    @ColumnDefault("1")
    private Byte availableCopies = 1;
}
