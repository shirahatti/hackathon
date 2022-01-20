package com.hackathon.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hackathon.model.BankUser;
import com.hackathon.repository.BankUserRepository;

@Service
public class BankUserServiceImpl implements BankUserService {

	@Autowired
	private BankUserRepository bankUserRepository;

	@Override
	public UserDetails loadUser(Long userName) {

		Optional<BankUser> user = bankUserRepository.findById(userName);
		String dbUserName = null;
		String dbPassword = null;
		if(user.isPresent())
		{
			dbUserName = String.valueOf(user.get().getUserId());
			dbPassword = user.get().getPassword();
			System.out.println("userName: " + user.get().getUserId());
			System.out.println("password: " + user.get().getPassword());
			return new User(dbUserName, dbPassword, new ArrayList<>());
		}

		return null;
	}

}
