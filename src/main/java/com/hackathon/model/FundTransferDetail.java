package com.org.mybank.model;

public class FundTransferDetail {
	
	private long user_id;
	private long beneficiary_account_number;	
	private long amount;
	private String comments;
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
