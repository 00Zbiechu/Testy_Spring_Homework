package pl.testy.zadanie.testy_spring_homework.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Builder
public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private AddressDTO defaultAddress;
    private List<AddressDTO> addresses;
}
