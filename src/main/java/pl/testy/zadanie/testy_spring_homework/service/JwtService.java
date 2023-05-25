package pl.testy.zadanie.testy_spring_homework.service;


import pl.testy.zadanie.testy_spring_homework.exceptions.InvalidTokenException;
import pl.testy.zadanie.testy_spring_homework.model.*;

public interface JwtService {
    AuthenticationDTO auth(UsernamePasswordDTO usernamePasswordDTO);

    void logout(TokenDTO tokenDTO);

    AuthenticationDTO refreshToken(TokenDTO tokenDTO) throws InvalidTokenException;

    CheckTokenDTO checkToken(AccessTokenDTO accessTokenDTO);

    String getUsernameFromAccessToken(String accessToken);

    void register(RegisterUserDTO usernamePasswordDTO);
}
