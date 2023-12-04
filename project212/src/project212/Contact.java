package project212;

import java.util.Scanner;
//o
/*
CLASS: Contact
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
11-03-2023
TEAM:
Abdalaziz Almutairi
Ibrahim Althanyyan
Abdullah Alomran
AUTHORS:
Abdalaziz Almutairi (443101720)
Ibrahim Althanyyan  (443101693)
Abdullah Alomran    (443100868)
*/

public class Contact implements Comparable<Contact> {

	private String contact_name;
	private String email;
	private String address;
	private String notes;
	private String phone_number;
	private String birthday;
	
	eventLinkedList scheduledEvents = new eventLinkedList();
	
	
	public Contact(String contact_name, String phone_number, String email, String address, String birthday,
			String notes) {

		this.contact_name = contact_name;
		this.email = email;
		this.address = address;
		this.notes = notes;
		this.phone_number = phone_number;
		this.birthday = birthday;
	}

	public Contact(Contact c) {

		this.contact_name = c.contact_name;
		this.phone_number = c.phone_number;
		this.email = c.email;
		this.address = c.address;
		this.birthday = c.birthday;
		this.notes = c.notes;

	}
	public Contact() {
		this.contact_name = "";
		this.email = "";
		this.address = "";
		this.notes = "";
		this.phone_number = "";
		this.birthday = "";
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

	@Override
	public int compareTo(Contact contact) {
        if (this.phone_number.toUpperCase().charAt(0) > contact.getPhone_number().toUpperCase().charAt(0))
            return 1;
        else if (this.phone_number.toUpperCase().charAt(0) == contact.getPhone_number().toUpperCase().charAt(0)) {
            int limit;
            if (!this.phone_number.equalsIgnoreCase(contact.getPhone_number())) {
                limit = Math.min(this.phone_number.length(), contact.getPhone_number().length());
                for (int i = 1; i < limit; i++) {
                    if (this.phone_number.toUpperCase().charAt(i) > contact.getPhone_number().toUpperCase().charAt(i)) {
                        return 1;
                    } else if (this.phone_number.toUpperCase().charAt(i) < contact.getPhone_number().toUpperCase().charAt(i)) {
                        return -1;
                    }
                }
                if (this.phone_number.length() != contact.getPhone_number().length())
                    return 2;
            }
            return 0;
        } else
            return -1;
    }
	

	@Override
	public String toString() {
		return "\nName:" + contact_name + "\nPhone Number:"+phone_number +"\nEmail Address:"+ email+"\nAddress:"+ address+"\nBirthday:"+birthday+"\nNotes:"+notes;
	}
	
	
	
}