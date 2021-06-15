package railway12.vti.lesson5.shapes;

public class Rectangles extends Shapes {
	private String name = "Hinh chu nhat";
	private double chieuDai;
	private double chieuRong;

	public Rectangles(double l, double s) {
		this.chieuDai = l;
		this.chieuRong = s;
	}

	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	@Override
	public double chuVi() {
		return (this.chieuDai + this.chieuRong) * 2;
	}

	@Override
	public double dienTich() {
		return this.chieuDai * this.chieuRong;
	}
	
	@Override
	public String toString() {
		return "Ten: " + this.name + "\nChieu dai: " + this.chieuDai + "\nChieu rong" + this.chieuRong + "\nChu vi: "
				+ chuVi() + "\nDien tich: " + dienTich();
	}
}
