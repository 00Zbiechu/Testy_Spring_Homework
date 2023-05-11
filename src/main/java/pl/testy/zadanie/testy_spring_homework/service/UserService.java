package pl.testy.zadanie.testy_spring_homework.service;


import pl.testy.zadanie.testy_spring_homework.model.PersonEntity;

public interface UserService {

    PersonEntity findByUsername(String username);
}
