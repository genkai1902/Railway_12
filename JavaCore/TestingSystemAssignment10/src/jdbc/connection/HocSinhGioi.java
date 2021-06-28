package jdbc.connection;

public class HocSinhGioi extends Hocsinh{
	private EDoiTuyen doiTuyenHSG;

	public EDoiTuyen getDoiTuyenHSG() {
		return doiTuyenHSG;
	}

	public void setDoiTuyenHSG(EDoiTuyen doiTuyenHSG) {
		this.doiTuyenHSG = doiTuyenHSG;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", doi tuyen HSG: " + doiTuyenHSG + "\n------------";
	}
}
