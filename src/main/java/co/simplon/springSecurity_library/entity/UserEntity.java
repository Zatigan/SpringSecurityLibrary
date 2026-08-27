package co.simplon.springSecurity_library.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull //Annotation pour dire à Java que ça doit pas être null
    @Column(length = 100,
            nullable = false, // Indication côté bdd que le champ ne peut pas être null
            unique = true)  // Indication que chaque valeur sera unique
    private String name;

    @Nonnull
    @Column(length = 100,
            nullable = false,
            unique = true)
    private String email;

    @Nonnull
    @Column(length = 50,
            nullable = false)
    private String password;

}
