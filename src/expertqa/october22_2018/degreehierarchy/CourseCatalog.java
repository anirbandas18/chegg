package expertqa.october22_2018.degreehierarchy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CourseCatalog implements Serializable{
	
	private Reader r;
	private Writer w;
	private Map<String, Course> courseList;
	private String filename;
	
	public CourseCatalog() {
		this.courseList = new TreeMap<>();
	}
	
	private void handlePrerequisites(Course course, List<String> preReqRaw) {
		List<Course> preReqList = new ArrayList<>();
		for(String courseCode : preReqRaw) {
			Course copy = new Course(course);
			copy.setCourseCode(courseCode);
			preReqList.add(copy);
		}
		course.setPrerequisites(preReqList);
	}
	
	public void initializeCatalog(String filename) {
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
				List<String> preReqRaw = Arrays.asList(tokens[3].split(":"));
				handlePrerequisites(c, preReqRaw);
				addCourse(c);
			}
			br.close();
		} catch (IOException e) {
			System.err.println(this.getClass().getSimpleName() + ".initializeCatalog: Error reading course list: " + e.getMessage());
		}
	}
	
	public void addCourse(Course toAdd) {
		this.courseList.put(toAdd.getCourseCode(), toAdd);
	}
	
	public void removeCourse(Course toRemove) {
		this.courseList.remove(toRemove.getCourseCode());
	}

	public void saveCatalog() {
		try {
			w = new FileWriter(this.filename);
			BufferedWriter bw = new BufferedWriter(w);
			for(Course c : courseList.values()) {
				bw.write(c.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.err.println(this.getClass().getSimpleName() + ".saveCatalog: Error writing course list: " + e.getMessage());
		}
	}
	
	public Course findCourse(String courseCode) {
		return this.courseList.get(courseCode);
	}
}
