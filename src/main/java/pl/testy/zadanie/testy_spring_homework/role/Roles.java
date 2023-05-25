package pl.testy.zadanie.testy_spring_homework.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Roles {

    USER("ROLE_USER");

    private final String name;
}
