package com.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long beneficiaryId;
	private Long accountNumber;
	private Long beneficiaryAccountNumber;
	private String ifscCode;
	private String shortName;
	private String beneficiaryBankName;
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getBeneficiaryBankName() {
		return beneficiaryBankName;
	}

	public void setBeneficiaryBankName(String beneficiaryBankName) {
		this.beneficiaryBankName = beneficiaryBankName;
	}
}
