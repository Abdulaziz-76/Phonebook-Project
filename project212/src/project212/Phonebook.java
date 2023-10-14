package project212;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Phonebook {
	LinkedListADT<Contact> ln = new LinkedListADT<Contact>();
	String input2 = "", input3 = "", input4 = "", input5 = "", input6 = "", input1 = "";

	public void add_contact(Scanner in) {
		int count = 0;

		in.nextLine();
		do {
			System.out.println("Enter the contact's name:");
			input1 = in.nextLine();
			if (ln.search_NAME(input1) != null)
				System.out.println("Contact already exists");///////////////// Aziz == Az i z?
		} while (ln.search_NAME(input1) != null);

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
		int num=0;
		try {
			
		 num = in.nextInt();
		
		switch (num) {

		case 1:

			System.out.println("Enter the contact's name:");
			in.nextLine();
			input1 = in.nextLine();
			Contact c1 = null;
			try {
				c1 = (Contact) ln.search_NAME(input1).getData();
			} catch (Exception x) {
				System.err.println("Contact not found!");
			}

			if (c1 != null) {
				System.out.println("Contact found!");
				System.out.println(c1.toString());
			}
			break;

		case 2:

			System.out.println("Enter the contact's Phone Number:");
			input2 = in.nextLine();
			input2 = in.nextLine();

			Contact c2 = null;
			try {
				c2 = (Contact) ln.search_PHONE(input2).getData();
			} catch (Exception x) {
				System.err.println("Contact not found!");
			}

			if (c2 != null) {
				System.out.println("Contact found!");
				System.out.println(c2.toString());
			}
			break;

		case 3:

			System.out.println("Enter the contact's Email Address:");
			in.nextLine();
			input3 = in.nextLine();
			
			if(!ln.search_EMAIL(input3)) {
				System.err.println("Contact not found!");
			}
			
			break;

		case 4:

			System.out.println("Enter the contact's Address:");
			input4 = in.nextLine();
			input4 = in.nextLine();

			if(!ln.search_ADDRES(input4)) {
				System.err.println("Contact not found!");
			}
			break;

		case 5:

			System.out.println("Enter the contact's Birthday:");
			input5 = in.nextLine();
			input5 = in.nextLine();
			
			if(!ln.search_BIRTHDAY(input5)) {
				System.err.println("Contact not found!");
			}
			break;

		default:
			System.out.println("Choose a number from 1-5");

		}
		}catch(Exception x) {
			System.err.println("only integers number from 1-5");
			 in.nextLine();
		}
	}
	
	public void deleteContact() {
		Scanner in =new Scanner(System.in);
		System.out.println("contact name to delete");
		
		String inputo=in.nextLine();
		if(ln.delete(inputo)) {
			System.out.println("Successfully delete");
			
		}
		
		else
			System.out.println("Not found");
		
		
	}
	public void Schedule(Scanner in) {
		System.out.println("Enter event title:");
		in.nextLine();
		input1=in.nextLine();
		System.out.println("Enter contact name:");
		input2=in.nextLine();
		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
        String dateTimeInput = in.nextLine();  
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Date eventDate = dateFormat.parse(dateTimeInput);
          
            
        } catch (Exception e) {
            System.err.println("Invalid date and time format. Please use MM/DD/YYYY HH:MM.");
        }
        
		System.out.println("Enter event location:");
		input3=in.nextLine();
		Contact r=null;
		try {
		 r=ln.search_NAME(input2).getData();
		}catch(Exception x) {
			System.out.println("Contact not found!");
		}
		Event e1 =new Event(input1,dateTimeInput,input3,(Contact)r);
		
	}
	public void searchEvent(Scanner in) {	
		System.out.println("Enter search criteria:");
		System.out.println("1. contact name");
		System.out.println("2. Event tittle");
		int num=0;
		try {
			
		 num = in.nextInt();
		
		switch (num) {

		case 1:

			System.out.println("Enter the contact's name:");
			in.nextLine();
			input1 = in.nextLine();
			Contact c1 = null;
			try {
				c1 = (Contact) ln.search_NAME(input1).getData();
			} catch (Exception x) {
				System.err.println("Contact not found!");
			}

			if (c1 != null) {
				System.out.println("Contact found!");
				System.out.println(c1.toString());
			}
			break;

		case 2:

			System.out.println("Enter the event title:");
			input2 = in.nextLine();
			input2 = in.nextLine();

			Contact c2 = null;
			try {
				c2 = (Contact) ln.search_PHONE(input2).getData();
			} catch (Exception x) {
				System.err.println("Contact not found!");
			}

			if (c2 != null) {
				System.out.println("Contact found!");
				System.out.println(c2.toString());
			}
			break;

		default:
			System.out.println("Choose a number from 1-5");

		}
		}catch(Exception x) {
			System.err.println("only integers number from 1-5");
			 in.nextLine();
		}
		
	}
	
}
