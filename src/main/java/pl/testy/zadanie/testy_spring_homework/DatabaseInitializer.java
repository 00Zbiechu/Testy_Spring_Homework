package pl.testy.zadanie.testy_spring_homework;

import lombok.AllArgsConstructor;
import org.mockito.internal.util.collections.Sets;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.entity.Role;
import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonEntityRepository;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;
import pl.testy.zadanie.testy_spring_homework.repository.RoleRepository;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final PersonReposiotry personReposiotry;

    private final AddressRepository addressRepository;

    private final RoleRepository roleRepository;

    private final PersonEntityRepository personEntityRepository;

    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initializerUsers(){



        PersonEntity person = PersonEntity.builder()
                .username("Mateusz1")
                .password(passwordEncoder.encode("1234"))
                .active(1)
                .email("zbiewski@gmail.com")
                .build();

        Role admin = Role.builder()
                .name("ADMIN")
                .personEntity(person)
                .build();

        Role user = Role.builder()
                .name("USER")
                .personEntity(person)
                .build();


        person.setRoleEntity(Sets.newSet(admin,user));

        personEntityRepository.save(person);


        PersonEntity person2 = PersonEntity.builder()
                .username("Mateusz2")
                .password(passwordEncoder.encode("1234"))
                .active(1)
                .email("zbiewski@gmail.com")
                .build();

        Role user2 = Role.builder()
                .name("USER")
                .personEntity(person2)
                .build();

        person2.setRoleEntity(Sets.newSet(user2));

        personEntityRepository.save(person2);






    }





}
