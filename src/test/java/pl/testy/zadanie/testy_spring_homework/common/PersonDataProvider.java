package pl.testy.zadanie.testy_spring_homework.common;

import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonListResponse;

import java.time.LocalDate;
import java.util.List;

public class PersonDataProvider {


    public static List<Person> prepareMockData(){
        return List.of(
                Person.builder()
                        .firstName("TEST")
                        .lastName("TEST")
                        .birthDate(LocalDate.now())
                        .build(),
                Person.builder()
                        .firstName("TEST")
                        .lastName("TEST")
                        .birthDate(LocalDate.now())
                        .build(),
                Person.builder()
                        .firstName("TEST")
                        .lastName("TEST")
                        .birthDate(LocalDate.now())
                        .build());
    }


    public static PersonListResponse preparePersonListResponse() {
        return new PersonListResponse(
                List.of(
                        PersonDTO.builder()
                                .firstName("Mateusz")
                                .lastName("Wydryszek")
                                .birthDate(LocalDate.of(2010, 1,1))
                                .build(),
                        PersonDTO.builder()
                                .firstName("Jan")
                                .lastName("Kowalski")
                                .birthDate(LocalDate.of(2009, 1,1))
                                .build(),
                        PersonDTO.builder()
                                .firstName("Piotr")
                                .lastName("Nowak")
                                .birthDate(LocalDate.of(2008, 1,1))
                                .build()));
    }

}
