package com.bankapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
