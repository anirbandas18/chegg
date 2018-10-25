package expertqa.october22_2018.degreehierarchy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Degree implements Serializable {
	
	private static final String DEGREE_NAME = " Degree";
	
	public Degree(String degreeTitle, List<String> requiredCourses) {
		this.degreeTitle = degreeTitle + DEGREE_NAME;
		this.requiredCourses = requiredCourses;
	}
	private String degreeTitle;
	private List<String> requiredCourses;
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	public List<String> getRequiredCourses() {
		return requiredCourses;
	}
	public void setRequiredCourses(List<String> requiredCourses) {
		this.requiredCourses = requiredCourses;
	}
	public abstract boolean meetsRequirements(PlanOfStudy thePlan);
	public abstract double numberOfCreditsRemaining(PlanOfStudy thePlan);
	public abstract ArrayList<Course> remainingRequiredCourses(PlanOfStudy thePlan);
}
