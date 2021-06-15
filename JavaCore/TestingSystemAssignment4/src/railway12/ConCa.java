package railway12;

public class ConCa extends DongVat{
	String name;
	
	public void conCaKeu(String tiengKeu) {
		System.out.println("Tieng keu: "+tiengKeu);
	}
	public void conCaKeu(String tiengKeu, String tiengKeu2) {
		System.out.println("Tieng keu: "+tiengKeu+" "+tiengKeu2);
	}
	public void conCaKeu(String tiengKeu, String tiengKeu2, String tiengKeu3) {
		System.out.println("Tieng keu: "+tiengKeu+" "+tiengKeu2+" "+tiengKeu3);
	}
	@Override
	void diChuyen() {
		System.out.println("con ca boi");
	}
}
