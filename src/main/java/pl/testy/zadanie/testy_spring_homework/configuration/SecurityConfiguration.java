package pl.testy.zadanie.testy_spring_homework.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.testy.zadanie.testy_spring_homework.filter.JWTFilter;
import pl.testy.zadanie.testy_spring_homework.service.JwtService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    private final JWTFilter jwtFilter;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .headers()
                .frameOptions()
                .disable()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/auth/logout").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/aspect-test").permitAll()
                .antMatchers("/api/address/all").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }
}
