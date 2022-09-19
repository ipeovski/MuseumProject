import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		GuideBook guideBook = new GuideBook();
		
		Scanner sc = new Scanner(System.in);
		boolean hasLoggedIn = false;
		User user = null;
		System.out.println("Welcome to the museum guide book!");
		System.out.println();
		
		while (true) {
			
			System.out.println("Press 0 for exit");
			System.out.println("Press 1 for log in");
			System.out.println("Press 2 for log out");
			System.out.println("Press 3 for registration");
			System.out.println("Press 4 for viewing our museums");
			System.out.println("Press 5 for buying a ticket");
			System.out.println();
			
			int input1 = sc.nextInt();
			
			switch(input1) {
			
			case 0:
				return;
				
			case 1:
				if (!hasLoggedIn) {
					System.out.println("Please enter your e-mail:");
					String email1 = sc.next();
					System.out.println("Please enter your password:");
					String password1 = sc.next();
					if (guideBook.checkUser(email1) == true && guideBook.getUser(email1).getPassword().equals(password1)) {
						user = guideBook.getUser(email1);
						System.out.println("Welcome " + user.getFirstName());
						System.out.println();
						hasLoggedIn = true;
					}
					else {
						System.out.println("Incorrect e-mail or password!");
						System.out.println();
					}
				}
				else {
					System.out.println("You are already logged in!");
					System.out.println();
				}
				break;
				
			case 2:
				if (!hasLoggedIn) {
					System.out.println("You are not logged in!");
					System.out.println();
				}
				else {
					user = null;
					hasLoggedIn = false;
					System.out.println("You logged out!");
					System.out.println();
				}
				break;
				
			case 3:
				if (!hasLoggedIn) {
					System.out.println("Please enter your first name:");
					String firstName = sc.next();
					System.out.println("Please enter your last name:");
					String lastName = sc.next();
					System.out.println("Please enter your e-mail:");
					String email = sc.next();
					System.out.println("Please enter your password:");
					String password = sc.next();
					System.out.println("Please enter your age:");
					int age = sc.nextInt();
					System.out.println();
					try {
						guideBook.addUser(firstName, lastName, email, password, age);
					} catch (UserAlreadyExistsException e) {
						System.out.println("This e-mail is already in use!");
						System.out.println();
					} catch (InvalidNameException e) {
						System.out.println("Name must be between 2 and 50 letters!");
						System.out.println();
					} catch (InvalidEmailException e) {
						System.out.println("Your e-mail is invalid!");
						System.out.println();
					} catch (InvalidPasswordException e) {
						System.out.println("Password must be between 6 and 50 symbols, must contain at least one capital and one small letter!");
						System.out.println();
					} catch (InvalidAgeException e) {
						System.out.println("Age must be between 1 and 200");
						System.out.println();
					}
					if (guideBook.checkUser(email) == true) {
						user = guideBook.getUser(email);
						System.out.println("Welcome " + user.getFirstName());
						System.out.println();
						hasLoggedIn = true;
					}
				}
				else {
					System.out.println("You are logged in!");
					System.out.println();
				}
				break;
				
			case 4:
				guideBook.showAllMuseums();
				System.out.println();
				break;
				
			case 5:
				if (!hasLoggedIn) {
					System.out.println("You are not logged in!");
					System.out.println();
				}
				else {
					MuseumType museumType = null;
					TicketType ticketType = null;
					System.out.println("Press 1 Arts Museum ticket");
					System.out.println("Press 2 History Museum ticket");
					System.out.println("Press 3 Archaeology Museum ticket");
					System.out.println();
					int input2 = sc.nextInt();
					switch (input2) {
					case 1:
						museumType = MuseumType.ARTS;
						break;
					case 2:
						museumType = MuseumType.HISTORY;
						break;
					case 3:
						museumType = MuseumType.ARCHAEOLOGY;
						break;
					default:
						System.out.println("Bad input!");
						System.out.println();
						break;
					}
					
					System.out.println("Press 1 for adult ticket");
					System.out.println("Press 2 for child ticket");
					System.out.println();
					int input3 = sc.nextInt();
					switch (input3) {
					case 1:
						ticketType = TicketType.ADULT;
						break;
					case 2:
						ticketType = TicketType.CHILD;
						break;
					default:
						System.out.println("Bad input!");
						System.out.println();
						break;
					}
					
					try {
						guideBook.getMuseum(museumType).buyTicket(ticketType);
					} catch (TicketOutOfStockException e) {
						System.out.println("Tickets are out of stock!");
						System.out.println();
					}
				}
				break;
				
			default:
				System.out.println("Bad input!");
				System.out.println();
			break;
			
			}
			
		}
	}

}
