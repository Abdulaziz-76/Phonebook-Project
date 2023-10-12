package project212;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Phonebook {
	LinkedListADT<Contact> ln = new LinkedListADT<Contact>();
	String input2="", input3="", input4="", input5="", input6="", input1="";
	public void add_contact(Scanner in) {
		int count = 0;
		
		in.nextLine();
		do {
			System.out.println("Enter the contact's name:");
			input1 = in.nextLine();
			if (ln.search(input1)!=null)
				System.out.println("Contact already exists");///////////////// Aziz == Az i z?
		} while (ln.search(input1)!=null);

		
		do {
			System.out.println("Enter the contact's phone number:");
			input2 = in.nextLine();
			input2 = input2.replaceAll("[^0-9]", "");
			if (input2.length() != 10)
				System.out.println("Wrong input!!");
		} while (input2.length() != 10);

		
		do {
			count = 0;
			System.out.println("Enter the contact's email address:");
			input3 = in.nextLine();
			input3 = input3.replaceAll("[ ]", "");
			for (int i = 0; i < input3.length(); i++) {
				if ((input3.charAt(i)) == '@') {
					count++;
				}
			}
			if (count != 1 || (input3.charAt(0)) == '@' || (input3.charAt(input3.length() - 1)) == '@')
				System.out.println("Wrong input!!");

		} while (count != 1 || (input3.charAt(0)) == '@' || (input3.charAt(input3.length() - 1)) == '@');

		System.out.println("Enter the contact's address:");
		input4 = in.nextLine();

		String datePattern = "\\d{2}/\\d{2}/\\d{4}";///////////////// can we use it?
		Pattern pattern = Pattern.compile(datePattern);

		do {
			System.out.println("Enter the contact's birthday:");
			input5 = in.nextLine();

			Matcher matcher = pattern.matcher(input5);
			if (!matcher.matches()) {
				System.out.println("Invalid date format. Please use MM/DD/YYYY format.");
			}
		} while (!input5.matches(datePattern));

		System.out.println("Enter any notes for the contact:");
		input6 = in.nextLine();

		ln.insert(new Contact(input1, input2, input3, input4, input5, input6));
		System.out.println("Contact added successfully!");

	}

	public void searchCo(Scanner in) {
		System.out.println("Enter search criteria:");
		System.out.println("1. Name");
		System.out.println("2. Phone Number");
		System.out.println("3. Email Address");
		System.out.println("4. Address");
		System.out.println("5. Birthday");
		System.out.println("Enter your choice:");
		int num = in.nextInt();
		switch (num) {
		case 1:
			System.out.println("Enter the contact's name:");
			in.nextLine();
			input1=in.nextLine();
			Contact c1 =(Contact) ln.search(input1).getData();
			if(ln.search(input1)!=null) { 
				System.out.println("Contact found!");
				System.out.println(ln.search(input1).getData());
			}
			break;
		case 2:
			System.out.println("Enter the contact's Phone Number:");
			input2=in.nextLine();
			input2=in.nextLine();
			Contact c2 =(Contact) ln.search(input1).getData();
			if(c2!=null) {
				System.out.println("Contact found!");
				System.out.println(c2);
			}
			break;
		case 3:
			System.out.println("Enter the contact's Email Address:");
			in.nextLine();
			input3=in.nextLine();
			Contact c3 =(Contact) ln.search(input1).getData();
			if(c3!=null) {
				System.out.println("Contact found!");
				System.out.println(c3);
			}
			break;
		case 4:
			System.out.println("Enter the contact's Address:");
			input4=in.nextLine();
			input4=in.nextLine();
			Contact c4 =(Contact) ln.search(input1).getData();
			if(c4!=null) {
				System.out.println("Contact found!");
				System.out.println(c4);
			}
			break;
		case 5:
			System.out.println("Enter the contact's Birthday:");
			input5=in.nextLine();
			input5=in.nextLine();
			Contact c5 =(Contact) ln.search(input1).getData();
			if(c5!=null) {
				System.out.println("Contact found!");
				System.out.println(c5);
			}
			break;

		default:

		}
	}
}

