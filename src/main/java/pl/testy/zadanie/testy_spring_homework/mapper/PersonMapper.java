package pl.testy.zadanie.testy_spring_homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.util.List;
import java.util.stream.Collectors;



@Mapper(uses = {PersonMapper.class,AddressMapper.class}, componentModel = "spring")
public interface PersonMapper extends BaseMapper<Person, PersonDTO> {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    default PersonDTO toDTO(Person person){
        return PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .birthDate(person.getBirthDate())
                .defaultAddress(person.getAddress().stream()
                        .filter(Address::isDefaultAddress)
                        .distinct().map(AddressMapper.INSTANCE::toDTO)
                        .toList().get(0))
                .addresses(person.getAddress().stream()
                        .filter(e-> !e.isDefaultAddress())
                        .map(AddressMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

}
