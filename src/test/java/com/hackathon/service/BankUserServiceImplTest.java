package com.hackathon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hackathon.model.BankUser;
import com.hackathon.repository.BankUserRepository;

@ExtendWith(SpringExtension.class)
public class BankUserServiceImplTest {

	@InjectMocks
	BankUserServiceImpl bankUserServiceImpl;
	
	@Mock
	BankUserRepository bankUserRepository;
	
	@Test
	public void testLoadUser() {
		BankUser user = new BankUser();
		user.setUserId(111L);
		user.setPassword("password");
		
		Mockito.when(bankUserRepository.findById(1L)).thenReturn(Optional.of(user));
		UserDetails dbUser = bankUserServiceImpl.loadUser(1L);
		assertNotNull(dbUser);
		assertEquals("password", user.getPassword());
	}
}
