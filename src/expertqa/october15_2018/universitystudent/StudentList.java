package expertqa.october15_2018.universitystudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
	
	private static Comparator<Student> CMP_BY_ID = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			return Integer.compare(o1.getId(), o2.getId());
		}
	};
	
	private List<Student> list;
	
	public StudentList() {
		this.list = new ArrayList<>();
	}
	
	public StudentList(List<Student> list) {
		this.list = list;
	}
	
	public void addRecord(Student s) {
		list.add(s);
		System.out.println("Record added");
	}
	
	public void deleteRecord(int ID) {
		int index = searchById(ID);
		if(index == -1) {
			System.out.println(ID + " not found");
		} else {
			Student s = list.remove(index);
			System.out.println(s.getId() + " deleted");
		}
	}
	
	public void displayMajors(String major) {
		List<Student> results = list.stream().filter(s -> s.getMajor().equalsIgnoreCase(major)).collect(Collectors.toList());
		if(results.isEmpty()) {
			System.out.println("No students with major: " + major);
		} else {
			for(Student s : results) {
				System.out.println(s);
			}
		}
	}
	
	public void displayFaculty(String faculty) {
		List<Student> results = list.stream().filter(s -> s.getFaculty().equalsIgnoreCase(faculty)).collect(Collectors.toList());
		if(results.isEmpty()) {
			System.out.println("No students in faculty: " + faculty);
		} else {
			for(Student s : results) {
				System.out.println(s);
			}
		}
	} 
	
	public void displayName(String lName) {
		List<Student> results = list.stream().filter(s -> s.getLastName().equalsIgnoreCase(lName)).collect(Collectors.toList());
		if(results.isEmpty()) {
			System.out.println("No students with last name: " + lName);
		} else {
			for(Student s : results) {
				System.out.println(s);
			}
		}
	}
	
	public Student searchId(int ID) {
		int index = searchById(ID);
		if(index == -1) {
			return null;
		} else {
			return list.get(index);
		}
	}
	
	public int searchById(int ID) {
		List<Student> temp = new ArrayList<>(list);
		Collections.sort(temp, CMP_BY_ID);
		int low = 0;
		int high = list.size() - 1;
		int index = -1;
		while(low <= high) {
			int mid = (low + high) / 2;
			Student item = temp.get(mid);
			if(ID == item.getId()) {
				index = mid;
				break;
			} else if (ID < item.getId()) {
				high = mid - 1;
			} else if(ID > item.getId()) {
				low = mid + 1;
			}
		}
		return index;
	}

}
