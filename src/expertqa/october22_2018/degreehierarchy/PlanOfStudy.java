package expertqa.october22_2018.degreehierarchy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PlanOfStudy implements Serializable {
	
	private Degree deg;
	private String filename;
	private Reader r;
	private Writer w;
	private CourseCatalog catalog;
	private Set<String> courseList;
	
	public PlanOfStudy() {
		this.catalog = new CourseCatalog();
	}
	
	public void setDegreeProgram(Degree deg) {
		this.deg = deg;
	}
	public Degree getDegreeProgram() {
		return this.deg;
	}
	public void importData(String filename) {
		this.filename = filename;
		try {
			r = new FileReader(this.filename);
			BufferedReader br = new BufferedReader(r);
			String line = "";
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				Course c = new Course();
				c.setCourseCode(tokens[0]);
				c.setCourseCredit(Double.parseDouble(tokens[1]));
				c.setCourseTitle(tokens[2]);
				catalog.addCourse(c);
				List<String> preReqRaw = Arrays.asList(tokens[3].split(":"));
				deg.setRequiredCourses(preReqRaw);
			}
			br.close();
		} catch (IOException e) {
			System.err.println(this.getClass().getSimpleName() + ".importData: " + e.getMessage());
		}
	}
	public void saveState() {
		try {
			w = new FileWriter(this.filename);
			BufferedWriter bw = new BufferedWriter(w);
			for(String courseCode : courseList) {
				Course c = catalog.findCourse(courseCode);
				if(c != null) {
					bw.write(c.toString());
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			System.err.println(this.getClass().getSimpleName() + ".saveState: " + e.getMessage());
		}
	}
	public void addCourse(String courseCode, String semester) {
		Course c = new Course();
		c.setCourseCode(courseCode);
		c.setSemesterTaken(semester);
		catalog.addCourse(c);
		courseList.add(courseCode);
		System.out.println("Added course " + courseCode + " for semester " + semester);
	}
	public void removeCourse(String courseCode, String semester) {
		Course c = catalog.findCourse(courseCode);
		if(c != null) {
			catalog.removeCourse(c);
			courseList.remove(courseCode);
			System.out.println("Removed course " + courseCode + " for semester " + semester);
		} else {
			System.err.println("Unable to find course: " + courseCode + " for semester " + semester);
		}
	}
	public void setCourseStatus(String courseCode, String semester, String courseStatus) {
		Course c = catalog.findCourse(courseCode);
		if(c != null) {
			c.setCourseStatus(courseStatus);
			catalog.addCourse(c);
			System.out.println("Updated course " + courseCode + " for semester " + semester + " with status " + courseStatus);
		} else {
			System.err.println("Unable to find course: " + courseCode + " for semester " + semester);
		}
	}
	public void setCourseGrade(String courseCode, String semester, String grade) {
		Course c = catalog.findCourse(courseCode);
		if(c != null) {
			c.setCourseGrade(grade);
			catalog.addCourse(c);
			System.out.println("Updated course " + courseCode + " for semester " + semester + " with grade " + grade);
		} else {
			System.err.println("Unable to find course: " + courseCode + " for semester " + semester);
		}
	}
	public Course getCourse(String courseCode, String semester) {
		Course c = catalog.findCourse(courseCode);
		if(c != null) {
			System.out.println("Found course " + courseCode + " for semester " + semester);
		} else {
			System.err.println("Unable to find course: " + courseCode + " for semester " + semester);
		}
		return c;
	}

}
