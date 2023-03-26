package pl.testy.zadanie.testy_spring_homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private AddressDTO defaultAddress;
    private List<AddressDTO> addresses;
}
