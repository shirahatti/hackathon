package com.org.mybank.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.mybank.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	//List<Account> findAccountDetailByUser_UserId(String username);
	Account findByUserId(long userId);

}