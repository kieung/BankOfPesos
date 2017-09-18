package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{
	
	
}
