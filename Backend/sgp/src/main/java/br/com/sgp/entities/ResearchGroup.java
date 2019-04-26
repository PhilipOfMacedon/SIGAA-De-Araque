package br.com.sgp.entities;

public class ResearchGroup {
	private Integer id;
	private String name;
	private String description;
	private String field;

	public ResearchGroup() {
	}

	public ResearchGroup(Integer id, String name, String description, String field) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.field = field;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
