package pl.testy.zadanie.testy_spring_homework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class AddressListResponse {

    private final List<AddressDTO> addresses;

}
