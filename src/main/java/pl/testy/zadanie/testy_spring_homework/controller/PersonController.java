package pl.testy.zadanie.testy_spring_homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.service.PersonService;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController extends BaseController<PersonDTO, PersonService>{

    private final PersonService personService;

    @Override
    protected PersonService getService() {
        return personService;
    }
}
