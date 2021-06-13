package railway12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<Group> listGroup = new ArrayList<>();

		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Nhom 1";
		listGroup.add(group1);

//		System.out.println(group1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Nhom 2";
		listGroup.add(group2);

//		System.out.println(group1.equals(group2));

		Group group3 = new Group();
		group3.id = 4;
		group3.name = "Nhom 3";
		listGroup.add(group3);

		Group group4 = new Group();
		group4.id = 3;
		group4.name = "Nhom 4";
		listGroup.add(group4);

		Group group5 = new Group();
		group5.id = 0;
		group5.name = "Nhom 5";
		listGroup.add(group5);

		for (Group group : listGroup) {
			System.out.println(group);
		}
		
		Collections.sort(listGroup);
		System.out.println("Sau khi sap xep: ");
		for (Group group : listGroup) {
			System.out.println(group);
		}

//		String hoTen1 = new String("Nam");
//		String hoTen2 = "Nam";
//		
//		if (hoTen1 == hoTen2) {
//			System.out.println("Bang");
//		} else {
//			System.out.println("Khong bang");
//		}

//		String a = "railway12";
//		String b = "railway12";
//		if (a.equals(b)) {
//			System.out.println("Bang nhau");
//		} else {
//			System.out.println("Khong bang nhau");
//		}
//		System.out.println("Dia chi o nho: "+a.hashCode());
//		System.out.println("Dia chi o nho b: "+b.hashCode());

//		Student[] students = new Student[8];
//		for (int i = 0; i < students.length; i++) {
//			students[i] = new Student();
//			System.out.println(students[i].id);
//		}	

	}

}
