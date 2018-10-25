package expertqa.october15_2018.universitystudent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentListDemo {

	private String fileName;
	private BufferedReader stdin;
	private StudentList manager;

	public StudentListDemo(String fileName, BufferedReader stdin) {
		this.fileName = fileName;
		this.stdin = stdin;
	}

	private Student parseStudent(String line) {
		String[] tokens = line.split("\\s");
		Student s = new Student();
		s.setId(Integer.parseInt(tokens[0]));
		s.setFirstName(tokens[1]);
		s.setLastName(tokens[2]);
		s.setEmail(tokens[3]);
		s.setMajor(tokens[4]);
		s.setFaculty(tokens[5]);
		return s;
	}

	private List<Student> getFileContent() throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
		List<Student> studentList = new ArrayList<>();
		String line = "";
		while ((line = fileReader.readLine()) != null) {
			Student s = parseStudent(line);
			studentList.add(s);
		}
		fileReader.close();
		return studentList;
	}

	private void display(String displayType) throws IOException {
		try {
			String input = "";
			DisplayType type = DisplayType.valueOf(displayType.trim());
			switch (type) {
			case faculty:
				System.out.print("Enter the faculty: ");
				input = stdin.readLine();
				System.out.println();
				manager.displayFaculty(input);
				break;
			case major:
				System.out.print("Enter the major: ");
				input = stdin.readLine();
				System.out.println();
				manager.displayMajors(input);
				break;
			case student:
				System.out.print("Enter the last name: ");
				input = stdin.readLine();
				System.out.println();
				manager.displayName(input);
				break;
			}
		} catch (Exception e) {
			System.out.println("Display type not recognized: " + displayType);
		}
	}

	public String execute() throws IOException {
		String message = "", input = "";
		this.manager = new StudentList(getFileContent());
		Student s = null;
		boolean flag = true;
		while (flag) {
			System.out.print("What would you like to do? (add, delete, display, search, quit): ");
			String choice = stdin.readLine();
			System.out.println();
			Command cmd = Command.valueOf(choice.trim());
			int ID = 0;
			try {
				switch (cmd) {
				case add:
					System.out.print("Enter the record: ");
					input = stdin.readLine();
					System.out.println();
					s = parseStudent(input);
					manager.addRecord(s);
					break;
				case delete:
					System.out.print("Enter the ID number to be deleted: ");
					input = stdin.readLine();
					System.out.println();
					ID = Integer.parseInt(input);
					manager.deleteRecord(ID);
					break;
				case display:
					System.out.print("Display what (major, faculty, student): ");
					input = stdin.readLine();
					System.out.println();
					display(input);
					break;
				case search:
					System.out.print("Enter the ID number: ");
					input = stdin.readLine();
					System.out.println();
					ID = Integer.parseInt(input);
					s = manager.searchId(ID);
					if(s == null) {
						System.out.println(ID + " not found");
					} else {
						System.out.println(s);
					}
					break;
				case quit:
					message = "Program ended";
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Action not recognized: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return message;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the filename to read from: ");
		String fileName = stdin.readLine();
		System.out.println();
		System.out.println();
		StudentListDemo sld = new StudentListDemo(fileName, stdin);
		String result = sld.execute();
		System.out.println(result);
		stdin.close();
	}

}
