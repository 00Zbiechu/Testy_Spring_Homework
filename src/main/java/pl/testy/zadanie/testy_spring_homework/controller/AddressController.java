package pl.testy.zadanie.testy_spring_homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController extends BaseController<AddressDTO, AddressService> {

    private final AddressService addressService;

    @Override
    protected AddressService getService() {
        return addressService;
    }
}
