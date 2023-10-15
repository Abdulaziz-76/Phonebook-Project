package project212;

import java.util.Scanner;

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

	public boolean empty() {
		return head == null;
	}
	
	
	
	
	

	public void insert(T d) {
		Node<T> newNode = new Node<T>(d);
		if (head == null)
			head = newNode;

		else {
			if (( head.getData()).compareTo( newNode.getData()) > 0) {
				newNode.setNext(head);
				head = newNode;
				return;
			}

			else {
				Node<T> r = head;
				while (r != null && (( r.getData()).compareTo( newNode.getData()) < 0)) {
					current = r;
					r = r.getNext();
				}

				newNode.setNext(current.getNext());
				current.setNext(newNode);

			}

		}

	}
	
	
	
	
	
	
	
	public Node<T> search_NAME(String name) {
		if (head == null)
			return null;
		Node<T> r = head;
		while (r!= null && ((Contact)r.getData()).getContact_name().compareTo(name)!=0) {
			current=r;
			r = r.getNext();
		}
		
		return r;
	}
	
	public Node<T> search_PHONE(String number) {
		if (head == null)
			return null;
		Node<T> r = head;
		while (r!= null && !((Contact)r.getData()).getPhone_number().equalsIgnoreCase(number)) {
			current=r;
			r = r.getNext();
		}
		
		return r;
	}
	public boolean search_EMAIL(String email) {
		
		if (head == null)
			return false;
		Node<T> r = head;
		while (r!= null) {
			if(((Contact)r.getData()).getEmail().equalsIgnoreCase(email)) {
				System.out.println("\nContact found!");
				System.out.println(r.getData().toString());
				
			}
			r = r.getNext();
		}
		
		return r==null;
	}
	
	public boolean search_ADDRES(String addres) {
		int count=0;
		if (head == null)
			return false;
		Node<T> r = head;
		while (r!= null) {
			if(((Contact)r.getData()).getAddress().equalsIgnoreCase(addres)) {
				System.out.println("\nContact found!");
				System.out.println(r.getData().toString());
				count++;
			}
			r = r.getNext();
		}
		
		return count==0;
	}
	public boolean search_BIRTHDAY(String BTH) {
		int count=0;
		if (head == null)
			return false;
		Node<T> r = head;
		while (r!= null) {
			if(((Contact)r.getData()).getBirthday().equalsIgnoreCase(BTH)) {
				System.out.println("\nContact found!");
				System.out.println(r.getData().toString());
				count++;
			}
			r = r.getNext();
		}
		
		return count==0;
	}
	
	public Node<T> search_Event_name(String name) {
		if(head==null)
			return null;
		Node<T> r = head;
			while(r!=null&&!(((Event)r.getData()).comperName(name))) {
				current=r;
			r = r.getNext();
			}
		return r;
	}
	
	public Node<T> search_Event_date(String date) {
		if(head==null)
			return null;
		Node<T> r = head;
			while(r!=null&&!(((Event)r.getData()).comperDate(date))) {
				current=r;
			r = r.getNext();
			}
		return r;
	}
	
	public Node<T> search_Event_title(String title) {
		if(head==null)
			return null;
		Node<T> r = head;
			while(r!=null&&!(((Event)r.getData()).getTitle().equalsIgnoreCase(title))) {
				current=r;
			r = r.getNext();
			}
		return r;
	}
	
	
	
	
	public boolean delete(String name) {
		Node<T> r =search_NAME(name);
		if(r==head) {
			head=null;
			return true;
		}
		if(r!=null) {
			current.setNext(r.getNext());
			r.setNext(null);
			return true;
		}
		return false;
	
	}
	public void printByName(String name) {
		
		if (head == null)
			System.out.println("There's no Event to this Contact");
		Node<T> r = head;
		while (r!= null) {
			if(((Event)r.getData()).comperName(name)) {
				System.out.println("\nEvent found!");
				System.out.println(r.getData().toString());
			}
				r = r.getNext();
			}
			
		}
	
	public void printByTitle(String title) {
		
		if (head == null)
			System.out.println("There's no Event to this Contact");
		Node<T> r = head;
		while (r!= null) {
			if(((Event)r.getData()).getTitle().equalsIgnoreCase(title)) {
				
				System.out.println("\nEvent found!");
				System.out.println(r.getData().toString());
			}
				r = r.getNext();
			}
		
		
	}
		
		
	
	public void printAll() {
		Node<T> r = head;
		while (r != null) {
			System.out.print(r.getData().toString());
			r = r.getNext();
		}
		System.out.println("");
	}
	
	public void printfirstName(String name) {
		if (head == null)
			System.out.println("There's no Contact have this name");
		Node<T> r = head;
		while (r!= null) {
				int x=0;
				String n="";
				String s=((Contact)r.getData()).getContact_name();
			
				while(x<=s.length()-1 &&s.charAt(x)!=' ') {
					n+=s.charAt(x++);
				
				if(n.equalsIgnoreCase(name)) {
				System.out.println("\nEvent found!");
				System.out.println(r.getData().toString());
				
				
				}
				
				}
				r = r.getNext();
		}
	}
	
}



