package pl.testy.zadanie.testy_spring_homework.exceptions;

public class WrongBirthdayException extends RuntimeException{
    public WrongBirthdayException(String message) {
        super(message);
    }
}
