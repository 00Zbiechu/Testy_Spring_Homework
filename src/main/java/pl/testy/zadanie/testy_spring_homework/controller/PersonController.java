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


    @PostMapping("/save")
    public PersonListResponse save(@RequestBody PersonDTO personDTO){
        return new PersonListResponse(personService.create(personDTO));
    }


    @PutMapping("/update/{id}")
    public PersonListResponse put(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        return new PersonListResponse(personService.update(id,personDTO));
    }


    @DeleteMapping("/delete/{id}")
    public PersonListResponse deleteById(@PathVariable Long id){
        return new PersonListResponse(personService.delete(id));
    }

}
