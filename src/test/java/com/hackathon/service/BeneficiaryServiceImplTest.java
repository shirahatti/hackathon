package com.hackathon.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hackathon.model.Beneficiary;
import com.hackathon.repository.BeneficiaryRepository;

@ExtendWith(SpringExtension.class)
public class BeneficiaryServiceImplTest {

	@InjectMocks
	BeneficiaryServiceImpl beneficiaryServiceImpl;
	
	@Mock
	BeneficiaryRepository beneficiaryRepository;
	
	Beneficiary beneficiary = new Beneficiary();
	@Test
	public void testAddBeneficiary() {
		Mockito.when(beneficiaryRepository.save(beneficiary)).thenAnswer(null);
		beneficiaryServiceImpl.addBeneficiary(beneficiary);
//		assertE
	}
}
