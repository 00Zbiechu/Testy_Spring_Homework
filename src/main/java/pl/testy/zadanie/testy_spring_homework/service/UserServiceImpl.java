package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.mockito.internal.util.collections.Sets;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.entity.Role;
import pl.testy.zadanie.testy_spring_homework.exceptions.PersonNotFoundException;

import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.model.RegisterUserDTO;
import pl.testy.zadanie.testy_spring_homework.model.UsernamePasswordDTO;
import pl.testy.zadanie.testy_spring_homework.repository.UserRepository;
import pl.testy.zadanie.testy_spring_homework.role.Roles;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public PersonEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new PersonNotFoundException(username));
    }

    @Override
    public Optional<PersonEntity> findOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(String username,String email, String password) {
        PersonEntity person = PersonEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .active(1)
                .build();

        Role userRoleEntity = Role.builder()
                .personEntity(person)
                .name(Roles.USER.getName())
                .build();

        person.setRoleEntity(Sets.newSet(userRoleEntity));
        userRepository.save(person);


    }
}
