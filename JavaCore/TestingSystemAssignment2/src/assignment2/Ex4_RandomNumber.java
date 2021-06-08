package assignment2;

import java.time.LocalDate;
import java.util.Random;

public class Ex4_RandomNumber {

	public static void main(String[] args) {
//			Question 1:
//			In ngẫu nhiên ra 1 số nguyên
		System.out.println("________________________Question 1________________________");
		Random random = new Random();
		int q1 = random.nextInt();
		System.out.println(q1);
		
		
//			Question 2:
//			In ngẫu nhiên ra 1 số thực
		System.out.println("________________________Question 2________________________");
		float q2 = random.nextFloat();
		System.out.printf("%.2f\n",q2);
		
//			Question 3:
//			Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		System.out.println("________________________Question 3________________________");
		String[] name = {"Giang", "Huy", "Quan"};
		System.out.println(name[random.nextInt(name.length)]);
			
//			Question 4:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
		System.out.println("________________________Question 4________________________");
		int minDay = (int) LocalDate.of(1995,07,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		LocalDate randomDay = LocalDate.ofEpochDay(minDay + random.nextInt(maxDay-minDay));
		System.out.println(randomDay);
		
//			Question 5:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		System.out.println("________________________Question 5________________________");
		int now = (int) LocalDate.now().toEpochDay();
		int randomWithinAYear = now - random.nextInt(365);
		randomDay = LocalDate.ofEpochDay(randomWithinAYear);
		System.out.println(randomDay);
		
		
//			Question 6:
//			Lấy ngẫu nhiên 1 ngày trong quá khứ
		System.out.println("________________________Question 6________________________");
		int curDate = (int) LocalDate.now().toEpochDay();
		randomDay = LocalDate.ofEpochDay(random.nextInt(curDate));
		System.out.println(randomDay);
		
//			Question 7:
//			Lấy ngẫu nhiên 1 số có 3 chữ số
		System.out.println("________________________Question 7________________________");
		System.out.println(101 + random.nextInt(999-101));

	}

}
