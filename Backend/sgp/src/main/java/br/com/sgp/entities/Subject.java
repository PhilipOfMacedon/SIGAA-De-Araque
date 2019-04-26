package br.com.sgp.entities;

public class Subject {

	private Integer id;
	private String name;
	private String code;
	private String category;
	private String description;

	public Subject() {
	}

	public Subject(Integer id, String name, String code, String category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.category = category;
		this.description = description;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
