package assignment7.frontend;

import java.util.ArrayList;
import java.util.List;

import assignment7.entity.Student;

public class Ex1_Static {

	public static void main(String[] args) {
		
			// Question 1
		List<Student> listStudents = new ArrayList<Student>();
		
		Student s1 = new Student(1, "J");
		Student s2 = new Student(2, "K");
		Student s3 = new Student(3, "O");

		listStudents.add(s1);
		listStudents.add(s2);
		listStudents.add(s3);
		
		Student.change();
		
		for (Student student : listStudents) {
			student.display();
		}
		
			// Question 2
		// raising fund
		for (Student student : listStudents) {
			student.funding(100);
		}
		
		// using fund
		s1.funding(-50);
		s2.funding(-20);
		s3.funding(-150);
		
		// raising more money
		for (Student student : listStudents) {
			student.funding(50);
		}
	}

}
