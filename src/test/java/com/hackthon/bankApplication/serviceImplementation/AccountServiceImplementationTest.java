package com.hackthon.bankApplication.serviceImplementation;

import com.hackthon.bankApplication.dto.StatusEnum;
import com.hackthon.bankApplication.entity.Account;
import com.hackthon.bankApplication.entity.User;
import com.hackthon.bankApplication.exception.AccountNotFoundException;
import com.hackthon.bankApplication.exception.InvalidUserException;
import com.hackthon.bankApplication.repository.AccountRepository;
import com.hackthon.bankApplication.repository.UserRepository;
import com.hackthon.bankApplication.response.AccountSummaryResponse;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AccountServiceImplementationTest {

  @InjectMocks AccountServiceImplementation serviceImplementation;

  @Mock AccountRepository repository;

  @Mock UserRepository userRepository;

  @Test
  void getAccountSummaryHappyPathTest() throws InvalidUserException, AccountNotFoundException {
    User user1 = new User();
    user1.setUserId(1l);
    user1.setFirstName("keshav");
    Optional<User> user = Optional.of(user1);

    Account account1 = new Account();
    account1.setAccountType("Savings");
    account1.setAccountNumber(123l);
    account1.setAccountCreationDate(Date.valueOf("2011-08-12"));
    account1.setAvailableBalance(7987l);
    account1.setBranch("noida");
    account1.setBankName("abc");
    account1.setUser(user1);
    Optional<Account> account = Optional.of(account1);

    Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(user);
    Mockito.when(repository.findByUser(Mockito.any(User.class))).thenReturn(account);
    Assertions.assertEquals(
        StatusEnum.SUCCESS, serviceImplementation.getAccountSummary(1l).getApiStatus());
  }

  @Test
  void getAccountSummaryWhenInvalidUserIdTest() {
    Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));
    Assertions.assertThrows(
        InvalidUserException.class,
        () -> {
          serviceImplementation.getAccountSummary(21l);
        });
  }

  @Test
  void getAccountSummaryWhenAccountNotFoundTest() {
    User user1 = new User();
    user1.setUserId(1l);
    user1.setFirstName("keshav");
    Optional<User> user = Optional.of(user1);

    Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(user);
    Mockito.when(repository.findByUser(Mockito.any(User.class))).thenReturn(Optional.ofNullable(null));
    Assertions.assertThrows(
        AccountNotFoundException.class,
        () -> {
          serviceImplementation.getAccountSummary(21l);
        });
  }
}
