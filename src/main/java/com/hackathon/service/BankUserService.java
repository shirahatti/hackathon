package com.hackathon.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface BankUserService {

	public UserDetails loadUser(Long userName);
}
