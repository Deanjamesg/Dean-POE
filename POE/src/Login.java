
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

	public boolean checkUsername() {

		boolean result = false;

		if (username.contains("_") && username.length() <= 5) {
			result = true;
		}

		return result;

	}

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

	public boolean loginUser(String targetUsername, String targetPassword, String regUsername, String regPassword) {

		if (targetUsername.equals(regUsername) && targetPassword.equals(regPassword)) {

			return true;
		}

		return false;
	}

	public String returnLoginStatus(boolean status) {

		String loginMessage = "";

		if (status) {
			loginMessage = "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
		} else {
			loginMessage = "Username or password incorrect, please try again.";
		}

		return loginMessage;

	}

	public String displayAccounts() {

		String displayAccount = "Frist name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Username: "
				+ username + "\n" + "Password: " + password + "\n";

		return displayAccount;

	}
}
