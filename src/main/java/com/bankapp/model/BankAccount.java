package com.bankapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	

	@Column
	private double balance;

	public BankAccount() {
		// empty constructor
	}
	
	

//	public BankAccount(User user, double balance) {
//		super();
//		this.user = user;
//		this.balance = balance;
//	}



	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	public void addBalance(double amount) {
		this.balance += amount;
	}

}
