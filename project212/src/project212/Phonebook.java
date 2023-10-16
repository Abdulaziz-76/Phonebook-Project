package project212;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Phonebook {
	LinkedListADT<Contact> lnContact;
	LinkedListADT<Event> lnEvent;
	String input2, input3, input4, input5, input6, input1;

	public Phonebook() {
		lnContact = new LinkedListADT<Contact>();
		lnEvent = new LinkedListADT<Event>();

	}

	public void add_contact(Scanner in) {
		int count = 0;

		in.nextLine();
		
		do {
			count = 0;
			System.out.println("Enter the contact's name:");
			input1 = in.nextLine();
			
			if (lnContact.search_NAME(input1) != null) {
				System.out.println("Contact already exists");///////////////// Aziz == Az i z?
				count=1;
			}
			if(input1.equals(" ")||input1.equals("")) {
				System.out.println("Wrong input!");
				count=1;
			}
		} while (count!=0);

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

		lnContact.insert(new Contact(input1, input2, input3, input4, input5, input6));
		System.out.println("Contact added successfully!");

	}
	
	public void search_Contact(Scanner in) {
		int num = 0;;
		do {
			System.out.println("Enter search criteria:");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email Address");
			System.out.println("4. Address");
			System.out.println("5. Birthday");
			System.out.println("Enter your choice:");
		try {
			
			num = in.nextInt();
			
			switch (num) {

			case 1:

				System.out.println("Enter the contact's name:");
				in.nextLine();
				input1 = in.nextLine();
				Contact c1 = null;
				try {
					c1 = (Contact) lnContact.search_NAME(input1).getData();
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
					c2 = (Contact) lnContact.search_PHONE(input2).getData();
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

				if (!lnContact.search_EMAIL(input3)) {
					System.err.println("Contact not found!");
				}

				break;

			case 4:

				System.out.println("Enter the contact's Address:");
				input4 = in.nextLine();
				input4 = in.nextLine();

				if (!lnContact.search_ADDRESS(input4)) {
					System.err.println("Contact not found!");
				}
				break;

			case 5:

				System.out.println("Enter the contact's Birthday:");
				input5 = in.nextLine();
				input5 = in.nextLine();

				if (!lnContact.search_BIRTHDAY(input5)) {
					System.err.println("Contact not found!");
				}
				break;

			default:
				System.out.println("Choose a number from 1-5");

			}
		} catch (Exception x) {
			System.err.println("only integers number from 1-5");
			in.nextLine();
		}
		}while(num>5||num<1);
	}
	
	
	
	public void deleteContact() {
		Scanner in = new Scanner(System.in);
		System.out.println("contact name to delete");
		String inputo = in.nextLine();
		Node<Contact> c =lnContact.search_NAME(inputo);
		if (c!=null) {
			lnContact.delete(c);
			System.out.println("Successfully delete");
			
			while(lnEvent.search_Event_name(inputo)!=null)
				lnEvent.delete(lnEvent.search_Event_name(inputo));
					
		    }

		else
			System.out.println("Not found");

	}
	
	
	
	public void Schedule(Scanner in) {
		System.out.println("Enter event title:");
		in.nextLine();
		input1 = in.nextLine();

		System.out.println("Enter contact name:");
		input2 = in.nextLine();
		if (lnContact.search_NAME(input2) == null) {
			System.out.println("Contact not found!");
		}
		
		else {
			String dateTimeInput=null;
			int x;
			do {
			 x=0;
			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
			 dateTimeInput = in.nextLine();
			
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				Date eventDate = dateFormat.parse(dateTimeInput);
				
			} catch (Exception e) {
				System.err.println("Invalid date and time format. Please use MM/DD/YYYY HH:MM.");
				x=1;
			}
			}while(x==1);
			
			if(lnEvent.search_Event_name(input2)!=null && lnEvent.search_Event_date(dateTimeInput)!=null)
				System.out.println("There is an Event at the same time");
			
			
				else {
					System.out.println("Enter event location:");
					input3 = in.nextLine();
					
				
					lnEvent.insert((new Event(input1, dateTimeInput, input3,(Contact) lnContact.search_NAME(input2).getData())));
					System.out.println("Event scheduled successfully!");
			}
		}
	}
	
	
	

	public void searchEvent(Scanner in) {
		System.out.println("Enter search criteria:");
		System.out.println("1. contact name");
		System.out.println("2. Event tittle");
		int num = 0;
		try {

			num = in.nextInt();

			switch (num) {

			case 1:

				System.out.println("Enter the contact's name:");
				in.nextLine();
				input1 = in.nextLine();
				Contact c1 = null;
				try {
					c1 =(Contact) lnContact.search_NAME(input1).getData();
				} catch (Exception x) {
					System.err.println("Event not found!");
				}

				if (c1!=null) {
					lnEvent.printByName(c1.getContact_name());
				}
				
				break;

			case 2:

				System.out.println("Enter the event title:");
				input2 = in.nextLine();
				input2 = in.nextLine();

				Event e2 = null;
				try {
					e2 = (Event)lnEvent.search_Event_title(input2).getData();
				} catch (Exception x) {
					System.err.println("Event not found!");
				}

				if (e2 != null) {
					lnEvent.printByTitle(input2);
				}
				break;

			default:
				System.out.println("Choose a number from 1-2");

			}
		} catch (Exception x) {
			System.err.println("only integers number from 1-2");
			in.nextLine();
		}

	}
	public void printBy_firstName(Scanner in) {
		System.out.println("Enter the first name:");
		input1=in.next();
		lnContact.printfirstName(input1);
		
		
	}

}
