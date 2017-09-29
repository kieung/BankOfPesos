package com.bankapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.BankAccount;
import com.bankapp.model.Transfer;
import com.bankapp.model.User;
import com.bankapp.repository.BankRepository;
import com.bankapp.repository.TransferRepository;
import com.bankapp.repository.UserRepository;

@RestController
public class BankAccountController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	TransferRepository transferRepository;
	
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public double getAccountBalance(Principal principal) {
		
		String activerUserName = principal.getName();
		
		User activeUser = userRepository.findOneByUsername(activerUserName);
		long activeUseriD = activeUser.getId();
		
		BankAccount activeBankAccount = bankRepository.findOne(activeUseriD);
				
		return activeBankAccount.getBalance();
	
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ResponseEntity<List<Transfer>> getTransfers(Principal principal) {
				
		String username = principal.getName();
		
		User user = userRepository.findOneByUsername(username);
		long userId = user.getId();
		
		
		BankAccount userAccount = bankRepository.findOne(userId);
		
		List<Transfer> transfers = new ArrayList<Transfer>();
		
		transfers = transferRepository.findByUserId(userAccount);
		
		
		return new ResponseEntity<List<Transfer>>(transfers, HttpStatus.OK);
	}
	
}
