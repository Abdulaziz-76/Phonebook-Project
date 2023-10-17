package project212;
/*
CLASS: Node
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
public class Node<T> {
	private T data;
	private Node<T> next;

	public Node() {

	}

	public Node(T d) {
		this.data = d;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
