package com.bankapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	public User(){}
	
	public User(int id, String name, String userName, String password, String email, Date createdAt) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
	}
	
	@Id
	private int id;
	
	private String name;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private Date createdAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
