package project212;

public class LinkedListADT<T> {

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
			if (((Contact) head.getData()).compareTo((Contact) newNode.getData()) > 0) {
				newNode.setNext(head);
				head = newNode;
				return;
			}

			else {
				Node<T> r = head;
				while (r != null && (((Contact) r.getData()).compareTo((Contact) newNode.getData()) < 0)) {
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
		while (r!= null && !((Contact)r.getData()).getContact_name().equalsIgnoreCase(name)) {
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
		int count=0;
		if (head == null)
			return false;
		Node<T> r = head;
		while (r!= null) {
			if(((Contact)r.getData()).getEmail().equalsIgnoreCase(email)) {
				System.out.println("\nContact found!");
				System.out.println(r.getData().toString());
				count++;
			}
			r = r.getNext();
		}
		
		return count==0;
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
	
	
	/*
	public Node search(String name) {
		if (head == null)
			return null;
		Node r = head;
		while (r!= null && !((Contact)r.getData()).compare(name)) {
			r = r.getNext();
		}
		
		return r;

	}*/
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
	public void printAll() {
		Node<T> p = head;
		while (p != null) {
			System.out.print(p.getData().toString());
			p = p.getNext();
		}
		System.out.println("");
	}

}
