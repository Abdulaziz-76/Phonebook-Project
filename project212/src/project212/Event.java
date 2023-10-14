package project212;



public class Event {
	String title;
    String time;  //
    String location;
    LinkedListADT <String> contacts_name= new LinkedListADT<String>();
    
	public Event(String title, String date_time, String location,Contact x) {
		this.title = title;
		this.location = location;
		this.contacts_name = new LinkedListADT<String>();
		contacts_name.insert(x.getContact_name());
	}
	public Event() {
		this.title = "";
		//this.date = null;
		this.time = "";
		this.location = "";
		this.contacts_name = new LinkedListADT<String>();
	}
    

}
