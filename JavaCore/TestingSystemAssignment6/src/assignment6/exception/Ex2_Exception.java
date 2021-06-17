package assignment6.exception;

import java.util.Scanner;

public class Ex2_Exception {

	public static void main(String[] args) throws Exception {
//		Question 1: try…catch…finally
//	Hãy xử lý exception cho VD trên, khi bị lỗi thì sẽ in ra text "cannot divide 0"
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Cannot divide by 0");
		}

//		Question 2: tiếp tục Question 1 Sau khi thực hiện xong method divide dù có lỗi hay không sẽ in ra text "divide completed!"
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Cannot divide by 0");
		} finally {
			System.out.println("Divide completed!");
		}
			
//		Question 3:
//	Hãy xử lý exception cho VD trên và in ra thông tin lỗi.
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.out.println(e);
		}
		
//		Question 4:
//	Tạo 1 array departments gồm 3 phần tử Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ index trong array departments. Nếu index vượt quá length lấy ra thì sẽ in ra text "Cannot find department."
		String[] dep = { "Sale", "Engineer", "HR" };
		try {
			for (int i = 0; i <= dep.length; i++) {
				System.out.println(dep[i]);
			}
		} catch (Exception e) {
			System.out.println("Cannot find department");
		}
		
//		Question 5: inputAge()
		System.out.println(inputAge());
		
//		Question 6: continue Q5
//		lam trong method
		
//		Question 7: Tạo 1 class ScannerUtils, trong class sẽ tạo 1 method inputInt() chuyên để nhập dữ liệu dạng int như age, id, … Gợi ý: inputInt() sẽ có parameter là String errorMessage để người dùng có thể tự điền được errorMessage vào 
		
	}
	
	public static float divide(int a, int b) {
		return a/b;
	}
	
	public static int inputAge() throws Exception {
		boolean nonstop = true;
		int age = 0;
		while (nonstop) {
			System.out.println("Insert your age: ");
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
			
			try {
				age = Integer.parseInt(a);
				nonstop = false;
			} catch (Exception e) {
				System.out.println("Wrong input! Please insert your age as an integer, not string.");
			}
		}
		while (age <= 0) {
//			throw new Exception("Your age cannot be smaller than 0!");
			System.out.println("Your age cannot be smaller than 0!");
			inputAge();
		}
		return age;
	}
}
