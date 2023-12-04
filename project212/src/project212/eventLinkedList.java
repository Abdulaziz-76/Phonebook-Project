package project212;

/*
CLASS: eventLinkedList
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
public class eventLinkedList {
    Node<Event> head;

    Node<Event> current;

    public eventLinkedList() {
        head=current = null;
       
    }
    
	public void insertso(Event val) {
        Node<Event> newNode = new Node<Event>(val);
        if (isempty())
            head = newNode;

        else {
            if ((head.getData()).compareTo(newNode.getData()) > 0) {
                newNode.setNext(head);
                head = newNode;
                return;
            }

            else {
                Node<Event> priv = head;
                current = head;
                while (current != null && ((current.getData()).compareTo(newNode.getData()) < 0)) {
                    priv = current;
                    current = current.getNext();
                }

                newNode.setNext(current);
                priv.setNext(newNode);

            }

        }

    }
    
    public void  printAll() {
		Node<Event> r = head;
		if (r == null)
			System.out.println("There's no event");

		while (r != null) {
			System.out.print(r.getData().toString());
			r = r.getNext();
		}
		System.out.println("");
	}
    public boolean last() {
		return current.getNext() == null;
	}
    public boolean isempty() {
		return head == null;

	}
    public void FindFirst(){
        if (head != null)
            current = head;
        else 
            return;
        }
    

}


