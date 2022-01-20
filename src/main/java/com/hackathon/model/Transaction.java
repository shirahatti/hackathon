package com.org.mybank.model;


import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "transistion_id")	
	private long transistion_id;
	
	@Column(name = "account_number")	
	private long accountNumber;
	
	
	@Column(name = "beneficiary_account_number")	
	private long beneficiary_account_number;
	
	@Column(name = "amount")	
	private long amount;
	
	@Column(name = "transaction_date")	
	private Date transactionDate;
	
	@Column(name = "transaction_type")	
	private String transaction_type;
	
	@Column(name = "comments")	
	private String comments;

	public long getTransistion_id() {
		return transistion_id;
	}

	public void setTransistion_id(long transistion_id) {
		this.transistion_id = transistion_id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBeneficiary_account_number() {
		return beneficiary_account_number;
	}

	public void setBeneficiary_account_number(long beneficiary_account_number) {
		this.beneficiary_account_number = beneficiary_account_number;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
}
