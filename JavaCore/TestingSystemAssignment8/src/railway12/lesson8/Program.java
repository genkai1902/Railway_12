package railway12.lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import assignment8.entity.Student;

public class Program {

	public static void main(String[] args) {
		// List/ arraylist
		// trong ngoặc <> chỉ có thể sử dụng object, k dùng được loại nguyên thủy primitive type
//		List<Integer> list = new ArrayList<Integer>(); 
//		list.add(1);
//		list.add(2);
//		list.add(7);
//		list.add(4);
//		list.add(-6);
//		list.add(100);
		
//		System.out.println(list.size());
//		System.out.println(list.get(2)); //7
		
//		for (Integer integer : list) {
//			if (integer.equals(2)) {
//				System.out.println(integer);
//			}
//		}
		
//		Collections.sort(list); // import Collections for sorting
//		for (Integer integer : list) {
//			System.out.println(integer);
//		}
		
		// Set
		// Set không chứa giá trị trùng nhau, loại bỏ giá trị trùng lặp
//		Set<String> setString = new HashSet<String>();
//		setString.add("Duc");
//		setString.add("Luc");
//		setString.add("Tuan");
//		setString.add("Anh");
//		setString.add("Duc");
//		setString.add(null);
		
//		System.out.println(setString.size()); //chỉ để lại các giá trị duy nhất k trùng lặp
		
		// Nếu muốn sắp xếp thứ tự của sort, phải convert sang String
//		List<String> listString = new ArrayList<String>(setString); // ép kiểu (casting) set sang list
//		Collections.sort(listString);
//		for (String string : listString) {
//			System.out.println(string);
//		}

//		for (String string : setString) {
//			System.out.println(string);
//		}
		
		
		// Map, HashMap
//		Map<String, Student> mapStudent = new HashMap<String, Student>();
		
//		mapStudent.put("s1", new Student("Duc"));
//		mapStudent.put("s2", new Student("Long"));
//		mapStudent.put("s3", new Student("Tung"));
//		mapStudent.put("s4", new Student("Nam"));
		
//		for (Entry<String, Student> entry : mapStudent.entrySet()) {
//			String key = entry.getKey();
//			Student value = entry.getValue();
//			System.out.println("Key: " + key);
//			System.out.println("Value: " + value);
//		}
		
		
		// Generic
		Student1<Integer> s1 = new Student1<Integer>();
		Student1<Short> s2 = new Student1<Short>();
	}

}
