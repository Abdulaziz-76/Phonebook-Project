package project212;

import java.util.Scanner;

public class Contact implements Comparable<Contact> {

	private String contact_name;
	private String email;
	private String address;
	private String notes;
	private String phone_number;
	private String birthday;
	
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
	

	

	//public int compareTo(String s) {
		
	//	return contact_name.compareToIgnoreCase(s);

	//}

	public int compareTo(Contact r) {
		return contact_name.compareTo(r.contact_name);

	}
	@Override
	public String toString() {
		return "Name:" + contact_name + "\nPhone Number:"+phone_number +"\nEmail Address:"+ email+"\nAddress:"+ address+"\nBirthday:"+birthday+"\nNotes:"+notes;
	}
	
	
	
}