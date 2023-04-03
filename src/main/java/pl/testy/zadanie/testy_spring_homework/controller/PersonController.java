package pl.testy.zadanie.testy_spring_homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonListResponse;
import pl.testy.zadanie.testy_spring_homework.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController extends BaseController<PersonDTO, PersonService>{

    private final PersonService personService;

    @Override
    protected PersonService getService() {
        return personService;
    }


    @GetMapping("/all")
    public PersonListResponse getAll(){
        return new PersonListResponse(personService.get());
    }

}
