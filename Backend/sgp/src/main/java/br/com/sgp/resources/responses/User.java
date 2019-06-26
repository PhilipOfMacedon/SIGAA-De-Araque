package br.com.sgp.resources.responses;

import br.com.sgp.entities.Teacher;

public class User {

	private Integer id;
	private String name;
	private String surname;
	private String cpf;
	private String rg;
	private String phone;
	private String email;
	private String bio;
	
	public User() {
	}
	
	public User(Integer id, String name, String surname, String cpf, String rg, String phone, String email,
			String bio) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.rg = rg;
		this.phone = phone;
		this.email = email;
		this.bio = bio;
	}
	
	public User(Teacher teacher) {
		super();
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.surname = teacher.getSurname();
		this.cpf = teacher.getCpf();
		this.rg = teacher.getRg();
		this.phone = teacher.getPhone();
		this.email = teacher.getEmail();
		this.bio = teacher.getBio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
