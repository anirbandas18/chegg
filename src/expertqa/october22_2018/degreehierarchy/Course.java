package expertqa.october22_2018.degreehierarchy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course implements Serializable, Comparable<Course> {

	private String courseCode;
	private String courseTitle;
	private double courseCredit;
	private List<Course> prerequisites;
	private String courseGrade;
	private String semesterTaken;
	private String courseStatus;
	
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public double getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(double courseCredit) {
		this.courseCredit = courseCredit;
	}
	public List<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(List<Course> preReqList) {
		this.prerequisites = preReqList;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public String getSemesterTaken() {
		return semesterTaken;
	}
	public void setSemesterTaken(String semesterTaken) {
		this.semesterTaken = semesterTaken;
	}
	
	public Course() {
		this.courseCode = "";
		this.courseCredit = 0.0d;
		this.courseGrade = "";
		this.courseStatus = "";
		this.courseTitle = "";
		this.prerequisites = new ArrayList<>();
		this.semesterTaken = "";
	}
	
	public Course(Course copy) {
		this.courseCode = copy.courseCode;
		this.courseCredit = copy.courseCredit;
		this.courseGrade = copy.courseGrade;
		this.courseStatus = copy.courseStatus;
		this.courseTitle = copy.courseTitle;
		this.prerequisites = copy.prerequisites;
		this.semesterTaken = copy.semesterTaken;
	}
	
	public String toString() {
		//CourseCode, CreditWeight, CourseName,PrerequisiteList
		List<String> codeList = prerequisites.stream().map(c -> c.courseCode).collect(Collectors.toList());
		String preReqList = String.join(":", codeList);
		return courseCode + "," + courseCredit + "," + courseTitle + "," + preReqList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
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
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		return true;
	}
	@Override
	public int compareTo(Course o) {
		return this.courseCode.compareTo(o.getCourseCode());
	}
	
	
}
