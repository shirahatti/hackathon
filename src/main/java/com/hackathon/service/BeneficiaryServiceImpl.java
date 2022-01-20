package com.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hackathon.dto.BusinessMessage;
import com.hackathon.dto.StatusEnum;
import com.hackathon.model.Beneficiary;
import com.hackathon.repository.BeneficiaryRepository;
import com.hackathon.response.Response;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Value("${beneficiary.limit}")
	private int beneficiaryLimit;

	@Override
	public Response addBeneficiary(Beneficiary benecifiary) {

		Response response = new Response();
		List<BusinessMessage> businessMessageList = getNoOfBeneficiaries(benecifiary);
		// Need to make a call to account for checking beneficiary acc no and account
		// number
		if (businessMessageList.isEmpty()) {
			beneficiaryRepository.save(benecifiary);
			businessMessageList.add(new BusinessMessage("Successfully added beneficiary."));
			response.setBusinessMessage(businessMessageList);
			response.setApiStatus(StatusEnum.SUCCESS);
			response.setResponseData(benecifiary.getBeneficiaryAccountNumber());
			return response;

		} else
			response.setBusinessMessage(businessMessageList);
			response.setApiStatus(StatusEnum.FAIL);
			return response;
	}

	private List<BusinessMessage> getNoOfBeneficiaries(Beneficiary benecifiary) {
		List<BusinessMessage> list = new ArrayList<>();

		List<Beneficiary> beneficiary = beneficiaryRepository.findByAccountNumber(benecifiary.getAccountNumber());
		

		System.out.println("beneficiaryLimit: " +beneficiaryLimit);
		if (beneficiary.size() == beneficiaryLimit)
			list.add(new BusinessMessage("Adding maximum beneficiary limit reached..."));
		if(benecifiary.getAccountNumber().equals(benecifiary.getBeneficiaryAccountNumber()))
			list.add(new BusinessMessage("Account number and beneficiary account number should not be same."));
		for(Beneficiary beneficiaryDetails : beneficiary)
			if(beneficiaryDetails.getBeneficiaryAccountNumber().equals(benecifiary.getBeneficiaryAccountNumber()))
				list.add(new BusinessMessage("Beneficiary is already existed"));
		return list;
	}

}
