package railway12.revision.entity;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHS {
	static List<HocSinh> dsHocSinh = new ArrayList<HocSinh>();
	
	public static void addStudent(HocSinh student) {
		dsHocSinh.add(student);
	}
	
	public static void showAllStudent() {
		for (HocSinh hocSinh : dsHocSinh) {
			System.out.println(hocSinh);
		}
	}
}
