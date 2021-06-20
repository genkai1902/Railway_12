package assignment7.entity;

import java.io.Serializable;

public class Student implements Serializable{
	int id;
	String name;
	String college = "DHBK";
	int moneyGroup = 0;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int funding(int money) {
		moneyGroup += money;
		System.out.println("Fund: " + moneyGroup);
		return moneyGroup;
	}
	
	public void display() {
		System.out.println(id + " - " + name + " - " + college);
	}


	public static void change() {
		// TODO Auto-generated method stub
		
	}
}
