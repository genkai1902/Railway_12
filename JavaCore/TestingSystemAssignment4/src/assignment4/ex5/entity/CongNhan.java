package assignment4.ex5.entity;

public class CongNhan extends CanBo {
		private String bacCongNhan;
	
		public CongNhan(String name, int age, Gender gender, String address, String bac) {
			super(name, age, gender, address);
			// TODO Auto-generated constructor stub
			this.bacCongNhan = bac;
		}
		
		public String getBac() {
			return this.bacCongNhan;
		}
		
		public void setBac(String bac) {
			this.bacCongNhan = bac;
		}
		
		@Override
		public void hienThiThongTin() {
//			super()
		}
}
