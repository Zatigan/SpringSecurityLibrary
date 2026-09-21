package co.simplon.springSecurity_library.service;

import co.simplon.springSecurity_library.dto.UserCreationDto;
import co.simplon.springSecurity_library.dto.UserResponseDto;
import co.simplon.springSecurity_library.entity.UserEntity;
import co.simplon.springSecurity_library.exceptions.UserEmailAlreadyExistsException;
import co.simplon.springSecurity_library.exceptions.UsernameAlreadyExistsException;
import co.simplon.springSecurity_library.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepositoryInjected,
            PasswordEncoder passwordEncoderInjected) {
        this.userRepository = userRepositoryInjected;
        this.passwordEncoder = passwordEncoderInjected;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username))
        ;
    }

    public UserResponseDto createNewUser(UserCreationDto user) {
        if(this.userRepository.existsByUsername(user.username())) {
            throw new UsernameAlreadyExistsException(user.username());
        }

        if(this.userRepository.existsByEmail(user.email())) {
            throw new UserEmailAlreadyExistsException(user.email());
        }

        String hashedPassword = passwordEncoder.encode(user.password());

        UserEntity userToCreate = new UserEntity(user.username(), user.email(), hashedPassword);

        UserEntity savedUser = this.userRepository.save(userToCreate);

        return new UserResponseDto(savedUser.getUsername(), savedUser.getEmail());
    }
}
