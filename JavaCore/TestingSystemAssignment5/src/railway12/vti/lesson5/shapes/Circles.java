package railway12.vti.lesson5.shapes;

public class Circles extends Shapes{
	private String name = "Hinh tron";
	private double banKinh;
	
	public Circles(double r) {
		this.banKinh = r;
	}
	
	public void setBanKinh(double r) {
		this.banKinh = r;
	}
	
	public double getBanKinh() {
		return this.banKinh;
	}
	
	@Override
	public double chuVi() {
		return this.banKinh*2*Math.PI;
	}

	@Override
	public double dienTich() {
		return Math.pow(banKinh, 2)*Math.PI;
	}
	
	@Override
	public String toString() {
		return "Ten: " + this.name + "\nBan kinh: " + this.banKinh + "\nChu vi: " + chuVi() + "\nDien tich: "
				+ dienTich();
	}
	
}
