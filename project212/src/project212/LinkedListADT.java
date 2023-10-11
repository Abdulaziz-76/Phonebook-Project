package project212;

public class LinkedListADT<T>  {

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

	public void printAll() {
		Node<T> p = head;
		while (p != null) {
			System.out.print(p.getData().toString() + "    ");
			p = p.getNext();
		}
		System.out.println("");
	}

	
}
	


