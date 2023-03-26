package pl.testy.zadanie.testy_spring_homework.mapper;

public interface BaseMapper <E,D>{


    E toEntity(D dto);

    D toDTO(E entity);


}
