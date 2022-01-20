package com.hackthon.bankApplication.service;

import com.hackthon.bankApplication.exception.InvalidUserException;
import com.hackthon.bankApplication.response.Response;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {
    Response getAccountSummary(Long userId) throws AccountNotFoundException, InvalidUserException, com.hackthon.bankApplication.exception.AccountNotFoundException;
}
