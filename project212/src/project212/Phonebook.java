package project212;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.Date;
/*
CLASS: Phonebook
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
public class Phonebook {
	
	contactBST ContactTree= new contactBST();
	eventLinkedList EventList = new eventLinkedList();
	String input2, input3, input4, input5, input6, input1;
	boolean found;
	
	
	public boolean scheduleEORApp() {
        Scanner in = new Scanner(System.in) ;
        int num=0;
        String eventDateTime;
        Contact c = new Contact();
        Event e = new Event();
        String title="";
        int count=0;
        String CNames[] = {""};
        try {
        	 menu3();
              num = in.nextInt();
        	if(num==1) {
        		System.out.print("Enter Event title: ");
        		in.nextLine();
        		title = in.nextLine();
        
        		System.out.print("Enter contacts name separated by a comma: ");
        		String n = in.nextLine();
        		CNames=n.split(",");
        		
        
        	for(int i=0;i< CNames.length ;i++) {
        		 if(ContactTree.findKey(CNames[i])) {
        			 count++;
        		 }
        		}
        	}
        
        else if(num==2) {
        	System.out.print("Enter Appointment title: ");
        	in.nextLine();
            title = in.nextLine();
            System.out.print("Enter contact name: ");
            String n = in.nextLine();
            	if(ContactTree.findKey(n)) {
            		count=-1;
            	}
        }
        
        else{
        	throw new Exception();
        }
        }
        catch(Exception e2) {
        	System.err.println("only integers number from 1-2");
        }
      
        if (count==-1 || count==CNames.length){
        	
            String dateTimeInput = null;

			boolean isValid = false;
			
			do {
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
				dateTimeInput = in.nextLine();

				isValid = isValidDateTime(dateTimeInput);
			} while (!isValid);

            if( conflict (dateTimeInput)){
                System.out.println("Date and time are not available(conflict)");
                return false;
            }
            
            else {
                System.out.print("Enter event location: ");
                String Elocation = in.nextLine();
                
                
                
                if (num==1) {
                		e.Type = "Event";
                		Event EventToBeSchedule = new Event( title ,dateTimeInput , Elocation ,e.Type) ;
                		for(int i=0;i< CNames.length ;i++) {
                			
                   		 if(ContactTree.findByName(CNames[i])!=null) {
                   			c = ContactTree.retrieve();
                   			EventToBeSchedule.contacts.insert2(c);
                   			EventToBeSchedule.numContacts+=1;
                   			c.scheduledEvents.insertso(EventToBeSchedule);
        
                   		 }
                		}
                		EventList.insertso (EventToBeSchedule );
                   		System.out.println("Event scheduled successfully!");
                		return true;
                }
                else if(num==2){
                	
                		e.Type = "Appoinment";
                		c = ContactTree.retrieve();
        	
                		Event EventToBeSchedule = new Event( title ,dateTimeInput , Elocation ,e.Type) ;
                		EventToBeSchedule.contacts.insert2(c);
                		EventToBeSchedule.numContacts+=1;
                        EventList.insertso (EventToBeSchedule );
                        c.scheduledEvents.insertso(EventToBeSchedule);
        				System.out.println("Appoinment scheduled successfully!");
                        return true;
                                
                }
               
            }
		}
		System.out.println("Failed to schedule Event");
		return false;
	}
	
	private static final String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";
	private static final Exception Exception = null;

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
			if (day < 1 || day > getDaysInMonth2(month, year)) {
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
		if (isLeapYear2(year) && month == 2) {
			return 29;
		}
		return daysInMonth[month];
	}

	private static boolean isLeapYear2(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}


	
	public boolean conflict (String eventDateTime){
     Node<Event> tmp = EventList.head;
     while (tmp != null) {
        if (tmp.getData().getDate_time().equals(eventDateTime) )
            return true;
        tmp=tmp.getNext();
	 }
    return false;
 	}
	public void printByFirstName(Scanner in) {
		
	System.out.println("Enter the first name:");
	String firstname = in.nextLine();
	 firstname = in.nextLine();
	printContact_firstName(firstname, ContactTree.root);
	System.out.println("Contacts found!");
	}
	public void printContact_firstName(String fName , BSTNode node) { 
		if (node == null)
			return;
		printContact_firstName(fName , node.left);
		
		String[] fullName= ((Contact)node.data).getContact_name().split(" "); 
		String firstName= fullName[0]; 
		
		if (firstName.equals(fName)) 
			System.out.println(((Contact)node.data).toString());
		printContact_firstName(fName , node.right);
	}

	public void printEventByContactName(String contactName) {
		Contact contactToFind = ContactTree.findByName(contactName).data;
		Node<Event> temp = contactToFind.scheduledEvents.head;
		if(temp==null) {
			found =false;
					return;
		}
		while (temp != null) {
			System.out.println(temp.getData().toString());
			temp = temp.getNext();
			found =true;
		}
		
	}

	public void printEventSharingE_title(String EventTitle)  {
		Node<Event> tmpEvents = this.EventList.head;
		
		if(tmpEvents==null) {
			found =false;
			return;}
		while(tmpEvents != null) {
		
			if (tmpEvents.getData().getTitle().equalsIgnoreCase(EventTitle)) {
				System.out.println(tmpEvents.getData().toString());
				found = true;}
			tmpEvents = tmpEvents.getNext();
		}
	}
	
	
	public void searchEvent(Scanner in) {
		menu4();
		int num = 0;
		try {

			num = in.nextInt();

			switch (num) {

			case 1:

				System.out.println("Enter the contact name:");
				
				String contactName;
				in.nextLine();
				
				contactName= in.nextLine();
				found=false;
				try {
				printEventByContactName(contactName);
				
				if(found)
					System.out.println("Event found!");
				else
					System.err.println("Event not found!");
				}catch(Exception e) {}
			
			break;
			case 2:

				System.out.println("Enter the event title:");
				in.nextLine();
				String title = in.nextLine();
				found=false;
				printEventSharingE_title(title);
					if(found)
						System.out.println("Event found!");
					else
						System.err.println("Event not found!");
				
				break;

			default:
				System.out.println("Choose a number from 1-2");

			}
		} catch (Exception x) {
			System.err.println("only integers number from 1-2");
			
		}

	}
	
	
    //delete all events of specific contact from the general events linked list
    public void deleteEvents(Contact ContactToD) {
    	
    	if(ContactToD==null) {
    		return;
    	}
    	else {
    	Node<Event> nodeLestContactEvents = ContactToD.scheduledEvents.head;
    	Node<Event> nodelistEvents;
    	while (nodeLestContactEvents != null) {
			nodelistEvents = EventList.head;
			
    		while ( nodelistEvents != null) {
    			if ( nodeLestContactEvents.getData().getTitle().equals(nodelistEvents.getData().getTitle()) &&
    					nodeLestContactEvents.getData().getDate_time().equals(nodelistEvents.getData().getDate_time()) && 
    					nodeLestContactEvents.getData().getLocation().equals(nodelistEvents.getData().getLocation()) && nodelistEvents.getData().numContacts==1) {
    				if (nodelistEvents == EventList.head) {
    					EventList.head = EventList.head.getNext();
    					break;
    				}
    				else {
    					Node<Event> tmp = EventList.head;
    					while (tmp.getNext() != nodelistEvents)
    						tmp = tmp.getNext();
    					tmp.setNext(nodelistEvents.getNext());
    					nodelistEvents.setNext(null);
    				}
    				if (nodelistEvents != null) {
        				if (nodelistEvents.getNext() == null)
        					nodelistEvents = EventList.head;
        				else
        					nodelistEvents = nodelistEvents.getNext();
    				}
    				else
    					break;
				}
    			nodelistEvents = nodelistEvents.getNext();
			}
    		nodeLestContactEvents.getData().contacts.deleteC(ContactToD.getContact_name());
    		nodeLestContactEvents = nodeLestContactEvents.getNext();
		}
    }
    	
	}
    
    public void addContact(Scanner in) {
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
			if (ContactTree.findKey(input1)) {
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
			if (ContactTree.findPhoneNumber(input2, ContactTree.root)) {
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
		ContactTree.insert(new Contact(input1, input2, input3, input4, input5, input6));
		System.out.println("\nContact added successfully!");
	}
    		
    public void addtest(){  ///////////////////////////////////////////testtttttttt
    	ContactTree.insert(new Contact("Ahmad Al-Saud","1111111111","az@gg","home","11/11/2001","home"));
    	ContactTree.insert(new Contact("Ahmad Alzaid","2222222222","az@hh","beckry","11/10/2002","beckry"));
    	ContactTree.insert(new Contact("bziz ayed","3333333333","az@jj","school","11/10/2003","school"));
    	ContactTree.insert(new Contact("basl jojo","4444444444","az@kk","coffe","11/11/2004","coffe"));
    	ContactTree.insert(new Contact("Ahmad almutairi","6666666666","az@ss","beckry","11/11/2005","beckry"));
    	
    	
    }
    
    
    
    public void searchContact(Scanner in) {////////////////////////////////////////////////////
		int num = 0;
		
		do {
			menu2();
			try {
			
				num = in.nextInt();

				switch (num) {

				case 1:

					System.out.println("Enter the contact's name:");
					in.nextLine();
					input1 = in.nextLine();

						ContactTree.searchByName(input1);
					
					break;
				case 2:

					System.out.println("Enter the contact's Phone Number:");
					input2 = in.nextLine();
					input2 = in.nextLine();

					ContactTree.found=false;
					
					ContactTree.searchByPhoneNumber(input2, ContactTree.root);
						if(ContactTree.found==false)	
							System.err.println("Contact not found!");
					
					
					break;
				case 3:

					System.out.println("Enter the contact's Email Address:");
					input3 = in.nextLine();
					input3 = in.nextLine();
					
					ContactTree.found=false;
					
						ContactTree.searchByEmailAddress(input3, ContactTree.root);
						if(ContactTree.found==false)	
							System.err.println("Contact not found!");
					
					
					break;

				case 4:

					System.out.println("Enter the contact's Address:");
					input4 = in.nextLine();
					input4 = in.nextLine();
					
					ContactTree.found=false;
						ContactTree.searchByAddress(input4, ContactTree.root);
						if(ContactTree.found==false)	
							System.err.println("Contact not found!");
					break;

				case 5:

					System.out.println("Enter the contact's Birthday (MM/DD/YYYY):");
					input5 = in.nextLine();
					input5 = in.nextLine();

					ContactTree.found=false;
						ContactTree.searchByBirthday(input5, ContactTree.root);
						if(ContactTree.found==false)	
							System.err.println("Contact not found!");
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
    
    public void deleteContact(Scanner in) {
    	System.out.println("Enter the contact's name:");
    	
		String nametoD = in.nextLine();
		nametoD = in.nextLine();
		BSTNode contactToDelete = this.ContactTree.findByName( nametoD );

		this.deleteEvents(contactToDelete.data);
		
		this.ContactTree.deleteC(contactToDelete.key);
		System.out.println("Contact has been deleted successfully");
		
    	
    }
	
    public void printEventsAlphabetically() {  
        Node<Event> current = EventList.head; 
        while (current != null) { 
            System.out.println(current.getData().toString()); 
            current = current.getNext(); 
        }
    }
   
	// Menu of Chooses 1
		public static int menu(Scanner in) {
			System.out.println("\nPlease choose an option:\n" + "1. Add a contact\n" + "2. Search for a contact\n"
					+ "3. Delete a contact\n" + "4. Schedule an event/appointment\n" + "5. Print event details\n"
					+ "6. Print contacts by first name\n" + "7. Print all events alphabetically\n" + "8. Exit\n"
					+ "Enter your choice:");
			
			int numq = in.nextInt();
			return numq;
		}
		// Menu of Chooses 2
		public static void menu2() {
			System.out.println("\nEnter search criteria:\n" + "1. Name\n" + "2. Phone Number\n" + "3. Email Address\n"
					+ "4. Address\n" + "5. Birthday\n" + "Enter your choice:");
		}
		// Menu of Chooses 3
		public static void menu3() {
			 System.out.print("Enter event Type:\n "
             		+ "1. event\n "
             		+ "2. appointment\n "+
             		"Enter your choice:");
			 
		}
		public static void menu4() {
			System.out.print("Enter search criteria:\n"
             		+"1. contact name\n"
             		+ "2. Event tittle\n "+
             		"Enter your choice:");
		}
		
		
}
