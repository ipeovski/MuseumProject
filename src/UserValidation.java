
public class UserValidation {

	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 50;
	private static final int MIN_AGE = 1;
	private static final int MAX_AGE = 200;
	private static final int MIN_PASSWORD_LENGTH = 6;
	private static final int MAX_PASSWORD_LENGTH = 50;
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	
//	Validates name
	private void confirmName(String name) throws InvalidNameException {
		if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new InvalidNameException("Name must be between " + MIN_NAME_LENGTH + " and " + MAX_NAME_LENGTH + " letters!");
		}
	}
	
//	Validates age
	private void confirmAge(int age) throws InvalidAgeException{
		if (age > MAX_AGE || age < MIN_AGE) {
			throw new InvalidAgeException("Age must be between " + MIN_AGE + " and " + MAX_AGE);
		}
	}
	
//	Validates password
	private void confirmPassword(String password) throws InvalidPasswordException {
		if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
			throw new InvalidPasswordException("Password must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " symbols!");
		}
		boolean containsNum = false;
		boolean containsSmallLetter = false;
		boolean containsCapitalLetter = false;
		for (int index = 0; index<password.length(); index++) {
			if (password.charAt(index) <= 'Z' && password.charAt(index) >= 'A') {
				containsCapitalLetter = true;
			}
			if (password.charAt(index) <= 'z' && password.charAt(index) >= 'a') {
				containsSmallLetter = true;
			}
			if (password.charAt(index) <= '9' && password.charAt(index) >= '0') {
				containsNum = true;
			}
		}
		if (!containsNum) {
			throw new InvalidPasswordException("Password must contain at least one number!");
		}
		if (!containsSmallLetter) {
			throw new InvalidPasswordException("Password must contain at least one small letter!");
		}
		if (!containsCapitalLetter) {
			throw new InvalidPasswordException("Password must contain at least one capital letter!");
		}
	}
	
//	Validates e-mail
	private void confirmEmail(String email) throws InvalidEmailException {
			if (!email.matches(EMAIL_PATTERN)) {
				throw new InvalidEmailException("Your e-mail is invalid!");
			}  
	}
	
//	Calls all validation methods
	public void confirm(User user) throws InvalidNameException, InvalidEmailException, InvalidPasswordException, InvalidAgeException {
		confirmName(user.getFirstName());
		confirmName(user.getLastName());
		confirmAge(user.getAge());
		confirmEmail(user.getEmail());
		confirmPassword(user.getPassword());
	}
	
}
