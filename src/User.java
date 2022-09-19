

public class User {

	private static int lastUserID = 1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int age;
	private int userID;
	
//	User constructor
	public User(String firstName, String lastName, String email, String password, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.userID = User.lastUserID++;
	}

//	equals & hashCode methods override so we can add users to HashSet
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userID;
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

//	toString method override
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", age=" + age + ", userID=" + userID + "]";
	}

//	Getters & Setters
	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	int getUserID() {
		return userID;
	}

	void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
