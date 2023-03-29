package pl.testy.zadanie.testy_spring_homework.exceptions;

public class WrongAddressList extends RuntimeException{
    public WrongAddressList(String message) {
        super(message);
    }
}
