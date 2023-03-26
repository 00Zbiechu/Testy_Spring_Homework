package pl.testy.zadanie.testy_spring_homework.validator;

public interface BaseValidator<D> {

    boolean validate(D dto);

}
