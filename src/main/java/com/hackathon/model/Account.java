package com.org.mybank.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "account_number")	
	private long accountNumber;
	
	@Column(name = "user_id")	
	private long userId;
	
	@Column(name = "account_type")	
	private String account_type;
	
	@Column(name = "ifsc_code")	
	private String ifsc_code;
	
	@Column(name = "bank_name")	
	private String bank_name;

	@Column(name = "branch")	
	private String branch;
	
	@Column(name = "available_balance")	
	private long available_balance;
	
	@JoinColumn(name = "account_number")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions;
    
	
	public long getAccountNumber() {
		return accountNumber;
	}
	

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(long available_balance) {
		this.available_balance = available_balance;
	}
	
	
}
