
public class Login {
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public Login() {

	}

	public Login(String firstName, String lastName, String username, String password) {

		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	// Creating all the setters

	public void setUsername(String username) {

		this.username = username;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	// Creating all the getters

	public String getUsername() {

		return username;

	}

	public String getPassword() {

		return password;

	}

	public String getFirstName() {

		return firstName;

	}

	public String getLastName() {

		return lastName;

	}

	/*
	 * checkUsername, checks if the username parsed from the main, meets the
	 * requirements, such as containing an "_" or having a length that is less than
	 * or equal to 5 and returns a boolean.
	 */
	public boolean checkUsername() {

		boolean result = false;

		if (username.contains("_") && username.length() <= 5) {
			result = true;
		}

		return result;

	}

	/*
	 * checkPasswordComplexity, checks if all the requirements for a password is
	 * met, specified in the POE. It iterates through the entire String, parsed from
	 * the main, and checks each character if is a; capital letter, number or a
	 * special character. If all these conditions are true, it returns true. If not
	 * then it returns false.
	 */
	public boolean checkPasswordComplexity() {

		boolean caps = false;
		boolean number = false;
		boolean special = false;
		boolean check = false;

		if (password.length() >= 8) {

			for (int i = 0; i < password.length(); i++) {

				if (Character.isUpperCase(password.charAt(i))) {
					caps = true;
				}
				if (Character.isDigit(password.charAt(i))) {
					number = true;
				}
				if (!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))
						&& !Character.isWhitespace(password.charAt(i))) {
					special = true;
				}

			}
		}

		if (caps && number && special) {
			check = true;
		}

		return check;
	}

	/*
	 * registerUser methods is only supposed to return the correct message as a
	 * string. A switch statement is created and returns the correct message based
	 * on what the String, parsed from the main is, and returns a String.
	 */
	public String registerUser() {

		String response;

		if (!checkUsername()) {
			response = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
			return response;

		} else if (!checkPasswordComplexity()) {
			response = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";

		} else {
			response = "User has been registered successfully!";
		}

		return response;

	}

	/*
	 * loginUser, compares 2 pairs of Strings. It compares the login details (user
	 * input from the login feature in the main) to any account iterated through in
	 * the main via a for-loop. It compares the username to a username, and the
	 * password to a password. It returns true if both conditions are met, else it
	 * returns false.
	 */
	public boolean loginUser(String targetUsername, String targetPassword, String regUsername, String regPassword) {

		if (targetUsername.equals(regUsername) && targetPassword.equals(regPassword)) {

			return true;
		}

		return false;
	}

	/*
	 * returnLoginStatus, takes in 3 arguments. A boolean and 2 Strings. If the
	 * boolean is true, the variable "temp" will be set to 1 or else it will remain
	 * 0. This allows the switch statement to determien whether the login was
	 * successful or not and return the appropriate String.
	 */
	public String returnLoginStatus(boolean status) {

		String loginMessage = "";

		if (status) {
			loginMessage = "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
		} else {
			loginMessage = "Username or password incorrect, please try again.";
		}

		return loginMessage;

	}

	/*
	 * This is a method I created to see if registered accounts are being stored
	 * correctly in the array list. I thought I would keep it, as it is a nice
	 * feature to have until a forgot username or password feature is created.
	 */
	public String displayAccounts() {

		String displayAccount = "Frist name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Username: "
				+ username + "\n" + "Password: " + password + "\n";

		return displayAccount;

	}
}
