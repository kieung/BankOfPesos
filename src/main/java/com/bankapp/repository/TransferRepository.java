package com.bankapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bankapp.model.BankAccount;
import com.bankapp.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{
	
		
		@Query("SELECT p FROM Transfer p WHERE p.initiator = :account")
		public List<Transfer> findByUserId(@Param("account") BankAccount account);
	
	
}
