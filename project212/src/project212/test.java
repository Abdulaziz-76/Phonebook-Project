package project212;

import java.util.Scanner;

public class test {
	
	
	public static void main(String[] args) {
		int num=0;//number of choice
		Scanner input = new Scanner(System.in);
		Phonebook ph = new Phonebook();
		System.out.println("Welcome to the Linked Tree Phonebook!");
		
		do {
		System.out.println("Please choose an option:"); 
		System.out.println("1. Add a contact");
		System.out.println("2. Search for a contact");
		System.out.println("3. Delete a contact");
		System.out.println("4. Schedule an event");
		System.out.println("5. Print event details");
		System.out.println("6. Print contacts by first name");
		System.out.println("7. Print all events alphabetically");
		System.out.println("8. Exit");
		System.out.println("Enter your choice:");
		
		try {
		 num = input.nextInt();
		
		
		switch(num) {
		case 1:
			ph.add_contact(input);
			break;
		case 2:
			ph.searchCo(input);
			break;
		case 3:
			ph.deleteContact();
			
			break;
		case 4:
			ph.Schedule(input);
		
			break;
		case 5:
			
			
			break;
		case 6:
			ph.ln.printAll();
			break;
		case 7:
			
			break;
		case 8:
			
			break;
			
		default:
			System.out.println("Choose a number from 1-8");
		}
		}catch(Exception x) {
			System.err.println("only integers number from 1-8");
			 input.nextLine();
		}
		}while(num!=8);
		
	}
}
	

