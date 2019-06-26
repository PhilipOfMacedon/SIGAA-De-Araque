package br.com.sgp.resources.responses;

public class DashboardInfo {
	
	private String teacherName;
	private String researcherCount;
	private String researchGroupCount;
	private String projectCount;
	private String message;
	
	public DashboardInfo() {
	}
	
	public DashboardInfo(String teacherName, String researcherCount, String researchGroupCount, String projectCount, String message) {
		super();
		this.teacherName = teacherName;
		this.researcherCount = researcherCount;
		this.researchGroupCount = researchGroupCount;
		this.projectCount = projectCount;
		this.message = message;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getResearcherCount() {
		return researcherCount;
	}

	public void setResearcherCount(String researcherCount) {
		this.researcherCount = researcherCount;
	}

	public String getResearchGroupCount() {
		return researchGroupCount;
	}

	public void setResearchGroupCount(String researchGroupCount) {
		this.researchGroupCount = researchGroupCount;
	}

	public String getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(String projectCount) {
		this.projectCount = projectCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
