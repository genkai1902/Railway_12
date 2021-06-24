package railway12.revision.backend;

import java.util.Scanner;

import railway12.revision.entity.DanhSachHS;
import railway12.revision.frontend.QLHS;

public class ShowAllStudent {
	public static void listStudent() {
		System.out.println("---------- Students List ----------");
		System.out.println("");
		DanhSachHS.showAllStudent();
		System.out.println("------- End of Students List -------");
		System.out.println("Nhan phim 0 de quay ve man hinh chinh");
		Scanner sc = new Scanner(System.in);
		int back = sc.nextInt();
		while (back != 0) {
			System.out.println("Nhan phim 0 de quay ve man hinh chinh");
			back = sc.nextInt();
		}
		QLHS.main(null);
	}
}
