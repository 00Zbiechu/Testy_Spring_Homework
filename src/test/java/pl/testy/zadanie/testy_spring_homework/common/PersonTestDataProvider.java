package pl.testy.zadanie.testy_spring_homework.common;

import pl.testy.zadanie.testy_spring_homework.entity.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonTestDataProvider {


    public static List<Person> prepareMockData(){
        return List.of(
                Person.builder()
                        .firstName("Test")
                        .lastName("Test")
                        .birthDate(LocalDate.now())
                        .build()
        );
    }

}
