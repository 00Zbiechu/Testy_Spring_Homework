package pl.testy.zadanie.testy_spring_homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;

import java.util.List;

@Mapper(uses = AddressMapper.class, componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


}
