package br.com.sgp.resources.requests;

public class TokenRequest {
	
	private int token;

	public TokenRequest() {
	}

	public TokenRequest(int token) {
		super();
		this.token = token;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}
	
}
