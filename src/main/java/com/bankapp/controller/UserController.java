package com.bankapp.controller;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView showRegistration(ModelAndView modelAndView) {
		
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
				
	}
	
	@RequestMapping(value="/access-denied", method=RequestMethod.POST)
	public ModelAndView processRegistration(ModelAndView modelAndView, User user) {
		userRepository.save(user);
		modelAndView.setViewName("access-denied");
		return modelAndView;
			
	}
	
	
	
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
