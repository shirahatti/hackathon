package com.hackthon.bankApplication.repository;

import com.hackthon.bankApplication.entity.Account;
import com.hackthon.bankApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
