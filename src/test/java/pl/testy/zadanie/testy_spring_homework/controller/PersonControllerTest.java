package pl.testy.zadanie.testy_spring_homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.testy.zadanie.testy_spring_homework.common.BaseApiTest;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;


class PersonControllerTest extends BaseApiTest {

    private final String PERSON_CONTROLLER_PATH = "/api/person";


    @Autowired
    private PersonReposiotry personReposiotry;



}