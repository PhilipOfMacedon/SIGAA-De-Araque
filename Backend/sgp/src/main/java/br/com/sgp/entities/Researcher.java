package br.com.sgp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Researcher implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String surname;
	private String cpf;
	private String rg;
	private String phone;
	private String email;
	
	@ManyToMany
	@JoinTable(name = "RESEARCHER_PROJECT",
	joinColumns = @JoinColumn(name = "researcher_id"),
	inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> projects;
	
	
	private ResearchGroup group;
	

	public Researcher() {
	}

	public Researcher(Integer id, String name, String surname, String cpf, String rg, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.rg = rg;
		this.phone = phone;
		this.email = email;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Researcher other = (Researcher) obj;
		if (cpf != null && other.cpf != null && cpf.equals(other.cpf)) {
			return true;
		}
		if (rg != null && other.rg != null && rg.equals(other.rg)) {
			return true;
		}
		if (email != null && other.email != null && email.equals(other.email)) {
			return true;
		}
		if (id == other.id) {
			return true;
		}
		return false;
	}

}
