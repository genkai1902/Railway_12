package jdbc.connection;

public class HocSinhKha extends HocSinh {
	private float avg;

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Diem trung binh: " + avg;
	}
}
