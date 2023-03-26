package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.mapper.AddressMapper;
import pl.testy.zadanie.testy_spring_homework.mapper.BaseMapper;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.validator.AddressValidator;
import pl.testy.zadanie.testy_spring_homework.validator.BaseValidator;

@Service
@RequiredArgsConstructor
public class AddressService extends BaseService<Address, AddressDTO> {

    private final AddressRepository addressRepository;
    private final AddressValidator addressValidator;
    private final AddressMapper addressMapper;

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected BaseValidator<AddressDTO> getValidator() {
        return addressValidator;
    }

    @Override
    protected BaseMapper<Address, AddressDTO> getMapper() {
        return addressMapper;
    }
}
