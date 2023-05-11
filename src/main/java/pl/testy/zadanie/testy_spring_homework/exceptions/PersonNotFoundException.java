package pl.testy.zadanie.testy_spring_homework.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String username) {
        super(String.format("User with username %s not found", username));
    }
}
