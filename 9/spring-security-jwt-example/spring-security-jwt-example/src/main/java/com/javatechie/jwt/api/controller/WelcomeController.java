package com.javatechie.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.jwt.api.entity.AuthRequest;
import com.javatechie.jwt.api.util.JwtUtil;

@RestController
public class WelcomeController {
	@Autowired
private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to shubhams code";
		
	}
	@PostMapping("/autenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("invalid username password");
		}
		return jwtutil.generateToken(authRequest.getUserName());
	
	}
}
