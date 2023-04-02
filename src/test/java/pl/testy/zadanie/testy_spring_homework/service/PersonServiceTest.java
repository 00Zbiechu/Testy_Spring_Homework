package pl.testy.zadanie.testy_spring_homework.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.mapper.AddressMapper;
import pl.testy.zadanie.testy_spring_homework.mapper.PersonMapper;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonReposiotry personReposiotry;



    //Nie używam InjectMock, bo repo będzie takie samo dla wszystkich testów, a ja chcę dla każdego testu nowe.
    //@InjectMocks
    PersonService personService;


    @BeforeEach
    void init(){
        personService = new PersonService(personReposiotry,null,PersonMapper.INSTANCE);
    }


    @DisplayName("PersonService get() should return mapped Person with Address List")
    @Test
    void get(){

        //given
        Address address = Address.builder()
                .communeCode("75-400")
                .streetName("Podgorna")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(false)
                .build();

        Address addressDefault = Address.builder()
                .communeCode("75-400")
                .streetName("TEST")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(true)
                .build();

        Person person = Person.builder()
                .firstName("Mateusz")
                .lastName("Zbiewski")
                .birthDate(LocalDate.now())
                .address(List.of(address,addressDefault))
                .build();

        Mockito.when(personReposiotry.findAll()).thenReturn(List.of(person));



        //then
        List<PersonDTO> result = personService.get();



        //result

        //expected
        AddressDTO addressDTO = AddressDTO.builder()
                .communeCode("75-400")
                .streetName("Podgorna")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(false)
                .build();

        AddressDTO addressDTODefault = AddressDTO.builder()
                .communeCode("75-400")
                .streetName("TEST")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(true)
                .build();

        PersonDTO personDTOExpected = PersonDTO.builder()
                .firstName("Mateusz")
                .lastName("Zbiewski")
                .birthDate(LocalDate.now())
                .defaultAddress(addressDTODefault)
                .addresses(List.of(addressDTO))
                .build();

        assertAll(
                ()->assertEquals(personDTOExpected.getFirstName(),result.get(0).getFirstName()),
                ()->assertEquals(personDTOExpected.getLastName(),result.get(0).getLastName()),
                ()->assertEquals(personDTOExpected.getBirthDate(),result.get(0).getBirthDate()),
                    ()->assertEquals(personDTOExpected.getDefaultAddress().getCommuneCode(),result.get(0).getDefaultAddress().getCommuneCode()),
                    ()->assertEquals(personDTOExpected.getDefaultAddress().getStreetName(),result.get(0).getDefaultAddress().getStreetName()),
                    ()->assertEquals(personDTOExpected.getDefaultAddress().getHouseNumber(),result.get(0).getDefaultAddress().getHouseNumber()),
                    ()->assertEquals(personDTOExpected.getDefaultAddress().getFlatNumber(),result.get(0).getDefaultAddress().getFlatNumber()),
                        ()->assertEquals(personDTOExpected.getAddresses().get(0).getCommuneCode(),result.get(0).getAddresses().get(0).getCommuneCode()),
                        ()->assertEquals(personDTOExpected.getAddresses().get(0).getStreetName(),result.get(0).getAddresses().get(0).getStreetName()),
                        ()->assertEquals(personDTOExpected.getAddresses().get(0).getHouseNumber(),result.get(0).getAddresses().get(0).getHouseNumber()),
                        ()->assertEquals(personDTOExpected.getAddresses().get(0).getFlatNumber(),result.get(0).getAddresses().get(0).getFlatNumber())
        );


    }

    @DisplayName("Should delete one person")
    @Test
    void create() {



        doNothing().when(personReposiotry).deleteById(anyLong());

        personService.delete(getRandomInt());
        verify(personReposiotry, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(personReposiotry);
    }

    private Long getRandomInt() {
        return new Random().longs(1, 10).findFirst().getAsLong();
    }




    @DisplayName("Should save one person")
    @Test
    void save(){
        //given
        AddressDTO addressDTO = AddressDTO.builder()
                .communeCode("75-400")
                .streetName("Podgorna")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(false)
                .build();

        AddressDTO addressDTODefault = AddressDTO.builder()
                .communeCode("75-400")
                .streetName("TEST")
                .flatNumber("12")
                .houseNumber("13")
                .defaultAddress(true)
                .build();

        Person personToSave = Person.builder()
                .firstName("Mateusz")
                .lastName("Zbiewski")
                .birthDate(LocalDate.now())
                .build();

        when(personReposiotry.save(any(Person.class))).thenReturn(personToSave);


        //when
        Person actual = personService.create(PersonDTO.builder()
                                                                .firstName("Mateusz")
                                                                .lastName("Zbiewski")
                                                                .birthDate(LocalDate.now())
                                                                .defaultAddress(addressDTODefault)
                                                                .addresses(List.of(addressDTO))
                                                                .build());





        //then
        verify(personReposiotry, times(1)).save(any(Person.class));
        verifyNoMoreInteractions(personReposiotry);
        assertAll(
                ()-> assertEquals(personToSave.getFirstName(),actual.getFirstName()),
                ()-> assertEquals(personToSave.getLastName(),actual.getLastName()),
                ()-> assertEquals(personToSave.getBirthDate(),actual.getBirthDate())
        );


    }

}



