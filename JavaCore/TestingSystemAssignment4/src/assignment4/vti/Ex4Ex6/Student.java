package assignment4.vti.Ex4Ex6;

public class Student {
	// cau a
	private int id;
	private String name;
	private String hometown;
	private int diemHL;

	// cau b
	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.diemHL = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getDiemHL() {
		return diemHL;
	}

	// cau c
	public void setDiemHL(int diemHL) {
		this.diemHL = diemHL;
	}

	// cau d
	public int diemCong(int diemCong) {
		this.diemHL += diemCong;
		if (this.diemHL > 10) {
			this.diemHL = 10;
		}
		return this.diemHL;
	}

	// cau e
	public void thongTinSV() {
		System.out.println("Ten SV: " + this.name);
		System.out.println("Diem hoc luc: "+this.diemHL);
		if (this.diemHL < 4) {
			System.out.println("Hoc luc: Yeu");
		} else if (this.diemHL < 6){
			System.out.println("Hoc luc: Trung binh");
		} else if (this.diemHL < 8 ) {
			System.out.println("Hoc luc: Kha");
		} else {
			System.out.println("Hoc luc: Gioi");
		}
	}

}
