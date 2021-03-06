package com.bankapp.model;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "transfer")

public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) 
	@JoinColumn
	@JsonIgnore
	private BankAccount initiator;
	
	
	@ManyToOne(fetch=FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private BankAccount recipient;
	
	private double amount;
	
	private Date localDateTime;
	
	private String message;
	
	
	
	//WARN: Default constructor must be added to facilitate Hibernate
	public Transfer() {
		
	}
	
	
	public Transfer(BankAccount initiator, BankAccount recipient, double amount) {
		super();
		this.initiator = initiator;
		this.recipient = recipient;
		this.amount = amount;
		this.localDateTime = new Date(); // FIXME: LocalDateTime now being saved properly to DB
		
		initiator.addBalance(-amount);
		recipient.addBalance(amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(Date localDateTime) {
		this.localDateTime = localDateTime;
	}

	public long getId() {
		return id;
	}


	public BankAccount getInitiator() {
		return initiator;
	}

	public void setInitiator(BankAccount initiator) {
		this.initiator = initiator;
	}

	public BankAccount getRecipient() {
		return recipient;
	}

	public void setRecipient(BankAccount recipient) {
		this.recipient = recipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
