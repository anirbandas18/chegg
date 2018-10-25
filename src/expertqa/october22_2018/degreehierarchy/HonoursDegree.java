package expertqa.october22_2018.degreehierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class HonoursDegree extends Degree {
	
	private static final String DEGREE_TYPE = " Honours";

	public HonoursDegree(String subjectName, List<String> requiredCourse) {
		super(subjectName + DEGREE_TYPE, requiredCourse);
	}
	
	@Override
	public boolean meetsRequirements(PlanOfStudy thePlan) {
		// logic to calculate requirement goes here. rules not specified in question
		return false;
	}
	
	@Override
	public ArrayList<Course> remainingRequiredCourses(PlanOfStudy thePlan) {
		// logic to calculate remaining required courses goes here. rules not specified in question
		return null;
	}

}
