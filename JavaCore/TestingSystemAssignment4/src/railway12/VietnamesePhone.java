package railway12;

import java.util.ArrayList;
import java.util.List;

public class VietnamesePhone extends PhoneData{
	
	List<Contact> contacts = new ArrayList<Contact>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public void insertContact(String name, String number) {
		Contact contact = new Contact(name, number);
		this.contacts.add(contact);
	}

	@Override
	public void removeContact(String name, String num) {
				
	}

	@Override
	public void updateContact(String name, String newNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		
	}
	
	
}
