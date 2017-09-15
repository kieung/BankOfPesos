package com.bankapp.dao;

import com.bankapp.model.BankAccount;

public interface TransferDao {
	
	public void InitiateTransfer(BankAccount initiator, BankAccount recipient, double amount);
}
