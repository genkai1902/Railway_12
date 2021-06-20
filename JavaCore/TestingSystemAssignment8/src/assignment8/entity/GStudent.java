package assignment8.entity;

public class GStudent <T> {
	T id;
	String name;
	
	public GStudent(T id, String name) {
		this.id = id;
		this.name = name;
	}
}
