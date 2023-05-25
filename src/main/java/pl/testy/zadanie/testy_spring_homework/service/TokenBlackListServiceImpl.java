package pl.testy.zadanie.testy_spring_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.testy.zadanie.testy_spring_homework.repository.TokenBlacklistRepository;

@Service
@RequiredArgsConstructor
public class TokenBlackListServiceImpl implements TokenBlackListService {

    private final TokenBlacklistRepository tokenBlacklistRepository;


    @Override
    public boolean isTokenInBlacklist(String token) {
        return tokenBlacklistRepository.existsByToken(token);
    }
}
