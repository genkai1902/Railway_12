package railway12.vti.lesson5.shapes;

public class Squares extends Shapes{
	
	private String name = "Hinh vuong";
	private double canh;
	
	public Squares(double a) {
		this.canh = a;
	}
	
	public void setCanh(double a) {
		this.canh = a;
	}
	
	public double getCanh() {
		return this.canh;
	}
	
	@Override
	public double chuVi() {
		return this.canh*4;
	}

	@Override
	public double dienTich() {
		return Math.pow(this.canh, 2);
	}
	
	@Override
	public String toString() {
		return "Ten: " + this.name + "\nDo dai canh: " + this.canh + "\nChu vi: " + chuVi() + "\nDien tich: "
				+ dienTich();
	}
}
