package com.bankapp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.BankAccount;
import com.bankapp.model.Transfer;
import com.bankapp.model.User;
import com.bankapp.repository.BankRepository;
import com.bankapp.repository.TransferRepository;
import com.bankapp.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankAccountRepository;
	
	@Autowired
	TransferRepository transferRepository;
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		//Check if the username exists. Dont allow to create the same username
		
		if(userRepository.findOneByUsername(user.getUsername()) != null) {
			throw new RuntimeException("Username already exists");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		
		user.setRoles(roles);
				
		BankAccount account = new BankAccount();
		account.setBalance(100);
		account.setUser(user);
		
		bankAccountRepository.save(account);
		
		userRepository.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED); 
		
				
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestParam String username,
			@RequestParam String password, HttpServletResponse response) throws IOException {
		
		//token variable
		String token = null;
		User user = userRepository.findOneByUsername(username);
		
		//create a hashmap to associate user and token
		Map<String, Object> tokenMap = new HashMap<String, Object>();
		
		
		//check if password is correct
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
			
			//create the token using Jwt
			token = Jwts.builder().setSubject(username).claim("roles", user.getRoles()).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			
			tokenMap.put("token", token);
			tokenMap.put("user", user);
			return new ResponseEntity<Map<String,Object>>(tokenMap, HttpStatus.OK);
		
		//send empty token if not satisfied for authorization
		}else {
			tokenMap.put("token", null);
			return new ResponseEntity<Map<String,Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
		}
				
	}
	
}
