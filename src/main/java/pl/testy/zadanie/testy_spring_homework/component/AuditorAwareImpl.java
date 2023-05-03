package pl.testy.zadanie.testy_spring_homework.component;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Mateusz");
    }
}
