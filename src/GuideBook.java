import java.util.HashMap;
import java.util.TreeSet;

public class GuideBook {

	private TreeSet<Museum> museums;
	private HashMap<String, User> users;
	
//	Guide book constructor creates it with one Arts museum, one History museum & one Archaeology museum.
//	Museums are stored in TreeSet compared by adult ticket price.
	public GuideBook() {
		this.users = new HashMap<String, User>();
		this.museums = new TreeSet<Museum>( (museum1, museum2) -> museum1.getAdultTicketsPrice() - museum2.getAdultTicketsPrice());
		this.museums.add(new HistoryMuseum("museum street", "0888454545", 4, "9:00 - 18:00", 10, 5, MuseumType.HISTORY));
		this.museums.add(new ArtsMuseum("arts street", "0887837839", 3, "9:00 - 18:00", 8, 4, MuseumType.ARTS));
		this.museums.add(new ArchaeologyMuseum("interesting street", "0885398548", 5, "9:00 - 18:00", 12, 6, MuseumType.ARCHAEOLOGY));
	}
	
//	Shows all museums in teh console
	public void showAllMuseums() {
		this.museums.forEach(museum -> System.out.println(museum));
	}
	
//	adds user if names, password, age, e-mail are confirmed
	public void addUser(String firstName, String lastName, String email, String password, int age)
			throws UserAlreadyExistsException, InvalidNameException, InvalidEmailException, InvalidPasswordException, InvalidAgeException {
		if (this.users.containsKey(email)) {
			throw new UserAlreadyExistsException("This e-mail is already in use!");
		}
			User user = new User(firstName, lastName, email, password, age);
			UserValidation validation = new UserValidation();
			validation.confirm(user);
			this.users.put(email, user);
	}

//	Checks if a user with this e-mail is already registered
	public boolean checkUser(String email1) {
		return this.users.containsKey(email1);
	}

//	returns a user by passed e-mail
	public User getUser(String email1) {
		return this.users.get(email1);
	}

	public Museum getMuseum(MuseumType museumType) {
		for (Museum m : this.museums) {
			if (m.getMuseumType().equals(museumType))
				return m;
		}
		return null;
	}
}
