import java.util.HashMap;
import java.util.HashSet;

public abstract class Museum {

	private String name;
	private String adress;
	private String phoneNumber;
	private int rating;
	private String workTime;
	private int adultTicketsPrice;
	private int childTicketsPrice;
	private int adultTicketsSold;
	private int childTicketsSold;
	private MuseumType museumType;
	private HashMap<TicketType, HashSet<Ticket>> tickets;
	
//	Museum constructor
	public Museum(String name, String adress, String phoneNumber, int rating, String workTime, int adultTicketPrice, int childTicketPrice, MuseumType museumType) {
		this.name = name;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.workTime = workTime;
		this.adultTicketsPrice = adultTicketPrice;
		this.childTicketsPrice =childTicketPrice;
		this.adultTicketsSold = 0;
		this.childTicketsSold = 0;
		this.museumType = museumType;
		this.tickets = new HashMap<TicketType, HashSet<Ticket>>();
		this.tickets.put(TicketType.ADULT, new HashSet<Ticket>());
		this.tickets.put(TicketType.CHILD, new HashSet<Ticket>());
	}
	
//	Adds ticket to the museum ticket collection
	public void addTicket(Ticket ticket1) {
		this.tickets.get(ticket1.getTicketType()).add(ticket1);
	}
	
//	Users can buy tickets
	public void buyTicket(TicketType ticketType) throws TicketOutOfStockException {
		if (this.tickets.get(ticketType).isEmpty()) {
			throw new TicketOutOfStockException("Tickets are out of stock!");
		}
			System.out.println("You bought the ticket!");
			System.out.println();
			if (ticketType.equals(TicketType.ADULT)) {
				this.adultTicketsSold++;
			}
			else {
				this.childTicketsSold++;
			}
	}

//	toString method override
	@Override
	public String toString() {
		return "Museum [name=" + name + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", rating=" + rating
				+ ", workTime=" + workTime + ", adultTicketsPrice=" + adultTicketsPrice + ", childTicketsPrice="
				+ childTicketsPrice + ", adultTicketsSold=" + adultTicketsSold + ", childTicketsSold="
				+ childTicketsSold + "]";
	}

//	Getters & Setters
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getAdress() {
		return adress;
	}

	void setAdress(String adress) {
		this.adress = adress;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	int getRating() {
		return rating;
	}

	void setRating(int rating) {
		this.rating = rating;
	}

	String getWorkTime() {
		return workTime;
	}

	void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	int getAdultTicketsSold() {
		return adultTicketsSold;
	}

	void setAdultTicketsSold(int adultTicketsSold) {
		this.adultTicketsSold = adultTicketsSold;
	}

	int getChildTicketsSold() {
		return childTicketsSold;
	}

	void setChildTicketsSold(int childTicketsSold) {
		this.childTicketsSold = childTicketsSold;
	}
	
	int getAdultTicketsPrice() {
		return adultTicketsPrice;
	}

	void setAdultTicketsPrice(int adultTicketsPrice) {
		this.adultTicketsPrice = adultTicketsPrice;
	}

	int getChildTicketsPrice() {
		return childTicketsPrice;
	}

	void setChildTicketsPrice(int childTicketsPrice) {
		this.childTicketsPrice = childTicketsPrice;
	}

	MuseumType getMuseumType() {
		return museumType;
	}

	void setMuseumType(MuseumType museumType) {
		this.museumType = museumType;
	}
}
