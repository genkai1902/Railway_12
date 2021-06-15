package railway12;

public abstract class PhoneData{
	

	public abstract void insertContact(String name, String num);
	
	public abstract void removeContact(String name, String num);

	public abstract void updateContact(String name, String newNum);
	
	public abstract void searchContact(String name);
}
