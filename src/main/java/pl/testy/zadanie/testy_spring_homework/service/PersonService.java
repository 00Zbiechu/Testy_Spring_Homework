package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.exceptions.WrongAddressList;
import pl.testy.zadanie.testy_spring_homework.mapper.AddressMapper;
import pl.testy.zadanie.testy_spring_homework.mapper.BaseMapper;
import pl.testy.zadanie.testy_spring_homework.mapper.PersonMapper;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;
import pl.testy.zadanie.testy_spring_homework.validator.BaseValidator;
import pl.testy.zadanie.testy_spring_homework.validator.PersonValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService extends BaseService<Person, PersonDTO> {

    private final PersonReposiotry personReposiotry;
    private final PersonValidator personValidator;
    private final PersonMapper personMapper;

    //Address
    /*
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    */


    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return personReposiotry;
    }

    @Override
    protected BaseValidator<PersonDTO> getValidator() {
        return personValidator;
    }

    @Override
    protected BaseMapper<Person, PersonDTO> getMapper() {
        return personMapper;
    }

    /*
    @Override
    public Person create(PersonDTO dto) {

        List<AddressDTO> listOfAddressDTOWhichShouldBeEmpty = dto.getAddresses().stream()
                .filter(AddressDTO::isDefaultAddress)
                .toList();

        if(!dto.getDefaultAddress().isDefaultAddress()){
            throw new WrongAddressList("Default address isn't default");
        }else if(listOfAddressDTOWhichShouldBeEmpty.size()>0){
            throw new WrongAddressList("Address list contains default address");
        }else{


            //przemapowanie na person, żeby ustawić address
            Person person = personMapper.INSTANCE.toEntity(dto);
            //zapisanie person do db - bez adresów
            personReposiotry.save(person);


            //ustawienie default addresu dla person i jego zapisanie do bazy
            Address addressDefault = addressMapper.toEntity(dto.getDefaultAddress());
            addressDefault.setPerson(person);
            addressRepository.save(addressDefault);


            //pobranie wszystkich adresów dla person z dto
            List<Address> addresses = dto.getAddresses().stream().map(addressMapper::toEntity).toList();

            //ustawienie dla adresów person
            //zapisanie adresów do bazy
            for (Address address: addresses) {
                address.setPerson(person);
                addressRepository.save(address);
            }




            return person;
        }
        */



}
