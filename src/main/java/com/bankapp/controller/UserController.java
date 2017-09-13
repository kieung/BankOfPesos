package com.bankapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	private String name;
	
	// Create user
	
	@PostMapping("/users")
	public void createUser(String name) {
		
		if (name == null)
		{
			System.out.println("error no name");
		}
		else
		{
			try
			{
				User user = new User(name, "test", "test", "test", new Date());
				userRepository.save(user);
			}
			catch (Exception e)
			{
				System.out.println("error: "+e);
			}
		}
		
		

	}
	
	@PostMapping("/testUsers")
	public void test() {
		System.out.println("testing");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("saved name");
		this.name = name;
	}
	
	
}
