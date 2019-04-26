package br.com.sgp.entities;

public class Publication {
	private Integer id;
	private String name;
	private String category;
	private String field;
	private String fileNames;
	
	public Publication() {
	}
	
	public Publication(Integer id, String name, String category, String field, String fileNames) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.field = field;
		this.fileNames = fileNames;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}
	
}
