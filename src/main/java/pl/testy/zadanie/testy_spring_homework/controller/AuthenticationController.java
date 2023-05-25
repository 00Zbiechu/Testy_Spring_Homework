package pl.testy.zadanie.testy_spring_homework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testy.zadanie.testy_spring_homework.exceptions.InvalidTokenException;
import pl.testy.zadanie.testy_spring_homework.model.*;
import pl.testy.zadanie.testy_spring_homework.service.JwtService;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final JwtService jwtService;

	@PostMapping
	public ResponseEntity<AuthenticationDTO> authenticate(@Valid @RequestBody UsernamePasswordDTO usernamePasswordDTO){
		return ResponseEntity.ok(jwtService.auth(usernamePasswordDTO));
	}
	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@RequestBody TokenDTO tokenDTO){
		jwtService.logout(tokenDTO);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/refreshToken")
	public ResponseEntity<AuthenticationDTO> refreshToken(@RequestBody TokenDTO tokenDTO) throws InvalidTokenException {
		return ResponseEntity.ok(jwtService.refreshToken(tokenDTO));
	}
	@PostMapping("/checkToken")
	public ResponseEntity<CheckTokenDTO> checkToken(@RequestBody AccessTokenDTO accessTokenDTO) {
		return ResponseEntity.ok(jwtService.checkToken(accessTokenDTO));
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@Valid @RequestBody RegisterUserDTO usernamePasswordDTO){
		jwtService.register(usernamePasswordDTO);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}
}
