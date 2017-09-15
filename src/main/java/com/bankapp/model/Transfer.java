package com.bankapp.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "transfer")
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) 
	@JoinColumn
	private BankAccount initiator;
	
	
	@ManyToOne(fetch=FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(insertable=false, updatable=false)
	private BankAccount recipient;
	
	private double amount;
	
	private LocalDateTime localDateTime;
	
	
	
	
	public Transfer(BankAccount initiator, BankAccount recipient, double amount, LocalDateTime localDateTime) {
		super();
		this.initiator = initiator;
		this.recipient = recipient;
		this.amount = amount;
		this.localDateTime = localDateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
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
	
	
	
}
