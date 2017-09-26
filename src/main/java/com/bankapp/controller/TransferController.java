package com.bankapp.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class TransferController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankAccountRepository;
	
	@Autowired
	TransferRepository transferRepository;
	
	
	@RequestMapping(value="/home", method=RequestMethod.POST) 
	public ResponseEntity<Transfer> transfer(Principal principal, @RequestParam String recipient,  @RequestParam double amount, 
			@RequestParam String message, HttpServletResponse response) throws IOException {
		
		//check if recipient username exist in database
		if (userRepository.findOneByUsername(recipient) == null) {
			throw new RuntimeException("Recipient does not exists !");
		}
		
		//sender username
		String senderUsername = principal.getName();
		
		//sender User object
		User sender = userRepository.findOneByUsername(senderUsername);
		long senderId = sender.getId();
		
		//recipient User object
		User recipientObject = userRepository.findOneByUsername(recipient);
		long recipientId = recipientObject.getId();
		
		
		BankAccount senderAccount = bankAccountRepository.findOne(senderId);
		BankAccount recipientAccount = bankAccountRepository.findOne(recipientId);
		
		//create a new Transfer transaction
		Transfer transfer = new Transfer(senderAccount, recipientAccount, amount);
		transfer.setMessage(message);
		
		//save updates in bankaccounts and transfer history
		bankAccountRepository.save(senderAccount);
		bankAccountRepository.save(recipientAccount);
		transferRepository.save(transfer);
		
		
		return new ResponseEntity<Transfer>(HttpStatus.OK);
		
		
	}

	
}
