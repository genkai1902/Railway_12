package assignment4.vti.Ex4Ex6;

public class Manager extends User{

	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return (getSalaryRatio()*520);
	}

}
