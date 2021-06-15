package assignment4.vti.Ex4Ex6;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
	List<Contact> listContact = new ArrayList<Contact>();
	
	public abstract void showAllContact();

	public abstract void insertContact(String name, String number);

	public abstract void removeContact(String name);

	public abstract void updateContact(String name, String newNum);

	public abstract void searchContact(String name);

}
