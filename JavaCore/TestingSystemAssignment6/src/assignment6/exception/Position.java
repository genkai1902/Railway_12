package assignment6.exception;

public class Position {
	private static int countID = 0;
	private int id;
	private PositionName name;
	
	public Position() throws Exception {
		this.id = ++countID;
		boolean isDone = false;
		while (!isDone) {
			System.out.println("Nhap vao vi tri: \n1.Dev	2.Test	  3.Scrum_Master	4.PM");
			int i = ScannerUtils.inputInt();
			switch (i) {
			case 1:
				this.name = PositionName.DEV;
				isDone = true;
				break;
			case 2:
				this.name = PositionName.TEST;
				isDone = true;
				break;
			case 3:
				this.name = PositionName.SCRUM_MASTER;
				isDone = true;
				break;
			case 4:
				this.name = PositionName.PM;
				isDone = true;
				break;
			default:
				System.out.println("Nhap loi.");
				continue;
			}
		}
	}

	public int getId() {
		return id;
	}

	public PositionName getName() {
		return name;
	}
	
	
}
