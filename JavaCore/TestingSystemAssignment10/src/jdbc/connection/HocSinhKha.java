package jdbc.connection;

public class HocSinhKha extends Hocsinh{
	private float avgMark;

	public float getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(float avgMark) {
		this.avgMark = avgMark;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", diem trung binh mon: " + avgMark + "\n------------";
	}
}
