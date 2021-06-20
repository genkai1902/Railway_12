package assignment8.entity;

public class Student {
	private static int countID = 0;
	private int id;
	private String name;
	
	public Student() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.id = ++countID;
		this.name = name;
	}
		
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id + " - " + name;
	}
}
