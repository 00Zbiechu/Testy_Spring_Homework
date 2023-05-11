package pl.testy.zadanie.testy_spring_homework.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.testy.zadanie.testy_spring_homework.model.PersonEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByUsername(String username);
}
