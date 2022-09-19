
public class ArchaeologyMuseum extends Museum{
	
//	Archaeology museum constructor creates it with 1000 adult & 1000 child tickets in stock
	public ArchaeologyMuseum(String adress, String phoneNumber, int rating, String workTime, int adultTicketPrice, int childTicketPrice, MuseumType museumType) {
		super("ArchaeologyMuseum", adress, phoneNumber, rating, workTime, adultTicketPrice, childTicketPrice, museumType);
		for (int index=0; index<1000; index++) {
			Ticket ticket1 = new Ticket(TicketType.ADULT, MuseumType.ARCHAEOLOGY, adultTicketPrice);
			this.addTicket(ticket1);
			Ticket ticket2 = new Ticket(TicketType.CHILD, MuseumType.ARCHAEOLOGY, childTicketPrice);
			this.addTicket(ticket2);
		}
	}
}
