package br.com.sgp.entities;

public class Lesson {

	private Integer id;
	private String name;
	private String description;
	private String filenames;

	public Lesson() {
	}

	public Lesson(Integer id, String name, String description, String filenames) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.filenames = filenames;
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

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

}
