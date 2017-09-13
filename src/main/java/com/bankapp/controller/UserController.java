package com.bankapp.controller;

import java.util.Date;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	

	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void postUser(@RequestBody User user) {
		System.out.println("username test...............................");
		System.out.println(user.getUsername());
		userRepository.save(new User(user.getName(), user.getUsername(), user.getPassword(),"user@test.xx", new Date()));
	}
	
	
	
	
/**
 * This is also a working POST method for registering users to database
 */
//	@RequestMapping(value="/register", method=RequestMethod.POST)
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		System.out.println("creating user:" + user.getName());
//		
//		userRepository.save(new  User(user.getName(), user.getUserName(),
//				user.getPassword(), "test@test", new Date()));
//		return new ResponseEntity<User>(HttpStatus.CREATED);
//	}
	
	

	
	
	
	
	
	
//	private String name;
	
	// Create user
	
//	@PostMapping("/users")
//	public void createUser(String name) {
//		
//		if (name == null)
//		{
//			System.out.println("error no name");
//		}
//		else
//		{
//			try
//			{
//				User user = new User(name, "test", "test", "test", new Date());
//				userRepository.save(user);
//			}
//			catch (Exception e)
//			{
//				System.out.println("error: "+e);
//			}
//		}
//		
//		
//
//	}
//	
//	@PostMapping("/testUsers")
//	public void test() {
//		System.out.println("testing");
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		System.out.println("saved name");
//		this.name = name;
//	}
	
	
}
