package jdbc.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HocSinhYeu extends HocSinh{
	private float badMark;
	private Date hopPH;
	
	public float getBadMark() {
		return badMark;
	}
	public void setBadMark(float badMark) {
		this.badMark = badMark;
	}
	public Date getHopPH() {
		return hopPH;
	}
	public void setHopPH(Date ngayHPH) throws ParseException {
		this.hopPH = ngayHPH;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Diem thap nhat: " + badMark + ", Ngay moi hop PH: " + hopPH;
	}
}
