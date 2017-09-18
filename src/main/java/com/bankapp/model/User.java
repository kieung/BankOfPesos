package com.bankapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/**
 * 
 * @author kieunguy
 *
 * @Entity tells Hibernate to create a table of this class
 */

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private BankAccount bankAccount;

	@Column
	private String name;

	@Column
	private String username;

	@Column
	private String password;


	@ElementCollection
	List<String> roles = new ArrayList<String>();
	
	
	

	public User() {
	}
	
	

//	public User(BankAccount bankAccount, String name, String username, String password, List<String> roles) {
//		super();
//		this.bankAccount = bankAccount;
//		this.name = name;
//		this.username = username;
//		this.password = password;
//		this.roles = roles;
//	}
	
	public User(BankAccount bankAccount, String name, String username, String password) {
		this.bankAccount = bankAccount;
		this.name = name;
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}
	
	

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	/*
	 * public void setId(int id) { this.id = id; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	




}
