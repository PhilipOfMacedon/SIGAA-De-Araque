package br.com.sgp.resources.responses;

public class JSONResponse<T> {
	
	private int status;
	private String token;
	private T data;
	private User user;
	
	public JSONResponse() {
	}
	
	public JSONResponse(int status, String token, T data, User user) {
		super();
		this.status = status;
		this.token = token;
		this.data = data;
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
