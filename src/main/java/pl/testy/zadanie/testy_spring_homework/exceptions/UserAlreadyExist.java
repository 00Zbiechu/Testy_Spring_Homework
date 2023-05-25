package pl.testy.zadanie.testy_spring_homework.exceptions;

public class UserAlreadyExist extends RuntimeException{

    public UserAlreadyExist(String username){
        super(String.format("User exist"));
    }

}
