package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.exceptions.PersonNotFoundException;

import pl.testy.zadanie.testy_spring_homework.model.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public PersonEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new PersonNotFoundException(username));
    }
}
