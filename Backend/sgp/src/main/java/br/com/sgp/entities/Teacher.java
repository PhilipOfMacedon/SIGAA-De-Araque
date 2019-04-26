package br.com.sgp.entities;

import java.util.List;

public class Teacher extends Researcher implements LoggableUser {
	private String bio;
	private List<Subject> mySubjects;

	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, String surname, String cpf, String rg, String phone, String email, String bio) {
		super(id, name, surname, cpf, rg, phone, email);
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public void login(String email, String password) {
		
	}
	
}