package pl.testy.zadanie.testy_spring_homework.validator;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;

@Component
public class AddressValidator implements BaseValidator<AddressDTO> {
    @Override
    public boolean validate(AddressDTO dto) {
        return false;
    }
}
