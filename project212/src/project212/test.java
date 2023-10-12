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
		 num = input.nextInt();
		switch(num) {
		case 1:
			ph.add_contact(input);
			break;
		case 2:
			ph.searchCo(input);
			break;
		case 3:
			
			break;
		case 4:
			
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
			
		}
		}while(num!=8);
		
	/*	
		Contact c1 = new Contact("Sami", "asf", "r", "er", "erq", "qe");
		Contact c2 = new Contact("Abdullah", "asf", "r", "er", "erq", "qe");
		Contact c3 = new Contact("", "asf", "r", "er", "erq", "qe");
		Contact c4 = new Contact("YasBaderser", "asf", "r", "er", "erq", "qe");
		
		l1.insert(c4);
		l1.insert(c2);

		l1.insert(c3);
		l1.insert(c1);

		l1.printAll();
	*/
		//l1.printAll();
	}

}
