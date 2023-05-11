package pl.testy.zadanie.testy_spring_homework.exceptions;

public class TokenUserMismatchException extends RuntimeException {
    public TokenUserMismatchException(String message) {
        super(message);
    }
}
