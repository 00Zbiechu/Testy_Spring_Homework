package pl.testy.zadanie.testy_spring_homework.validator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.testy.zadanie.testy_spring_homework.component.TimeProvider;
import pl.testy.zadanie.testy_spring_homework.exceptions.WrongBirthdayException;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
@Getter
public class PersonValidator implements BaseValidator<PersonDTO> {

    private final TimeProvider timeProvider;

    @Override
    public boolean validate(PersonDTO dto) {
        if(dto.getBirthDate().isAfter(timeProvider.getLocalDate().minus(18,ChronoUnit.YEARS))){

            return false;

        } else if (dto.getBirthDate()==null) {

            throw new WrongBirthdayException("Wrong date");

        }
        return true;
    }
}
