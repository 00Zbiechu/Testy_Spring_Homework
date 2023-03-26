package pl.testy.zadanie.testy_spring_homework.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDTO {

    private Long id;
    private String streetName;
    private String communeCode;
    private String houseNumber;
    private String flatNumber;
    private boolean defaultAddress;

}
