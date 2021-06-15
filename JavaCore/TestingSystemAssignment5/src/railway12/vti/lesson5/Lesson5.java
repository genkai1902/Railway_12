package railway12.vti.lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import railway12.vti.lesson5.shapes.Circles;
import railway12.vti.lesson5.shapes.Parallelograms;
import railway12.vti.lesson5.shapes.Rectangles;
import railway12.vti.lesson5.shapes.Shapes;
import railway12.vti.lesson5.shapes.Squares;

public class Lesson5 {
	
	static List<Shapes> listShapes = new ArrayList<Shapes>();
	
	public static void main(String[] args) {
		// Tạo một class abstract Shapes có 2 phương thức abstract tính chu vi và diện tích.
		// Khai báo các lớp con kế thừa lại lớp Shapes: vuông tròn chữ nhật bình hành.
		// Khai báo các thuộc tính cho các lớp con và tính chu vi, diện tính.
		// Tạo chương trình quản lý hình học, cho phép tạo mới hình, hiển thị thông tin như bán kính, chiều rộng, chu vi, diện tích.
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		boolean c = true;
		
		System.out.println("Chao mung den voi ung dung Quan ly hinh hoc");
		while (c == true) {
			System.out.println("---------------- * * * ----------------");
			System.out.println("1. Tao moi hinh hoc");
			System.out.println("2. Thong tin cac hinh da duoc tao");
			System.out.println("3. Thoat");
			System.out.print("Moi ban chon chuc nang: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				createShapes();
				break;
			case 2:
				infoShape();
				break;
			case 3:
				c = false;
				System.out.println("Cam on cac ban da su dung ung dung. \nNho danh gia 5 sao cho minh nhe ^^");
				break;	
			default:
				System.out.println("Moi ban nhap chinh xac cac lua chon.");
				break;
			}	
		}
	}
	
	private static void createShapes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Tao hinh tron");
		System.out.println("2. Tao hinh vuong");
		System.out.println("3. Tao hinh chu nhat");
		System.out.println("4. Tao hinh binh hanh");
		System.out.println("5. Quay lai");
		System.out.print("Moi ban chon hinh muon tao: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			createCircle();
			break;
		case 2:
			createSquare();
			break;
		case 3:
			createRectangle();
			break;
		case 4:
			createParallelogram();
			break;
		case 5:
			main(null);;
			break;
		default:
			System.out.println("Nhap loi, vui long nhap lai lua chon chinh xac.");
			createShapes();
			break;
		}
//		sc.close();
	}
	
	private static void createCircle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui long nhap ban kinh hinh tron: ");
		double r = sc.nextDouble();
		Shapes circle = new Circles(r);
		listShapes.add(circle);
//		sc.close();
//		main(null);
	}
	
	private static void createSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui long nhap canh hinh vuong: ");
		double a = sc.nextDouble();
		Shapes square = new Squares(a);
		listShapes.add(square);
//		sc.close();
//		main(null);
	}
	
	private static void createRectangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui long nhap chieu dai hinh chu nhat: ");
		double l = sc.nextDouble();
		System.out.print("Vui long nhap chieu rong hinh chu nhat: ");
		double s = sc.nextDouble();
		Shapes rec = new Rectangles(l, s);
		listShapes.add(rec);
//		sc.close();
//		main(null);
	}
	
	private static void createParallelogram() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui long nhap chieu dai hinh binh hanh: ");
		double l = sc.nextDouble();
		System.out.print("Vui long nhap chieu rong hinh binh hanh: ");
		double s = sc.nextDouble();
		System.out.print("Vui long nhap chieu cao hinh binh hanh: ");
		double h = sc.nextDouble();
		Shapes parallel = new Parallelograms(h, l, s);
		listShapes.add(parallel);
//		sc.close();
//		main(null);
	}
	
	private static void infoShape() {
		for (Shapes shape : listShapes) {
			System.out.println(shape.toString());
		};
	}
}
