package com.hackathon.model;

public class JwtResponse {

	private String jwtToken;

	public JwtResponse(String token) {
		jwtToken = token;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + "]";
	}
}
