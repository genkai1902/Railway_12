package assignment3;

public class Ex3_BoxingUnboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
		
		int luong = 5000;
		float cLuong = (float) luong;
		System.out.printf("Luong: %.2f\n", cLuong);
		
//			Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
		
		String str = "1234567";
		int num = Integer.valueOf(str);
		System.out.println(num);
		
//			Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int
		
		Integer num2 = new Integer("1234567");
		int numConvert = num2.intValue();
		System.out.println(numConvert);
		
	}

}
