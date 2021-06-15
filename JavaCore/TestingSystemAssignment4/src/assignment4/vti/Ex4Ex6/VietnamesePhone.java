package assignment4.vti.Ex4Ex6;

import java.util.ArrayList;
import java.util.List;

public class VietnamesePhone extends Phone{
	List<Contact> listContact = new ArrayList<Contact>();
	
	@Override
	public void insertContact(String name, String number) {
		Contact contact = new Contact(name, number);
		this.listContact.add(contact);
	}

	@Override
	public void removeContact(String delName) {
		for (Contact contact : listContact) {
			if (delName.equals(contact.getName())) {
				this.listContact.remove(contact);
			}
		}
	}

	@Override
	public void updateContact(String updateName, String newNum) {
		for (Contact contact : listContact) {
			if (updateName.equals(contact.getName())) {
				contact.setNum(newNum);
			}
		}
		
	}

	@Override
	public void searchContact(String searchName) {
		System.out.println("Ten nguoi ban tim kiem: "+searchName);
		System.out.println("Danh sach thong tin nguoi trung khop: ");
		for (Contact contact : listContact) {
			if (searchName.equals(contact.getName())) {
				System.out.println(contact.getName());
				System.out.println(contact.getNum());
				System.out.println("-------------");
			}
		}
	}

	@Override
	public void showAllContact() {
		for (Contact contact : listContact) {
			System.out.println(contact.getName());
			System.out.println(contact.getNum());
			System.out.println("-------------");
		}
		
	}
	
}
