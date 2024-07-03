package match;

public class Ticket  
{
	public Ticket(String name, String matches, String dt, String place, String ticket) 
	{
		this.name = name;
		this.matches = matches;
		this.place = place;
		this.dt = dt;
		this.ticket = ticket;	
	}
	String name;
	String place;
	String dt;
	String matches;
	String ticket;
	public String getName() {
		return name;
	}

	public String getMatches() {
		return matches;
	}

	public String getPlace() {
		return place;
	}
	
	public String getDt()
	{
		return dt;
	}
	
	public String getTicket()
	{
		return ticket;
	}

}
