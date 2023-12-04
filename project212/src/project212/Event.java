package project212;

/*
CLASS: Event
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
public class Event implements Comparable<Event> {
	private String title;
	private String date_time; 
	private String location;
	public contactBST contacts ;
	public String Type;
	public int numContacts;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Event(String title, String date_time, String location, String Type) {
		this.title = title;
		this.location = location;
		this.date_time = date_time;
		this.Type = Type;
		contacts = new contactBST();
		
	}

	public Event() {
		contacts = new contactBST();
		this.title = "";
		this.Type = "";
		this.date_time = "";
		this.location = "";
	
	}

	@Override
	public String toString() {
		System.out.println("\n\nEvent title:" + title); 
		System.out.println("\nContacts details:" ); 
		contacts.printContact(contacts.root);
		System.out.println("\nEvent date and time (MM/DD/YYYY HH:MM):" + date_time);	
		System.out.println("\nEvent location:" + location);
		System.out.println("\nEvent Type: "+Type);
		return ".";
	}

	public boolean comperDate(String date) {
		if (date_time.equalsIgnoreCase(date))
			return true;

		return false;
	}

	@Override
	public int compareTo(Event e) {
		return title.compareToIgnoreCase(e.title);

	}

	public int compareTo(String t) {
		return title.compareToIgnoreCase(t);

	}
//	 public int comparing(Event event) {
//	        if (this.title.toUpperCase().charAt(0) > event.title.toUpperCase().charAt(0))
//	            return 1;
//	        else if (this.title.toUpperCase().charAt(0) == event.title.toUpperCase().charAt(0)){
//	            int limit;
//	            if(!this.title.equalsIgnoreCase(event.title)) {
//	                limit = Math.min(this.title.length(), event.title.length());
//	                for (int i = 1; i < limit; i++) {
//	                    if (this.title.toUpperCase().charAt(i) > event.title.toUpperCase().charAt(i)) {
//	                        return 1;
//	                    } else if (this.title.toUpperCase().charAt(i) < event.title.toUpperCase().charAt(i)) {
//	                        return -1;
//	                    }
//	                }
//	                if ( this.title.length() != event.title.length())
//	                    return 2;
//	            } return 0;
//	        }else
//	            return-1;
//	    }
	

}
