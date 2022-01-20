package com.org.mybank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mybank.model.Account;
import com.org.mybank.model.FundTransferDetail;
import com.org.mybank.model.Transaction;
import com.org.mybank.repositary.AccountRepository;
import com.org.mybank.repositary.TransactionRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository  accountRepository;
	
	@Autowired
	private TransactionRepository  transactionRepository;
	
	@Override
	public Account findByUserId(long user_id){
		Account accountDetail= accountRepository.findByUserId(user_id);
		List<Transaction> transactions = transactionRepository.findTop4ByAccountNumberOrderByTransactionDateDesc(accountDetail.getAccountNumber());
		accountDetail.setTransactions(transactions);
		return accountDetail;
		
	}
	
	@Override
	public Account transferFund(FundTransferDetail fundTransferDetail){
		Account accountDetail= accountRepository.findByUserId(fundTransferDetail.getUser_id());
		
		Transaction newTransaction=new Transaction();
		newTransaction.setAccountNumber(accountDetail.getAccountNumber());
		newTransaction.setBeneficiary_account_number(fundTransferDetail.getBeneficiary_account_number());
		newTransaction.setAccountNumber(accountDetail.getAccountNumber());
		newTransaction.setAmount(fundTransferDetail.getAmount());
		
		transactionRepository.save(newTransaction);
		return accountDetail;
	}

}
