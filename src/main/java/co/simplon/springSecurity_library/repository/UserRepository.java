package co.simplon.springSecurity_library.repository;

import co.simplon.springSecurity_library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    public Optional<UserEntity> findByUsername(String username);
    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
}
