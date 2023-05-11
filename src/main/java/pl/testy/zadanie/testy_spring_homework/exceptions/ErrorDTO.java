package pl.testy.zadanie.testy_spring_homework.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class ErrorDTO {

    private String code;
    private Timestamp timestamp;
    private String message;
}
