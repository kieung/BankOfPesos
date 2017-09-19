package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Long>{
	
	public BankRepository findOneById(long id);
	

}
