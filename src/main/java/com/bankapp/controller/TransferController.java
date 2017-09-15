package com.bankapp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dao.TransferDaoImpl;
import com.bankapp.model.BankAccount;
import com.bankapp.model.Transfer;
import com.bankapp.model.User;
import com.bankapp.repository.BankRepository;
import com.bankapp.repository.TransferRepository;
import com.bankapp.repository.UserRepository;

@RestController
public class TransferController {
	
	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	TransferRepository tr;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankAccountRepository;

	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public void testTransfer() throws Exception {
		
		try
		{
			TransferDaoImpl transferDao = new TransferDaoImpl();
			
			User initiator = userRepository.findOneByUsername("1");
			User recipient = userRepository.findOneByUsername("2");
			
			BankAccount b1 = initiator.getBankAccount();
			BankAccount b2 = recipient.getBankAccount();
			
			// The transfer constructor both creates the transfer and performs the transaction, so all there's left to do is save to DB
			Transfer transfer = new Transfer(b1, b2, 50); // FIXME: LocalDateTime now being saved properly to DB
			
			transferRepository.save(transfer);
			bankAccountRepository.save(b1);
			bankAccountRepository.save(b2);
		}
		catch (Exception e)
		{
			System.out.println("error: "+e.getMessage());
		}
	}
}
