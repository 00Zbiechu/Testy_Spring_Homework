package pl.testy.zadanie.testy_spring_homework.service;

public interface TokenBlackListService {

    boolean isTokenInBlacklist(String token);

}
