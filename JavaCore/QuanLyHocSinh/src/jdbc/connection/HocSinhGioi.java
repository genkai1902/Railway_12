package jdbc.connection;

public class HocSinhGioi extends HocSinh {
	private EDoiTuyen doiTuyenHSG;

	public EDoiTuyen getDoiTuyenHSG() {
		return doiTuyenHSG;
	}

	public void setDoiTuyenHSG(EDoiTuyen doiTuyenHSG) {
		this.doiTuyenHSG = doiTuyenHSG;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Doi tuyen HSG: " + doiTuyenHSG;
	}
}
