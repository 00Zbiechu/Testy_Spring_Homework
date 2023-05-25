package pl.testy.zadanie.testy_spring_homework.validator;

import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.model.PersonEntityDTO;

@Component
public class PersonEntityValidator implements BaseValidator<PersonEntityDTO> {
    @Override
    public boolean validate(PersonEntityDTO dto) {
        return false;
    }
}
