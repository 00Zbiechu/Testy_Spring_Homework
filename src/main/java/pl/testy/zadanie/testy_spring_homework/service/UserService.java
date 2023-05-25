package pl.testy.zadanie.testy_spring_homework.service;


import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.model.RegisterUserDTO;
import pl.testy.zadanie.testy_spring_homework.model.UsernamePasswordDTO;

import java.util.Optional;

public interface UserService {

    PersonEntity findByUsername(String username);

    Optional<PersonEntity> findOptionalByUsername(String username);

    void createUser(String username,String email, String password);
}
