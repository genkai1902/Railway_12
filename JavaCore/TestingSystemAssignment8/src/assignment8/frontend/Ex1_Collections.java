package assignment8.frontend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import assignment8.entity.Student;

public class Ex1_Collections {
	
	static List<Student> listStudent = new ArrayList<Student>();

	public static void main(String[] args) {
		
		// Question 1
		
		Student s1 = new Student("Giang");
		Student s2 = new Student("Ho");
		Student s3 = new Student("Hiem");
		Student s4 = new Student("Ac");
		Student s5 = new Student("Hiem");
		Student s6 = new Student("Hiem");
		Student s7 = new Student("Galaxy");
		Student s8 = new Student("Galaxy");
		
		listStudent.add(s1);
		listStudent.add(s2);
		listStudent.add(s3);
		listStudent.add(s4);
		listStudent.add(s5);
		listStudent.add(s6);
		
		// 1a
//		System.out.println(listStudent.size());
		
		// 1b
//		System.out.println(listStudent.get(3));
			
		// 1c
//		System.out.println(listStudent.get(0));
//		System.out.println(listStudent.get(listStudent.size()-1));
		
		// 1d
		listStudent.add(0, s7);
		
		// 1e
		listStudent.add(s8);
		
		// 1f
//		Collections.reverse(listStudent);
//		for (Student student : listStudent) {
//			System.out.println(student);
//		}
		
		// 1g
//		Scanner scanner1 = new Scanner(System.in);
//		System.out.println("Nhap vao ID hoc sinh can tim: ");
//		int searchID = scanner1.nextInt();
//		searchByID(searchID);
		
		// 1h
//		Scanner scanner2 = new Scanner(System.in);
//		System.out.println("Nhap vao ten hoc sinh can tim: ");
//		String searchName = scanner2.nextLine();
//		searchByName(searchName);
		
		// 1i
		duplicatedName();
		
		// 1j
		
		// 1k
		
		// 1l
		List<Student> copiedList = new ArrayList<Student>();
		copiedList.addAll(listStudent);
	}
	
	public static void searchByID(int id) {
		for (Student student : listStudent) {
			if (student.getId() == id) {
				System.out.println(student);
			}
		}
	}
	
	public static void searchByName(String name) {
		for (Student student : listStudent) {
			if (student.getName().equals(name)) {
				System.out.println(student);
			}
		}
	}
	
	public static void duplicatedName() {
		for (int i = 0; i < listStudent.size(); i++) {
			for (int j = i + 1; j < listStudent.size(); j++) {
				if (listStudent.get(i).getName().equals(listStudent.get(j).getName())) {
					System.out.println(listStudent.get(i));
				}
			}
		}

	}
	
	public static void delNameByID(List<Student> list) {
		
	}
	
	public static void delStdByID(List<Student> list) {
		Student stDel = new Student();
		for (Student student : list) {
			if (student.getId() == 5) {
				stDel = student;
			}
		}
		list.remove(stDel);
	}
}
