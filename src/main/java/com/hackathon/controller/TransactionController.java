package com.org.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.mybank.model.Account;
import com.org.mybank.model.FundTransferDetail;
import com.org.mybank.service.AccountService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
	@Autowired
	private AccountService accountService;

   
    @PostMapping("/transfer")
	public Account  transferFund(@RequestBody FundTransferDetail fundTransferDetail) {
		return accountService.transferFund(fundTransferDetail);
	}
	
}
