package jdbc.connection;


public enum EDoiTuyen {
	TOAN("toan"), LY("ly"), HOA("hoa");
	
	private String value;
	
	EDoiTuyen(String string) {
		this.value = string;
	}
	public static EDoiTuyen fromValue(String value) {
		while (true) {
			try {
				for (EDoiTuyen category : values()) {
					if (category.value.equalsIgnoreCase(value)) {
						return category;
					}
				}
			} catch (Exception e) {
				System.err.println("Doi tuyen hoc sinh chua chinh xac.");
				System.out.println("Moi ban nhap lai doi tuyen HSG: ");
			}
		}
	}
}
