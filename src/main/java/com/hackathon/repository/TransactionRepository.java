package com.org.mybank.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.mybank.model.Account;
import com.org.mybank.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findTop4ByAccountNumberOrderByTransactionDateDesc(long userId);
	
	//List<Transaction> save(long userId);

}