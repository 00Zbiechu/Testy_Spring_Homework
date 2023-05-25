package pl.testy.zadanie.testy_spring_homework.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserActiveService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

}
