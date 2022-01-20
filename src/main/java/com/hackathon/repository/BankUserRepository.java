package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long>{
	

}
