package pl.testy.zadanie.testy_spring_homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.testy.zadanie.testy_spring_homework.component.AddressRevision;
import pl.testy.zadanie.testy_spring_homework.component.AddressRevisionDTO;
import pl.testy.zadanie.testy_spring_homework.component.EntityVersionReader;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.AddressListResponse;
import pl.testy.zadanie.testy_spring_homework.service.AddressService;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController extends BaseController<AddressDTO, AddressService> {

    private final AddressService addressService;

    private final EntityVersionReader entityVersionReader;

    @Override
    protected AddressService getService() {
        return addressService;
    }


    @GetMapping("/all")
    public AddressListResponse getAll(){
        return new AddressListResponse(addressService.get());
    }

    @PostConstruct
    public void save(){
        AddressDTO addressDTO = AddressDTO.builder()
                .streetName("Kwiatowa")
                .build();

        addressService.create(addressDTO);
    }

    @GetMapping("/audit")
    public Object getAudit(){
        return entityVersionReader.readLog().stream().map(filed -> AddressRevisionDTO.builder()
                .revisionType(filed.getRevisionType())
                .revNumber(filed.getEntity().getId())
                .modifiedBy(filed.getEntity().getModifiedBy())
                .createdBy(filed.getEntity().getCreatedBy())
                .build());
    }


}
