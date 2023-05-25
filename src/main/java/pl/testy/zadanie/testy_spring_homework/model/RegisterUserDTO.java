package pl.testy.zadanie.testy_spring_homework.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class RegisterUserDTO extends UsernamePasswordDTO{

    @Email
    private String email;


}
