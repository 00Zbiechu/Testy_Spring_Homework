package pl.testy.zadanie.testy_spring_homework;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final PersonReposiotry personReposiotry;

    private final AddressRepository addressRepository;





}
