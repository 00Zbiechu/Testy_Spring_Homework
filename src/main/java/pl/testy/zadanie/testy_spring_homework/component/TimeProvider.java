package pl.testy.zadanie.testy_spring_homework.component;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TimeProvider {

    public LocalDate getLocalDate(){
        return LocalDate.now();
    }

}
