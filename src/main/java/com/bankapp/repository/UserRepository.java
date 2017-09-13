package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
