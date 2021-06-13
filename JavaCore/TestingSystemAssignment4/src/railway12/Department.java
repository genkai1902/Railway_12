package railway12;

public class Department {
//		Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên
	int id;
	String nameDepartment;
	
	public Department() {
		
	}
	
	public Department(String name) {
		this.nameDepartment = name;
	}

}
