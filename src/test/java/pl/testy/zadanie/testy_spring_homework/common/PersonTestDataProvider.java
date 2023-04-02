package pl.testy.zadanie.testy_spring_homework.common;

import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.time.LocalDate;
import java.util.List;

public class PersonTestDataProvider {


    public static List<Person> prepareMockData(){
        return List.of(
                Person.builder()
                        .id(1L)
                        .firstName("Test")
                        .lastName("Test")
                        .birthDate(LocalDate.now())
                        .build(),
                Person.builder()
                        .id(2L)
                        .firstName("Test2")
                        .lastName("Test2")
                        .birthDate(LocalDate.now())
                        .build(),
                Person.builder()
                        .id(3L)
                        .firstName("Test3")
                        .lastName("Test3")
                        .birthDate(LocalDate.now())
                        .build()
        );
    }


}
