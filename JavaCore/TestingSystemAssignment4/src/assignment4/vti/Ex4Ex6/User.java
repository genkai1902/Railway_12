package assignment4.vti.Ex4Ex6;

public abstract class User {
	private String name;
	private double salaryRatio;
	
	public User(String name, double salaryRatio) {
		this.name = name;
		this.salaryRatio = salaryRatio;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSalaryRatio(double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	
	public String getName() {
		return this.name;
	}
	public double getSalaryRatio() {
		return this.salaryRatio;
	}
	
	public abstract double calculatePay();
	
	public void displayInfo() {
		System.out.println(this.name);
		System.out.println(this.salaryRatio);
	}
	
}
