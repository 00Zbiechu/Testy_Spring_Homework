package pl.testy.zadanie.testy_spring_homework.validator;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.testy.zadanie.testy_spring_homework.component.TimeProvider;
import pl.testy.zadanie.testy_spring_homework.exceptions.WrongBirthdayException;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonValidatorTest {

    @Mock
    TimeProvider timeProvider;

    @InjectMocks
    PersonValidator personValidator;

    @ParameterizedTest(name = "For Birthday at {0} method should return {1}")
    @MethodSource("argumentsForValidationMethodTest")
    void validate(LocalDate birthday, boolean expectedResult) {
        //given
        Mockito.when(timeProvider.getLocalDate()).thenReturn(LocalDate.now());
        PersonDTO personDTO = PersonDTO.builder().birthDate(birthday).build();

        //when
        boolean result = personValidator.validate(personDTO);

        //then
        assertAll(
                ()->assertEquals(expectedResult,result)
        );

    }

    public static Stream<Arguments> argumentsForValidationMethodTest(){

        return Stream.of(
                Arguments.of(LocalDate.now(),false),
                Arguments.of(LocalDate.now().minus(99,ChronoUnit.YEARS),true),
                Arguments.of(LocalDate.now().minus(18,ChronoUnit.YEARS),true),
                Arguments.arguments(LocalDate.now().plus(20,ChronoUnit.YEARS),false)

        );

    }

    @Test
    public void should_throw_exception_for_birthday_equal_null(){

        //given
        PersonDTO personDTO = PersonDTO.builder().birthDate(null).build();

        //then
        assertThrows(WrongBirthdayException.class,() -> personValidator.validate(personDTO));


    }
}