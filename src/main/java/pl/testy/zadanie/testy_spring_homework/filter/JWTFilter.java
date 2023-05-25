package pl.testy.zadanie.testy_spring_homework.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.testy.zadanie.testy_spring_homework.service.JwtService;
import pl.testy.zadanie.testy_spring_homework.service.TokenBlackListService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_TOKEN = "Bearer ";

    private final TokenBlackListService tokenBlackListService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String authorizationHeaderValue = request.getHeader(AUTHORIZATION_HEADER);

        if (isNotEmpty(authorizationHeaderValue)
                && authorizationHeaderValue.startsWith(BEARER_TOKEN)) {


            String token = extractBearerToken(authorizationHeaderValue);

            if(!tokenBlackListService.isTokenInBlacklist(token)){

                String username = jwtService.getUsernameFromAccessToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());


                SecurityContextHolder.getContext().setAuthentication(authentication);


            }


        }
        filterChain.doFilter(request,response);

    }

    private boolean isNotEmpty(String authorizationHeaderValue) {
        return authorizationHeaderValue != null && authorizationHeaderValue.length()>0;
    }

    private String extractBearerToken(String authorizationHeaderValue) {
        return authorizationHeaderValue.substring(7);
    }
}
