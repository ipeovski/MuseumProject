
public class Ticket {

	private TicketType ticketType;
	private MuseumType museumType;
	private int price;
	
//	Ticket constructor
	public Ticket(TicketType ticketType, MuseumType museumType, int price) {
		this.ticketType = ticketType;
		this.museumType = museumType;
		this.price = price;
	}

//	equals & hashCode methods override so we can contain tickets in HashSet
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((museumType == null) ? 0 : museumType.hashCode());
		result = prime * result + price;
		result = prime * result + ((ticketType == null) ? 0 : ticketType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (museumType != other.museumType)
			return false;
		if (price != other.price)
			return false;
		if (ticketType != other.ticketType)
			return false;
		return true;
	}

//	Getters & Setters
	TicketType getTicketType() {
		return ticketType;
	}

	void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	MuseumType getMuseumType() {
		return museumType;
	}

	void setMuseumType(MuseumType museumType) {
		this.museumType = museumType;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
