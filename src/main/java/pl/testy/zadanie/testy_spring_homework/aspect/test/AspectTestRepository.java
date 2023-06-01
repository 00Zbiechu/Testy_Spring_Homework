package pl.testy.zadanie.testy_spring_homework.aspect.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;

@Repository
public interface AspectTestRepository extends JpaRepository<PersonEntity,Long> {
}
