package com.org.mybank.service;

import java.util.List;

import com.org.mybank.model.Account;
import com.org.mybank.model.FundTransferDetail;

public interface AccountService {
	Account findByUserId(long user_id);
	
	Account transferFund(FundTransferDetail fundTransferDetail);
}
