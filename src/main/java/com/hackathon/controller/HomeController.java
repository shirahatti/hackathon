package com.hackathon.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.dto.StatusEnum;
import com.hackathon.model.Beneficiary;
import com.hackathon.model.JwtRequest;
import com.hackathon.model.JwtResponse;
import com.hackathon.response.Response;
import com.hackathon.service.BankUserService;
import com.hackathon.service.BeneficiaryService;
import com.hackathon.service.UserService;
import com.hackathon.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private BankUserService bankUserService;

	@Autowired
	private BeneficiaryService beneficiaryService;

	@GetMapping("/")
	public String home() {
		return "Welcome to Spring JWT!!";
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserId(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

//		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
		final UserDetails userDetails = bankUserService.loadUser(jwtRequest.getUserId());

		if (userDetails != null) {
			System.out.println("userDetails: " + userDetails.getUsername());

			final String token = jwtUtility.generateToken(userDetails); //
			System.out.println("token::: " + token);

			return new JwtResponse(token);
		} else

			return new JwtResponse("INVALID_CREDENTIALS");

	}

	@PostMapping("/beneficiary")
	public ResponseEntity<Response> addBeneficiary(@RequestBody Beneficiary benecifiary) {

		HttpStatus httpstatus = null;
		Response response = beneficiaryService.addBeneficiary(benecifiary);
		;
		if (!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
			httpstatus = HttpStatus.NOT_FOUND;
		} else {
			httpstatus = HttpStatus.OK;
		}
		return new ResponseEntity<>(response, httpstatus);
	}
}
