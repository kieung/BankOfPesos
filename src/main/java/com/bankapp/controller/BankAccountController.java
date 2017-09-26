package com.bankapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.BankAccount;
import com.bankapp.model.User;
import com.bankapp.repository.BankRepository;
import com.bankapp.repository.UserRepository;

@RestController
public class BankAccountController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepositry;
	
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public double getBankAccount(Principal principal) {
		
		String activerUserName = principal.getName();
		
		User activeUser = userRepository.findOneByUsername(activerUserName);
		long activeUseriD = activeUser.getId();
		
		BankAccount activeBankAccount = bankRepositry.findOne(activeUseriD);
		
		System.out.println(activeBankAccount.getBalance());
		
		return activeBankAccount.getBalance();
	
	}
	
	
	
	
	
	
	

}
