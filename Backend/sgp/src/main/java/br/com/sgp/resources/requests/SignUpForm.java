package br.com.sgp.resources.requests;

public class SignUpForm {
	private String name;
	private String sname;
	private String cpf;
	private String rg;
	private String phone;
	private String email;
	private String password;
	private String description;
	
	public SignUpForm() {
	}
	
	public SignUpForm(String name, String sname, String cpf, String rg, String phone, String email, String password,
			String description) {
		super();
		this.name = name;
		this.sname = sname;
		this.cpf = cpf;
		this.rg = rg;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean hasEmptyFields() {
		return (cpf == null || cpf.trim().equals(""))
				|| (email == null || email.trim().equals(""))
				|| (name  == null || name.trim().equals(""))
				|| (sname == null || sname.trim().equals(""))
				|| (password == null || password.trim().equals(""))
				|| (phone  == null || phone.trim().equals(""))
				|| (rg == null || rg.trim().equals(""));
	}
	
}
