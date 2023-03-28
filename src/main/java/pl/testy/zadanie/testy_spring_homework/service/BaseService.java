package pl.testy.zadanie.testy_spring_homework.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.mapper.BaseMapper;
import pl.testy.zadanie.testy_spring_homework.validator.BaseValidator;

import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseService<E,D> {

    protected abstract JpaRepository<E,Long> getRepository();

    protected abstract BaseValidator<D> getValidator();

    protected abstract BaseMapper<E,D> getMapper();

    public List<D> get() {
        return getRepository().findAll().stream().map(getMapper()::toDTO).collect(Collectors.toList());
    }

    public E create(D dto){
        E entity = getMapper().toEntity(dto);
        getRepository().save(entity);
        return entity;
    }

    public void update(Long id,D dto){
        getRepository().deleteById(id);
        getRepository().save(getMapper().toEntity(dto));
    }

    public void delete(Long id){
        getRepository().deleteById(id);
    }



}
