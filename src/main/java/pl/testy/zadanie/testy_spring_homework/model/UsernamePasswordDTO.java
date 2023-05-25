package pl.testy.zadanie.testy_spring_homework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordDTO {

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{5,15}")
    private String username;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{3,20}")
    private String password;
}
