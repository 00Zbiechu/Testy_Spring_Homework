package pl.testy.zadanie.testy_spring_homework.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonMapperTest {

    @Mock
    Person person;

    @Mock
    PersonDTO personDTO;

    @Test
    void method_toDTO_should_return_PersonDTO(){

        //given
        Mockito.when(person.getFirstName()).thenReturn("Mateusz");
        Mockito.when(person.getLastName()).thenReturn("Zbiewski");
        Mockito.when(person.getBirthDate()).thenReturn(LocalDate.now());
        Mockito.when(person.getAddress()).thenReturn(
                List.of(
                        Address.builder()
                        .streetName("Testowa")
                        .communeCode("75")
                        .defaultAddress(true)
                        .flatNumber("12")
                        .houseNumber("13").build(),

                        Address.builder()
                                .streetName("Testowa")
                                .communeCode("75")
                                .defaultAddress(false)
                                .flatNumber("12")
                                .houseNumber("13").build()
        ));

        //when
        PersonDTO personDTO = PersonMapper.INSTANCE.toDTO(person);

        //then
        assertAll(
                ()->assertEquals(person.getFirstName(),personDTO.getFirstName()),
                ()->assertEquals(person.getLastName(),personDTO.getLastName()),
                ()->assertEquals(person.getBirthDate(),personDTO.getBirthDate()),
                ()->assertEquals(person.getAddress().get(0).getStreetName(),personDTO.getAddresses().get(0).getStreetName()),
                ()->assertEquals(person.getAddress().get(0).getFlatNumber(),personDTO.getAddresses().get(0).getFlatNumber()),
                ()->assertEquals(person.getAddress().get(0).getHouseNumber(),personDTO.getAddresses().get(0).getHouseNumber()),
                ()->assertEquals(person.getAddress().get(0).getCommuneCode(),personDTO.getAddresses().get(0).getCommuneCode())
        );


    }


    @Test
    void method_toEntity_should_return_Person(){

        //given
        Mockito.when(personDTO.getFirstName()).thenReturn("Mateusz");
        Mockito.when(personDTO.getLastName()).thenReturn("Zbiewski");
        Mockito.when(personDTO.getBirthDate()).thenReturn(LocalDate.now());


        //when
        Person person1 = PersonMapper.INSTANCE.toEntity(personDTO);


        //then
        assertAll(
                ()->assertEquals(personDTO.getFirstName(),person1.getFirstName()),
                ()->assertEquals(personDTO.getLastName(),person1.getLastName()),
                ()->assertEquals(personDTO.getBirthDate(),person1.getBirthDate())
        );


    }


}