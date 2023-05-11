package pl.testy.zadanie.testy_spring_homework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordDTO {
    private String username;
    private String password;
}
