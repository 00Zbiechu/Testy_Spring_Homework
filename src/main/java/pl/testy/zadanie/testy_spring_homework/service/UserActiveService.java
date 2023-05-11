package pl.testy.zadanie.testy_spring_homework.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.model.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class UserActiveService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void initUser(){
        userRepository.deleteAll();

        PersonEntity personEntity = PersonEntity.builder()
                .active(1)
                .email("zbiechu@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .username("Zbiechu")
                .build();
        userRepository.save(personEntity);
    }
}
