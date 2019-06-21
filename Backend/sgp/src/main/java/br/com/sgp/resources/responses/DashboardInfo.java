package br.com.sgp.resources.responses;

public class DashboardInfo {
	
	private String teacherName;
	private int researcherCount;
	private int researchGroupCount;
	private int projectCount;
	private String message;
	private int token;
	
	public DashboardInfo() {
	}
	
	public DashboardInfo(String teacherName, int researcherCount, int researchGroupCount, int projectCount, String message, int token) {
		super();
		this.teacherName = teacherName;
		this.researcherCount = researcherCount;
		this.researchGroupCount = researchGroupCount;
		this.projectCount = projectCount;
		this.message = message;
		this.token = token;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getResearcherCount() {
		return researcherCount;
	}

	public void setResearcherCount(int researcherCount) {
		this.researcherCount = researcherCount;
	}

	public int getResearchGroupCount() {
		return researchGroupCount;
	}

	public void setResearchGroupCount(int researchGroupCount) {
		this.researchGroupCount = researchGroupCount;
	}

	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}
	
}
