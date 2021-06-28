package jdbc.connection;

import java.util.Date;

public class HocSinhYeu extends Hocsinh {
	private float badMark;
	private Date meetingDate;
	
	public float getBadMark() {
		return badMark;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setBadMark(float badMark) {
		this.badMark = badMark;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", diem thap nhat: " + badMark + ", ngay moi phu huynh: " + meetingDate + "\n------------";
	}
}
