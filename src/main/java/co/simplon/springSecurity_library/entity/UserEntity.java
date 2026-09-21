package co.simplon.springSecurity_library.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

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

    private Collection<? extends GrantedAuthority> authorities;

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

    public void setUsername(@Nonnull String username) {
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

    // Override obligatoire pour pouvoir gérer les rôles (nommer authorities par SpringSecurity
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // permet à Spring Security de connaître les roles de l'utilisateur
        return this.authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
