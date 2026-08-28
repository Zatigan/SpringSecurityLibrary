package co.simplon.springSecurity_library.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull //Annotation pour dire à Java que ça doit pas être null
    @Column(length = 100,
            nullable = false, // Indication côté bdd que le champ ne peut pas être null
            unique = true)  // Indication que chaque valeur sera unique
    private String username;

    @Nonnull
    @Column(length = 100,
            nullable = false,
            unique = true)
    private String email;

    // constructeur vide (ça sert toujours)
    public UserEntity() {
    }
    // constructeur plein
    public UserEntity(@Nonnull String username, @Nonnull String email, @Nonnull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Nonnull
    @Column(length = 50,
            nullable = false)
    private String password;

    public UUID getId() {
        return id;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    public void setName(@Nonnull String username) {
        this.username = username;
    }

    @Nonnull
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }
}
