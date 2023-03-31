package pl.testy.zadanie.testy_spring_homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.util.List;
import java.util.stream.Collectors;



@Mapper(uses = {PersonMapper.class}, componentModel = "spring")
public interface PersonMapper extends BaseMapper<Person, PersonDTO> {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source="id", target="id")
    @Mapping(source="firstName", target="firstName")
    @Mapping(source="lastName", target="lastName")
    @Mapping(source="birthDate", target="birthDate")
    @Mapping(source="address",target="defaultAddress", qualifiedByName = "addressToDefaultAddress")
    @Mapping(source="address",target="addresses", qualifiedByName = "noAddressToDefaultAddress")
    PersonDTO toDTO(Person person);


    @Named("addressToDefaultAddress")
    default AddressDTO addressToDefaultAddress(List<Address> address){

        return address.stream()
                .filter(Address::isDefaultAddress)
                .distinct().map(AddressMapper.INSTANCE::toDTO)
                .toList().get(0);

    }


    @Named("noAddressToDefaultAddress")
    default List<AddressDTO> noAddressToDefaultAddress(List<Address> address){

        return address.stream()
                .filter(e-> !e.isDefaultAddress())
                .map(AddressMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

    }

}
