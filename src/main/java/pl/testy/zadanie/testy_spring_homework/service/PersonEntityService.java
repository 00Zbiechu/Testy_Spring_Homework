package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.mapper.BaseMapper;
import pl.testy.zadanie.testy_spring_homework.mapper.PersonEntityMapper;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonEntityDTO;
import pl.testy.zadanie.testy_spring_homework.repository.PersonEntityRepository;
import pl.testy.zadanie.testy_spring_homework.validator.BaseValidator;
import pl.testy.zadanie.testy_spring_homework.validator.PersonEntityValidator;

@Service
@RequiredArgsConstructor
public class PersonEntityService extends BaseService<PersonEntity, PersonEntityDTO> {

    private final PersonEntityRepository personEntityRepository;

    private final PersonEntityValidator personEntityValidator;

    private final PersonEntityMapper personEntityMapper;

    @Override
    protected JpaRepository<PersonEntity, Long> getRepository() {
        return personEntityRepository;
    }

    @Override
    protected BaseValidator<PersonEntityDTO> getValidator() {
        return personEntityValidator;
    }

    @Override
    protected BaseMapper<PersonEntity, PersonEntityDTO> getMapper() {
        return personEntityMapper;
    }
}
