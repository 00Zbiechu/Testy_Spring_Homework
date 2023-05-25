package pl.testy.zadanie.testy_spring_homework.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntityDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer active;

}
