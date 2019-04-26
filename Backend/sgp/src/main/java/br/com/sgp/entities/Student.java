package br.com.sgp.entities;

import java.util.Date;

public class Student extends Researcher {
	private String courseName;
	private Date courseStart;
	private Date courseEnd;
	private String courseCategory;

	public Student() {
		super();
	}

	public Student(Integer id, String name, String surname, String cpf, String rg, String phone, String email,
			String courseName, Date courseStart, Date courseEnd, String courseCategory) {
		super(id, name, surname, cpf, rg, phone, email);
		this.courseName = courseName;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.courseCategory = courseCategory;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCourseStart() {
		return courseStart;
	}

	public void setCourseStart(Date courseStart) {
		this.courseStart = courseStart;
	}

	public Date getCourseEnd() {
		return courseEnd;
	}

	public void setCourseEnd(Date courseEnd) {
		this.courseEnd = courseEnd;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

}
