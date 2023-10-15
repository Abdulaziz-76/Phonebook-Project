package project212;

public class Event implements Comparable<Event>{
	private String title;
	private String date_time; //
	private String location;
	private Contact contact;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Event(String title, String date_time, String location, Contact x) {
		this.title = title;
		this.location = location;
		this.date_time = date_time;
		contact = x;
	}

	public Event() {
		this.title = "";

		this.date_time = "";
		this.location = "";
		contact = new Contact();
	}

	@Override
	public String toString() {
		return "Event title:" + title + "\nContact name:"+contact.getContact_name() +"\nEvent date and time (MM/DD/YYYY HH:MM):"+ date_time+"\nEvent location:"+location;
	}

	public boolean comperDate(String date) {
		if (date_time.equalsIgnoreCase(date))
			return true;

		return false;
	}

	public boolean comperName(String name) {
		if (contact.getContact_name().equalsIgnoreCase(name))
			return true;

		return false;
	}
	public int compareTo(String r) {
		return title.compareTo(title);
	}
	
	public int compareTo(Event r) {
		return 0;
	}
	

}
