package br.com.sgp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Teacher extends Researcher implements LoggableUser {
	private String bio;
	private String password;
	
	@JsonBackReference
	@OneToMany(mappedBy = "teacher")
	private List<Subject> subjects;

	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, String surname, String cpf, String rg, String phone, String email, String password, String bio) {
		super(id, name, surname, cpf, rg, phone, email);
		this.password = password;
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void login(String email, String password) {
		
	}
	
}