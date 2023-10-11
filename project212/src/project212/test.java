package project212;

public class test {

	public static void main(String[] args) {
		LinkedListADT<Contact> l1 = new LinkedListADT<Contact>();

		Contact c1 = new Contact("Sami", "asf", "r", "er", "erq", "qe");
		Contact c2 = new Contact("Abdullah", "asf", "r", "er", "erq", "qe");
		Contact c3 = new Contact("", "asf", "r", "er", "erq", "qe");
		Contact c4 = new Contact("YasBaderser", "asf", "r", "er", "erq", "qe");

		l1.insert(c4);
		l1.insert(c2);

		l1.insert(c3);
		l1.insert(c1);

		l1.printAll();

	}

}
