package com.hackthon.bankApplication.controller;

import com.hackthon.bankApplication.dto.StatusEnum;
import com.hackthon.bankApplication.exception.AccountNotFoundException;
import com.hackthon.bankApplication.exception.InvalidUserException;
import com.hackthon.bankApplication.response.Response;
import com.hackthon.bankApplication.serviceImplementation.AccountServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping("account/")
public class AccountController {

    @Autowired
    AccountServiceImplementation service;

    @GetMapping("/summary/{userId}")
    public ResponseEntity<Response> getAccountSummary(@PathVariable Long userId) throws InvalidUserException, AccountNotFoundException {
        HttpStatus httpstatus = null;
        Response response = service.getAccountSummary(userId);
        if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
            httpstatus= HttpStatus.NOT_FOUND;
        }
        else {
            httpstatus=HttpStatus.OK;
        }
        return new ResponseEntity<>(response,httpstatus);
    }
}
