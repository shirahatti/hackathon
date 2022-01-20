package com.hackthon.bankApplication.controller;

import com.hackthon.bankApplication.dto.StatusEnum;
import com.hackthon.bankApplication.exception.AccountNotFoundException;
import com.hackthon.bankApplication.exception.InvalidUserException;
import com.hackthon.bankApplication.response.Response;
import com.hackthon.bankApplication.serviceImplementation.AccountServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class AccountControllerTest {

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountServiceImplementation serviceImplementation;

    Response response = new Response();

    @Test
    public void getAccountSummaryHappyPathTest() throws InvalidUserException, AccountNotFoundException {
        response.setApiStatus(StatusEnum.SUCCESS);
        Mockito.when(serviceImplementation.getAccountSummary(Mockito.anyLong())).thenReturn(response);
        Assertions.assertEquals(HttpStatus.OK, accountController.getAccountSummary(21l).getStatusCode());
    }

    @Test
    public void getAccountSummaryWhenNotFoundTest() throws InvalidUserException, AccountNotFoundException {
        response.setApiStatus(StatusEnum.FAIL);
        Mockito.when(serviceImplementation.getAccountSummary(Mockito.anyLong())).thenReturn(response);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, accountController.getAccountSummary(21l).getStatusCode());
    }

}