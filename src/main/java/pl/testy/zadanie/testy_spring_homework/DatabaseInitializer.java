package pl.testy.zadanie.testy_spring_homework;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final PersonReposiotry personReposiotry;

    private final AddressRepository addressRepository;

    @PostConstruct
    public void initDatabase() {

        Person person = Person.builder()
                .firstName("Mateusz")
                .lastName("Zbiewski")
                .birthDate(LocalDate.now())
                .build();

        personReposiotry.save(person);


        Address address = Address.builder()
                .communeCode("75-400")
                .streetName("Podgorna")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(false)
                .person(person)
                .build();

        addressRepository.save(address);


        Address addressSecond = Address.builder()
                .communeCode("75-420")
                .streetName("Baltycka")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(true)
                .person(person)
                .build();

        addressRepository.save(addressSecond);


    }


}
