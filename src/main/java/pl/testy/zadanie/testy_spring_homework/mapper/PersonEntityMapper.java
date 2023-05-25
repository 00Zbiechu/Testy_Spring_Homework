package pl.testy.zadanie.testy_spring_homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.model.PersonEntityDTO;


@Component
@Mapper(uses = PersonEntityMapper.class, componentModel = "spring")
public interface PersonEntityMapper extends BaseMapper<PersonEntity, PersonEntityDTO> {

    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);

}
