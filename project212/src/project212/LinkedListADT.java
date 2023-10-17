package project212;

import java.util.Scanner;
/*
CLASS: LinkedListADT
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


public class LinkedListADT<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> current;
	private int size;

	public LinkedListADT() {
		size = 0;
		head = current = null;

	}

	public boolean last() {
		return current.getNext() == null;
	}

	public boolean isempty() {
		return head == null;

	}

	public void insert(T val) {
		Node<T> newNode = new Node<T>(val);
		if (isempty())
			head = newNode;

		else {
			if ((head.getData()).compareTo(newNode.getData()) > 0) {
				newNode.setNext(head);
				head = newNode;
				return;
			}

			else {
				Node<T> temp = head;
				while (temp != null && ((temp.getData()).compareTo(newNode.getData()) < 0)) {
					current = temp;
					temp = temp.getNext();
				}

				newNode.setNext(current.getNext());
				current.setNext(newNode);

			}

		}

	}

	public Node<T> search_NAME(String name) {
		if (isempty())
			return null;
		Node<T> temp = head;
		while (temp != null && ((Contact) temp.getData()).getContact_name().compareTo(name) != 0) {
			current = temp;
			temp = temp.getNext();
		}

		return temp;
	}

	public Node<T> search_PHONE(String number) {
		if (isempty())
			return null;
		Node<T> temp = head;
		while (temp != null && !((Contact) temp.getData()).getPhone_number().equalsIgnoreCase(number)) {
			current = temp;
			temp = temp.getNext();
		}

		return temp;
	}

	public boolean search_EMAIL_PRINT(String email) {

		if (isempty())
			return false;
		Node<T> temp = head;
		while (temp != null) {
			if (((Contact) temp.getData()).getEmail().equalsIgnoreCase(email)) {
				System.out.println("\nContact found!");
				System.out.println(temp.getData().toString());

			}
			temp = temp.getNext();
		}

		return temp == null;
	}

	public boolean search_ADDRES_PRINT(String addres) {
		int count = 0;
		if (isempty())
			return false;
		Node<T> temp = head;
		while (temp != null) {
			if (((Contact) temp.getData()).getAddress().equalsIgnoreCase(addres)) {
				System.out.println("\nContact found!");
				System.out.println(temp.getData().toString());
				count++;
			}
			temp = temp.getNext();
		}

		return count != 0;
	}

	public boolean search_BIRTHDAY_PRINT(String BTH) {
		int count = 0;
		if (isempty())
			return false;
		Node<T> temp = head;
		while (temp != null) {
			if (((Contact) temp.getData()).getBirthday().equalsIgnoreCase(BTH)) {
				System.out.println("\nContact found!");
				System.out.println(temp.getData().toString());
				count++;
			}
			temp = temp.getNext();
		}

		return count != 0;
	}

	public Node<T> search_Event_name(String name) {
		if (isempty())
			return null;
		Node<T> temp = head;
		while (temp != null && !(((Event) temp.getData()).comperName(name))) {
			current = temp;
			temp = temp.getNext();
		}
		return temp;
	}

	public Node<T> search_Event_date(String date) {
		if (isempty())
			return null;
		Node<T> temp = head;
		while (temp != null && !(((Event) temp.getData()).comperDate(date))) {
			current = temp;
			temp = temp.getNext();
		}
		return temp;
	}

	public Node<T> search_Event_title(String title) {
		if (isempty())
			return null;
		Node<T> temp = head;
		while (temp != null && !(((Event) temp.getData()).getTitle().equalsIgnoreCase(title))) {
			current = temp;
			temp = temp.getNext();
		}
		return temp;
	}

	public boolean delete(Node n) {

		if (n == head) {
			head = head.getNext();
			return true;
		}
		if (n != null) {
			current.setNext(n.getNext());
			n.setNext(null);
			return true;
		}
		return false;

	}

	public void printByName(String name) {

		if (isempty())
			System.out.println("There's no Event to this Contact");
		Node<T> temp = head;
		while (temp != null) {
			if (((Event) temp.getData()).comperName(name)) {
				System.out.println("\nEvent found!");
				System.out.println(temp.getData().toString());
			}
			temp = temp.getNext();
		}

	}

	public void printByTitle(String title) {

		if (isempty())
			System.out.println("There's no Event to this Contact");
		Node<T> temp = head;
		while (temp != null) {
			if (((Event) temp.getData()).getTitle().equalsIgnoreCase(title)) {

				System.out.println("\nEvent found!");
				System.out.println(temp.getData().toString());
			}
			temp = temp.getNext();
		}

	}

	public void printAll() {
		Node<T> r = head;
		if (r == null)
			System.out.println("There's no event");

		while (r != null) {
			System.out.print(r.getData().toString());
			r = r.getNext();
		}
		System.out.println("");
	}

	public void printfirstName(String name) {
		if (isempty())
			System.out.println("There's no Contact have this name");
		Node<T> temp = head;
		while (temp != null) {
			int x = 0;
			String n = "";
			String s = ((Contact) temp.getData()).getContact_name();

			while (x <= s.length() - 1 && s.charAt(x) != ' ') {
				n += s.charAt(x++);

				if (n.equalsIgnoreCase(name)) {
					System.out.println("\nEvent found!");
					System.out.println(temp.getData().toString());

				}

			}
			temp = temp.getNext();
		}
	}

}

