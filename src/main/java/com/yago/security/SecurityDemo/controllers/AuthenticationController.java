package com.yago.security.SecurityDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yago.security.SecurityDemo.domain.user.AuthenticationDTO;
import com.yago.security.SecurityDemo.domain.user.LoginResponseDTO;
import com.yago.security.SecurityDemo.domain.user.RegisterDTO;
import com.yago.security.SecurityDemo.domain.user.User;
import com.yago.security.SecurityDemo.infra.security.TokenService;
import com.yago.security.SecurityDemo.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO dto) {
		if(this.repository.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
		User newUser = new User(dto.login(), encryptedPassword, dto.role());
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}
