package com.hackthon.bankApplication.repository;

import com.hackthon.bankApplication.entity.Account;
import com.hackthon.bankApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUser(User user);
}
