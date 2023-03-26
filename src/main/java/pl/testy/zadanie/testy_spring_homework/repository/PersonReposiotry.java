package pl.testy.zadanie.testy_spring_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.testy.zadanie.testy_spring_homework.entity.Person;

@Repository
public interface PersonReposiotry extends JpaRepository<Person, Long> {
}
