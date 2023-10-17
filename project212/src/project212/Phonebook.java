package project212;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.Date;
/*
CLASS: PhoneBook
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
10-17-2023
TEAM:
Abdalaziz Almutairi
Ibrahim Althanyyan
Abdullah Alomran
AUTHORS:
Abdalaziz Almutairi (443101720)
Ibrahim Althanyyan  (443101693)
Abdullah Alomran    (443100868)
*/


public class Phonebook {
	LinkedListADT<Contact> lnContact;
	LinkedListADT<Event> lnEvent;
	String input2, input3, input4, input5, input6, input1;

	public Phonebook() {
		lnContact = new LinkedListADT<Contact>();
		lnEvent = new LinkedListADT<Event>();
	}

	// Menu of Chooses 1
	public static int menu(Scanner in) {
		System.out.println("\nPlease choose an option:\n" + "1. Add a contact\n" + "2. Search for a contact\n"
				+ "3. Delete a contact\n" + "4. Schedule an event\n" + "5. Print event details\n"
				+ "6. Print contacts by first name\n" + "7. Print all events alphabetically\n" + "8. Exit\n"
				+ "Enter your choice:");

		int num = in.nextInt();
		return num;
	}

	// Menu of Chooses 2
	public static void menu2() {
		System.out.println("\nEnter search criteria:\n" + "1. Name\n" + "2. Phone Number\n" + "3. Email Address\n"
				+ "4. Address\n" + "5. Birthday\n" + "Enter your choice:");
	}

	// Menu of Chooses 3
	public static void menu3() {
		System.out.println(
				"\nEnter search criteria:\n" + "1. contact name\n" + "2. Event tittle\n" + "Enter your choice:");
	}

	public void add_contact(Scanner in) {
		int count = 0;
		in.nextLine();
		do {
			count = 0;
			System.out.println("Enter the contact's name:");
			input1 = in.nextLine();
			if (input1.equals(" ") || input1.equals("")) {
				System.out.println("Wrong input!");
				count = 1;
			}
			if (lnContact.search_NAME(input1) != null) {
				System.out.println("Contact already exists\n");
				count = 1;
			}
		} while (count != 0);

		do {
			count = 0;
			System.out.println("Enter the contact's phone number:");
			input2 = in.nextLine();
			input2 = input2.replaceAll("[^0-9]", "");
			if (input2.length() != 10) {
				System.out.println("Wrong input!!");
				count = 1;
			}
			if (lnContact.search_PHONE(input2) != null) {
				System.out.println("Contact already existsn\n");
				count = 1;
			}
		} while (count != 0);

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
		boolean isValid = false;

		do {
			System.out.println("Enter the contact's birthday:");
			input5 = in.nextLine();
			isValid = isValidDate(input5);
		} while (!isValid);
		System.out.println("Enter any notes for the contact:");
		input6 = in.nextLine();
		lnContact.insert(new Contact(input1, input2, input3, input4, input5, input6));
		System.out.println("\nContact added successfully!");
	}

	private static final String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";

	public static boolean isValidDate(String input) {
		Pattern pattern = Pattern.compile(DATE_PATTERN);
		Matcher matcher = pattern.matcher(input);

		if (!matcher.matches()) {
			System.out.println("Invalid date format. Please use MM/DD/YYYY format.");
			return false;
		}

		try {
			// Validate past date and leap year (February 29)
			int year = Integer.parseInt(input.substring(6));
			int month = Integer.parseInt(input.substring(0, 2));
			int day = Integer.parseInt(input.substring(3, 5));

			if (year < 1900 || year > 9999) {
				System.out.println("Invalid year. Please enter a valid year.");
				return false;
			}

			if (month < 1 || month > 12) {
				System.out.println("Invalid month. Please enter a valid month.");
				return false;
			}

			if (day < 1 || day > getDaysInMonth(month, year)) {
				System.out.println("Invalid day. Please enter a valid day.");
				return false;
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			Date inputDate = dateFormat.parse(input); // Parse after format and logical validation

			Date currentDate = new Date();
			if (inputDate.after(currentDate)) {
				System.out.println("Invalid date. Please enter a past date.");
				return false;
			}

			return true;
		} catch (ParseException e) {
			System.out.println("Invalid date format. Please use MM/DD/YYYY format.");
			return false;
		}
	}

	private static int getDaysInMonth(int month, int year) {
		int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year) && month == 2) {
			return 29;
		}
		return daysInMonth[month];
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public void search_Contact(Scanner in) {
		int num = 0;
		;
		do {
			menu2();
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
						System.out.println("\nContact found!");
						System.out.println(c2.toString());
					}
					break;

				case 3:

					System.out.println("Enter the contact's Email Address:");
					in.nextLine();
					input3 = in.nextLine();

					if (!lnContact.search_EMAIL_PRINT(input3)) {
						System.err.println("Contact not found!");
					}

					break;

				case 4:

					System.out.println("Enter the contact's Address:");
					input4 = in.nextLine();
					input4 = in.nextLine();

					if (!lnContact.search_ADDRES_PRINT(input4)) {
						System.err.println("Contact not found!");
					}
					break;

				case 5:

					System.out.println("Enter the contact's Birthday (MM/DD/YYYY):");
					input5 = in.nextLine();
					input5 = in.nextLine();

					if (!lnContact.search_BIRTHDAY_PRINT(input5)) {
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
		} while (num > 5 || num < 1);
	}

	public void deleteContact() {
		Scanner in = new Scanner(System.in);
		System.out.println("contact name to delete");
		String inputo = in.nextLine();
		Node<Contact> c = lnContact.search_NAME(inputo);
		if (c != null) {
			lnContact.delete(c);
			System.out.println("Successfully delete");

			while (lnEvent.search_Event_name(inputo) != null)
				lnEvent.delete(lnEvent.search_Event_name(inputo));

		}

		else
			System.err.println("\nContact Not found!");

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

			String dateTimeInput = null;

			boolean isValid = false;

			do {
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
				dateTimeInput = in.nextLine();

				isValid = isValidDateTime(dateTimeInput);
			} while (!isValid);

			if (lnEvent.search_Event_name(input2) != null && lnEvent.search_Event_date(dateTimeInput) != null)
				System.out.println("There is an Event on the same time");

			else {
				System.out.println("Enter event location:");
				input3 = in.nextLine();

				lnEvent.insert((new Event(input1, dateTimeInput, input3, (Contact) lnContact.search_NAME(input2).getData())));
						
				System.out.println("\nEvent scheduled successfully!\n");
			}
		}
	}
	
	
	

	public static boolean isValidDateTime(String input) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		dateFormat.setLenient(false);

		try {
			// Validate date format
			if (!input.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")) {
				System.out.println("Invalid date and time format. Please use MM/DD/YYYY HH:MM.");
				return false;
			}

			// Extracting individual components from the input string

			int year = Integer.parseInt(input.substring(6, 10));
			int month = Integer.parseInt(input.substring(0, 2));
			int day = Integer.parseInt(input.substring(3, 5));
			int hours = Integer.parseInt(input.substring(11, 13));
			int minutes = Integer.parseInt(input.substring(14, 16));

			// Validate year
			if (year < 1900 || year > 9999) {
				System.out.println("\nInvalid year. Please enter a valid year (1900-9999).\n");
				return false;
			}

			// Validate month
			if (month < 1 || month > 12) {
				System.out.println("\nInvalid month. Please enter a valid month (1-12).\n");
				return false;
			}

			// Validate day
			if (day < 1 || day > getDaysInMonth(month, year)) {
				System.out.println("\nInvalid day. Please enter a valid day based on the selected month and year.\n");
				return false;
			}

			// Validate hours
			if (hours < 0 || hours > 23) {
				System.out.println("\nInvalid hours. Please enter a valid value between 0 and 23.\n");
				return false;
			}

			// Validate minutes
			if (minutes < 0 || minutes > 59) {
				System.out.println("\nInvalid minutes. Please enter a valid value between 0 and 59.\n");
				return false;
			}

			Date currentDate = new Date();
			Date eventDate = dateFormat.parse(input); // Parse after format and logical validation

			if (eventDate.before(currentDate)) {
				System.out.println("\nInvalid date and time. Please enter a future date and time.\n");
				return false;
			}

			return true;
		} catch (ParseException | NumberFormatException e) {
			System.out.println("Invalid date and time format. Please use MM/DD/YYYY HH:MM with valid values.");
			return false;
		}
	}

	private static int getDaysInMonth2(int month, int year) {
		int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year) && month == 2) {
			return 29;
		}
		return daysInMonth[month];
	}

	private static boolean isLeapYear2(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public void searchEvent(Scanner in) {
		menu3();
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
					c1 = (Contact) lnContact.search_NAME(input1).getData();
				} catch (Exception x) {
					System.err.println("Event not found!");
				}

				if (c1 != null) {
					lnEvent.printByName(c1.getContact_name());
				}

				break;

			case 2:

				System.out.println("Enter the event title:");
				input2 = in.nextLine();
				input2 = in.nextLine();

				Event e2 = null;
				try {
					e2 = (Event) lnEvent.search_Event_title(input2).getData();
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
		input1 = in.next();
		lnContact.printfirstName(input1);

	}

}
