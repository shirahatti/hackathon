package com.hackthon.bankApplication.serviceImplementation;

import com.hackthon.bankApplication.dto.StatusEnum;
import com.hackthon.bankApplication.entity.Account;
import com.hackthon.bankApplication.entity.User;
import com.hackthon.bankApplication.exception.AccountNotFoundException;
import com.hackthon.bankApplication.exception.InvalidUserException;
import com.hackthon.bankApplication.repository.AccountRepository;
import com.hackthon.bankApplication.repository.UserRepository;
import com.hackthon.bankApplication.response.AccountSummaryResponse;
import com.hackthon.bankApplication.response.Response;
import com.hackthon.bankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {

  @Autowired AccountRepository accountRepository;

  @Autowired UserRepository userRepository;

  @Override
  public Response getAccountSummary(Long userId)
      throws InvalidUserException, AccountNotFoundException {
    Response response = new Response();
    AccountSummaryResponse summaryResponse = new AccountSummaryResponse();
    Optional<User> user = userRepository.findById(userId);
    if (!user.isPresent()) {
      throw new InvalidUserException("Incorrect User Id");
    }
    Optional<Account> account = accountRepository.findByUser(user.get());
    if (account.isPresent()) {

      summaryResponse.setAccountHolderName(
          account.get().getUser().getFirstName() + " " + account.get().getUser().getLastName());
      summaryResponse.setAccountNumber(account.get().getAccountNumber());
      summaryResponse.setAccountType(account.get().getAccountType());
      summaryResponse.setAvailableBalance(account.get().getAvailableBalance());
      summaryResponse.setAccountCreationDate(
          new SimpleDateFormat("yyyy-MM-dd").format(account.get().getAccountCreationDate()));
    } else {
      throw new AccountNotFoundException("Account Not Found");
    }
    response.setApiStatus(StatusEnum.SUCCESS);
    response.setResponseData(summaryResponse);
    return response;
  }
}
