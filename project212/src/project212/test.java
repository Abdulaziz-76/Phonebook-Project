package project212;

import java.util.Scanner;
/*
CLASS: Test
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

public class test {

	public static void main(String[] args) {
		int choice = 0;// number of choice
		Scanner input = new Scanner(System.in);
		Phonebook ph = new Phonebook();
		System.out.println("Welcome to the Linked Tree Phonebook!");
		do {

			try {
				choice = ph.menu(input);

				switch (choice) {
				case 1:
					ph.add_contact(input);
					break;
				case 2:
					ph.search_Contact(input);
					break;
				case 3:
					ph.deleteContact();

					break;
				case 4:
					ph.Schedule(input);

					break;
				case 5:
					ph.searchEvent(input);

					break;
				case 6:
					ph.printBy_firstName(input);
					break;
				case 7:
					ph.lnEvent.printAll();
					break;
				case 8:
					System.out.println("Goodbye!");
					break;

				default:
					System.out.println("Choose a number from 1-8");
				}
			} catch (Exception x) {
				System.err.println("only integers number from 1-8");
				input.nextLine();
			}
		} while (choice != 8);

	}
}

