package railway12.vti.lesson5.shapes;

public class Parallelograms extends Shapes {
	private String name = "Hinh binh hanh";
	private double chieuCao;
	private double chieuDai;
	private double chieuRong;

	public Parallelograms(double h, double l, double s) {
		this.chieuCao = h;
		this.chieuDai = l;
		this.chieuRong = s;
	}

	public double getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}

	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return this.chieuRong;
	}

	public void setChieuRong(double s) {
		this.chieuRong = s;
	}

	@Override
	public double chuVi() {
		return (this.chieuRong + this.chieuDai) * 2;
	}

	@Override
	public double dienTich() {
		return this.chieuCao * this.chieuDai;
	}

	@Override
	public String toString() {
		return "Ten: " + this.name + "\nChieu dai: " + this.chieuDai + "\nChieu rong" + this.chieuRong + "\nChieu cao: "
				+ this.chieuCao + "\nChu vi: " + chuVi() + "\nDien tich: " + dienTich();
	}
}
