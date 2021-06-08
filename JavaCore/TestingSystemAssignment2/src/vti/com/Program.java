package vti.com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Program {
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int minDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
		int maxDay= (int) LocalDate.of(2021, 6, 6).toEpochDay();
		
		long randomInt = minDay + random.nextInt(maxDay-minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		
		DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		System.out.println(randomDay.format(dateFormatter1));
		
		
		
//		int a = random.nextInt(15-10);
//		System.out.println(a);
		
		
//		Scanner scanner = new Scanner(System.in);

//		System.out.print("Moi ban nhap so: ");
//		int a = scanner.nextInt();
//		System.out.println("Ban vua nhap vao so: " + a);

//		System.out.print("Moi ban nhap mot chuoi: ");
//		String varchar = scanner.nextLine();
//		System.out.println("Ban vua nhap vao chuoi: " + varchar);

//		long myMoney = 10000000000000L;
//		float soRandom = 13.112F;
//
//		System.out.printf(Locale.US, "%,d", myMoney);
//		System.out.printf("%.3f", soRandom);

//		LocalDate localDate = LocalDate.now();
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//		System.out.println(localDate.format(dateFormatter));
//		
//		DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		System.out.println(localDate.format(dateFormatter1));
//		
//		DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
//		System.out.println(localDate.format(dateFormatter2));
//		
//		DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
//		System.out.println(localDate.format(dateFormatter3));

//		int a = 5;
//		int b=5;
//		int c=3;
//		if (a>b || a!=c) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}

//		for (int i = 0; i < 20; i++) {
//			if (i % 2 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}

//		int a = 0;
//		do {
//			System.out.println(a);
//			a++;
//		} while (a < 6);
//		
//		while (a < 6) {
//			System.out.println(a);
//			a++;
//		}

//		Group group1 = new Group();
//		group1.id = 1;
//		group1.groupName = "group1";
//
//		Group group2 = new Group();
//		group2.id = 2;
//		group2.groupName = "group2";
//
//		Group group3 = new Group();
//		group3.id = 3;
//		group3.groupName = "group3";
//
//		Group[] groups = { group1, group2, group3 };
//
//		for (Group item : groups) { /**item là tên biến, đặt thế nào thì tùy **/
//			System.out.println("ID: " + item.id + "\nGroup Name: " + item.groupName);
//		}
//		
//		for (int i = 0; i < groups.length; i++) {
//			System.out.println("ID: " + groups[i].id + "\nGroup Name: " + groups[i].groupName);
//		}

//		int a = 16;
//		int b = 2;
//		int c = 1;
//
//		switch (a % 4) {
//		case 0:
//			System.out.println("Day la so CHIA HET CHO 4");
//			break;
//		case 1:
//			System.out.println("Day la so chia 4 du 1");
//			break;
//		case 2:
//			System.out.println("Day la so chia 4 du 2");
//			break;
//		default:
//			System.out.println("Day la so chia 4 du 3");
//			break;
//		}

//        System.out.println((a == c) ? ("Bang nhau") : ("Khac nhau"));
//        
//        if (a == b) {
//            System.out.println("a va b bang nhau.");
//        } else if (a < b){
//            System.out.println("a nho hon b.");;
//        } else  {
//            System.out.println("a lon hon b.");
//        }
	}

}
