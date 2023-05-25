package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.entity.PersonEntity;
import pl.testy.zadanie.testy_spring_homework.entity.Role;
import pl.testy.zadanie.testy_spring_homework.repository.RoleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonEntity personEntity = userService.findByUsername(username);
        return new User(personEntity.getUsername(), personEntity.getPassword(),
                getAuthorityForUser(personEntity));
    }

    private Set<SimpleGrantedAuthority> getAuthorityForUser(PersonEntity personEntity) {

        return personEntity.getRoleEntity().stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

    }
}
