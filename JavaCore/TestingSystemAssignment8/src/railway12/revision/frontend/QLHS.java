package railway12.revision.frontend;

import java.util.Scanner;

import railway12.revision.backend.AddNewStudent;
import railway12.revision.backend.HomeWindow;
import railway12.revision.backend.SearchByName;
import railway12.revision.backend.ShowAllStudent;

public class QLHS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Tạo một class SinhVien có các thuộc tính là: name, age, email, phone
		 Tạo 3 class kế thừa:
		 	- Học sinh giỏi thêm thuộc tính đội tuyển học sinh giỏi (enum toán lý hóa)
		 	- Học sinh khá thêm thuộc tính điểm trung bình
		 	- học sinh yếu thêm thuộc tính môn học có điểm thấp nhất và ngày mời PH làm việc
		 	
		 Viết chương trình quản lý học sinh gồm:
		 	- Thêm mới
		 	- Hiển thị thông tin toàn bộ danh sách học sinh
		 	- Tìm kiếm theo họ tên
		 */
		HomeWindow.Home();
		boolean isNotExit = true;
		while (isNotExit) {
			try {
				Scanner sc1  = new Scanner(System.in);
				int homeChoice = sc1.nextInt();
				switch (homeChoice) {
				case 1:
					AddNewStudent.addStudent();
					break;
				case 2:
					ShowAllStudent.listStudent();;
					break;
				case 3:
					SearchByName.searchStudent();;
					break;
				case 4:
					System.out.println("Cam on ban da su dung chuong trinh cua chung toi");
					System.out.println("Nho danh gia 5* nhe!");
					isNotExit = false;
					break;
				default:
					System.out.println("Chuc nang khong chinh xac, moi ban nhap lai chuc nang: ");
					break;
				}
			} catch (Exception e) {
				System.err.println("Moi ban nhap vao so, khong duoc phep nhap chu!");
				System.out.println("Moi ban chon lai chuc nang: ");
			}
		}
		
	}

}
