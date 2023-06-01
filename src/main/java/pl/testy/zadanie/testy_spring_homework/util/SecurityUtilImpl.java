package pl.testy.zadanie.testy_spring_homework.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SecurityUtilImpl implements SecurityUtil {

    public String getCurrentUsername(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(String.class::cast)
                .orElse(null);
    }

}
