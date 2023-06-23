import java.util.ArrayList;

import javax.swing.JOptionPane;

public class runLogin {

	public static void main(String[] args) {

		/*
		 * An array list is created to store every new account that is registered
		 * successfully, whilst the program runs. Creating an object of Login with
		 * default parameters as they will be updated through the register feature.
		 * Declaring all the variables required for the program to run.
		 */

		ArrayList<Login> accountList = new ArrayList<Login>();
		Login user = new Login();

		ArrayList<Task> taskList = new ArrayList<Task>();
		Task tasks = new Task();

		user = new Login("Dean", "Greeff", "Dean_", "Dean123!");
		accountList.add(user);

		user = new Login("Sydney", "Beyer", "Syd_", "Sydney123!");
		accountList.add(user);

		user = new Login("Tom", "Spence", "Tom_", "Spence123!");
		accountList.add(user);

		user = new Login("Lyle", "Hartley", "Lyle_", "Lyle123!");
		accountList.add(user);

		tasks = new Task();
		tasks.setDevName("Mike Smith");
		tasks.setTaskName("Create Login");
		tasks.setTaskHours(5);
		tasks.setTaskNumber(1);
		tasks.setTaskStatus("To Do");
		tasks.setTaskID(tasks.createTaskID());
		taskList.add(tasks);

		tasks = new Task();
		tasks.setDevName("Edward Harrison");
		tasks.setTaskName("Create Add Features");
		tasks.setTaskHours(8);
		tasks.setTaskNumber(2);
		tasks.setTaskStatus("Doing");
		tasks.setTaskID(tasks.createTaskID());
		taskList.add(tasks);

		tasks = new Task();
		tasks.setDevName("Samantha Paulson");
		tasks.setTaskName("Create Reports");
		tasks.setTaskHours(2);
		tasks.setTaskNumber(3);
		tasks.setTaskStatus("Done");
		tasks.setTaskID(tasks.createTaskID());
		taskList.add(tasks);

		tasks = new Task();
		tasks.setDevName("Glenda Oberholzer");
		tasks.setTaskName("Add Arrays");
		tasks.setTaskHours(11);
		tasks.setTaskNumber(4);
		tasks.setTaskStatus("To Do");
		tasks.setTaskID(tasks.createTaskID());
		taskList.add(tasks);

		String[] menu1 = { "Login", "Register", "Quit", "Display Accounts" };
		String[] menu2 = { "Edit Account", "EasyKanban", "Logout" };
		String[] menu3 = { "Change First Name", "Change Last Name", "Change Password", "Delete Account", "Done" };
		String[] menu4 = { "Add Task", "Show Report", "More", "Back" };
		String[] menu5 = { "Search for a Task", "Delete a Task", "Cancel" };
		String[] menu6 = { "Developer", "Task Name", "Status", "Longest Duration", "Cancel" };

		String[] statusOptions = { "To Do", "Done", "Doing" };

		String[] taskNames;
		String[] developer;

		boolean status = false;

		int index, application, mode, totalTasks, totalHours, taskNumber;

		/*
		 * This is the start of the application. This while-loop ensures the menu will
		 * always pop up after a user either registers or logs in. The menu will only
		 * close once the user selects "Exit". The 'mode' variable will be updated based
		 * on the option the user selects in the menu. A switch statement is then made
		 * use of with the 'mode' variable which will determine whether the user wants
		 * to register, login, display the existing accounts or exit. This keeps the
		 * code simple and clean, instead of using many "if" statements. Case 0 = Login
		 * feature, case 1 = Register feature, case 2 = exit, case 3 = display accounts.
		 * A try and catch is also made use of, so when the user selects "cancel" there
		 * is no error and the user is returned back to the start of the menu.
		 */
		index = 0;
		application = 0;
		boolean menu = true;

		while (menu) {

			while (application == 0) {

				mode = JOptionPane.showOptionDialog(null, "Please select what you would like to do.", "Select one:", 0,
						1, null, menu1, null);

				switch (mode) {

				case 0: // Login

					status = false;

					JOptionPane.showMessageDialog(null, "Welcome! Please login with your details.");

//                    String targetUsername = JOptionPane.showInputDialog("Please enter your username.", null);
//                    String targetPassword =  JOptionPane.showInputDialog("Please enter your password.", null);

					String targetUsername = "Dean_";
					String targetPassword = "Dean123!";

					for (Login searchArray : accountList) {

						if (user.loginUser(targetUsername, targetPassword, searchArray.getUsername(),
								searchArray.getPassword())) {
							index = accountList.indexOf(searchArray);
							status = true;
							application = 1;
							break;
						}
					}

					if (status) {
						JOptionPane.showMessageDialog(null, accountList.get(index).returnLoginStatus(status));
					} else {
						JOptionPane.showMessageDialog(null, user.returnLoginStatus(status));
					}

					break;

				case 1: // Register

					try {

						user = new Login();

						user.setFirstName(JOptionPane.showInputDialog("Enter your first name:", "Frist Name"));
						if (user.getFirstName() == null) {
							JOptionPane.showMessageDialog(null, "Canceled!", null, JOptionPane.PLAIN_MESSAGE);
							break;
						}

						user.setLastName(JOptionPane.showInputDialog("Enter your last name:", "Last Name"));
						if (user.getLastName() == null) {
							JOptionPane.showMessageDialog(null, "Canceled!", null, JOptionPane.PLAIN_MESSAGE);
							break;
						}

						user.setUsername(JOptionPane.showInputDialog("Create your username:", "Username"));

						while (!user.checkUsername()) {
							JOptionPane.showMessageDialog(null, user.registerUser(), null, JOptionPane.PLAIN_MESSAGE);
							user.setUsername(JOptionPane.showInputDialog("Create your username:", "Username"));
						}

						JOptionPane.showMessageDialog(null, "Username successfully captured.", null,
								JOptionPane.PLAIN_MESSAGE);

						user.setPassword(JOptionPane.showInputDialog("Create your password:", "Password"));

						while (!user.checkPasswordComplexity()) {
							JOptionPane.showMessageDialog(null, user.registerUser(), null, JOptionPane.PLAIN_MESSAGE);
							user.setPassword(JOptionPane.showInputDialog("Create your password:", "Password"));
						}

						JOptionPane.showMessageDialog(null, "Password successfully captured.", null,
								JOptionPane.PLAIN_MESSAGE);

						JOptionPane.showMessageDialog(null, user.registerUser(), null, JOptionPane.PLAIN_MESSAGE);

					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Canceled!", null, JOptionPane.PLAIN_MESSAGE);
						break;
					}
					accountList.add(user);
					break;

				case 2: // Quit

					application = 3;
					menu = false;
					break;

				case 3: // Display Accounts

					String displayAccounts = "Registered Accounts : \n" + "\n";

					for (Login searchArray : accountList) {
						displayAccounts = displayAccounts + searchArray.displayAccounts() + "\n";
					}

					JOptionPane.showMessageDialog(null, displayAccounts, null, JOptionPane.PLAIN_MESSAGE);
					break;

				} // End of switch statement

			} // WHILE LOOP (application == 0)

			while (application == 1) {

				mode = JOptionPane.showOptionDialog(null,
						"What would you like to do, " + accountList.get(index).getFirstName() + "?", "Select one:", 0,
						1, null, menu2, null);

				switch (mode) {

				case 0: // Edit Account

					mode = JOptionPane.showOptionDialog(null,
							"Account Details: \n\n" + accountList.get(index).displayAccounts(), "Select an option.", 0,
							1, null, menu3, null);

					switch (mode) {

					case 0: // Change First Name

						String tempFirstName = accountList.get(index).getFirstName();
						accountList.get(index)
								.setFirstName(JOptionPane.showInputDialog("Please enter your new FIRST name:", null));
						if (accountList.get(index).getFirstName() == null) {
							accountList.get(index).setFirstName(tempFirstName);
							break;
						}
						JOptionPane.showMessageDialog(null, "First name successfully updated!", null,
								JOptionPane.PLAIN_MESSAGE);
						break;

					case 1: // Change Last Name

						String tempLastName = accountList.get(index).getLastName();
						accountList.get(index)
								.setLastName(JOptionPane.showInputDialog("Please enter your new LAST name:", null));
						if (accountList.get(index).getLastName() == null) {
							accountList.get(index).setLastName(tempLastName);
							break;
						}
						JOptionPane.showMessageDialog(null, "Last name successfully updated!", null,
								JOptionPane.PLAIN_MESSAGE);
						break;

					case 2: // Change Password

						String tempPassword = accountList.get(index).getPassword();
						try {
							accountList.get(index)
									.setPassword(JOptionPane.showInputDialog("Please enter your new PASSWORD:", null));

							while (!accountList.get(index).checkPasswordComplexity()) {
								JOptionPane.showMessageDialog(null, accountList.get(index).registerUser(), null,
										JOptionPane.PLAIN_MESSAGE);
								accountList.get(index).setPassword(
										JOptionPane.showInputDialog("Please enter your new PASSWORD:", null));
							}

							JOptionPane.showMessageDialog(null, "Password successfully updated!", null,
									JOptionPane.PLAIN_MESSAGE);
							break;

						} catch (NullPointerException e) {
							if (accountList.get(index).getPassword() == null) {
								accountList.get(index).setPassword(tempPassword);
							}
							break;
						}
					case 3: // Delete Account

						if (JOptionPane.showConfirmDialog(null, "ARE YOU SURE?") == 0) {

							accountList.remove(index);
							JOptionPane.showMessageDialog(null, "Your account has been deleted!", null,
									JOptionPane.PLAIN_MESSAGE);
							status = false;
							application = 0;
						}
						break;

					case 4: // Done
						break;
					}
					break;

				case 1: // EasyKanban

					application = 2;
					break;

				case 2: // Logout

					status = false;
					application = 0;
					break;

				}

			} // WHILE LOOP (application == 1)

			if (application == 2) {
				JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
			}

			String displayTasks = "Task List";
			totalHours = 0;

			while (application == 2) {

				mode = JOptionPane.showOptionDialog(null, "Please select an option.", "Select one:", 0, 1, null, menu4,
						null);

				switch (mode) {

				case 0: // Add Task

					taskNumber = taskList.get(taskList.size() - 1).getTaskNumber() + 1;
					totalTasks = 0;

					try {
						// Number of tasks
						totalTasks = Integer.parseInt(
								JOptionPane.showInputDialog("Please enter the number of tasks you would like to add:"));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You need to enter a number. \nPlease try again!");
						break;
					}
					displayTasks = "Captured Tasks: \n";

					for (int i = 0; i < totalTasks; i++) {

						tasks = new Task();

						// Task Name
						tasks.setTaskName(JOptionPane.showInputDialog("Please enter the name of the task:", null));
						if (tasks.getTaskName() == null) {
							break;
						}

						// Task Number
						tasks.setTaskNumber(taskNumber);

						// Task Description + check if description is valid
						tasks.setTaskDesc(JOptionPane.showInputDialog("Enter a brief description of this task:", null));
						if (tasks.getTaskDesc() == null) {
							break;
						}

						while (!tasks.checkTaskDescription()) {
							JOptionPane.showMessageDialog(null,
									"Please enter a task description of less than 50 characters");
							tasks.setTaskDesc(JOptionPane.showInputDialog("Enter a brief description of this task:"));
						}

						// Developers Name
						tasks.setDevName(JOptionPane.showInputDialog("Enter the developer's name:", null));
						if (tasks.getDevName() == null) {
							break;
						}

						// Task Duration
						try {
							tasks.setTaskHours(Integer.parseInt(
									JOptionPane.showInputDialog("Please enter the duration of the task (Hours):")));
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "You need to enter a number. \nPlease try again!");
							break;
						}

						// Task ID + createTaskID
						try {
							tasks.setTaskID(tasks.createTaskID());
						} catch (StringIndexOutOfBoundsException e) {
							JOptionPane.showMessageDialog(null,
									"The task name must be atleast 2 characters,\nand the developer's name atleast 3 characters. \n"
											+ "Please try again!");
							break;
						}

						// Task Status
						tasks.setTaskStatus((String) JOptionPane.showInputDialog(null,
								"Please select the status of the task", "Select One", JOptionPane.QUESTION_MESSAGE,
								null, statusOptions, statusOptions[0]));
						if (tasks.getTaskStatus() == null) {
							break;
						}

						// End of for loop and successful task added.
						JOptionPane.showMessageDialog(null, "Task successfully captured");
						taskList.add(tasks);
						taskNumber++;
					}

					totalHours = tasks.returnTotalHours(taskList);

					for (Task searchArray : taskList) {
						displayTasks = displayTasks + "\n" + searchArray.printTaskDetails() + "\n";
					}

					JOptionPane.showMessageDialog(null, displayTasks + "\nTotal Hours = " + totalHours + " Hours");
					break;

				case 1: // Show Report

					displayTasks = "Captured Tasks: \n";
					totalHours = tasks.returnTotalHours(taskList);

					for (Task searchArray : taskList) {

						displayTasks = displayTasks + "\n" + searchArray.printTaskDetails() + "\n";

					}
					JOptionPane.showMessageDialog(null, displayTasks + "\nTotal Hours = " + totalHours + " Hours");
					break;

				case 2: // More

					mode = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select one:", 0, 1, null,
							menu5, null);

					switch (mode) {

					case 0: // Search for Task

						mode = JOptionPane.showOptionDialog(null, "Search for a task by:", "Select one:", 0, 1, null,
								menu6, null);

						switch (mode) {

						case 0: // Developer

							developer = new String[taskList.size()];

							for (int i = 0; i < taskList.size(); i++) {

								developer[i] = taskList.get(i).getDevName();
							}

							String searchDev = (String) JOptionPane.showInputDialog(null,
									"Please enter the Developer's name:", "Select One", JOptionPane.QUESTION_MESSAGE,
									null, developer, developer[0]);

							if (searchDev == null) {
								break;
							}

							displayTasks = "Developer Name: " + searchDev + "\n";

							for (Task searchArray : taskList) {
								if (searchArray.getDevName().equals(searchDev)) {
									displayTasks = displayTasks + "\nTask Name: " + searchArray.getTaskName()
											+ "\nTask Status: " + searchArray.getTaskStatus() + "\n";
								}
							}

							JOptionPane.showMessageDialog(null, displayTasks);
							break;

						case 1: // Task Name

							taskNames = new String[taskList.size()];

							for (int i = 0; i < taskList.size(); i++) {

								taskNames[i] = taskList.get(i).getTaskName();
							}

							String searchTask = (String) JOptionPane.showInputDialog(null,
									"Please select the task name to be deleted:", "Select One",
									JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

							if (searchTask == null) {
								break;
							}

							displayTasks = "Task Name: " + searchTask + "\n";

							for (Task searchArray : taskList) {
								if (searchArray.getTaskName().equals(searchTask)) {
									displayTasks = displayTasks + "\nDeveloper: " + searchArray.getDevName()
											+ "\nTask Status: " + searchArray.getTaskStatus() + "\n";
								}
							}

							JOptionPane.showMessageDialog(null, displayTasks);
							break;

						case 2: // Status

							String searchStatus = (String) JOptionPane.showInputDialog(null,
									"Please select the status of the task", "Select One", JOptionPane.QUESTION_MESSAGE,
									null, statusOptions, statusOptions[0]);

							if (searchStatus == null) {
								break;
							}

							displayTasks = "Tasks with the status: " + searchStatus + "\n";

							for (Task searchArray : taskList) {
								if (searchArray.getTaskStatus().equals(searchStatus)) {
									displayTasks = displayTasks + "\nDeveloper: " + searchArray.getDevName()
											+ "\nTask Name: " + searchArray.getTaskName() + "\nTask Duration: "
											+ searchArray.getTaskHours() + "\n";
								}
							}

							JOptionPane.showMessageDialog(null, displayTasks);
							break;

						case 3: // Longest Duration

							int highestHours = 0;
							int tempIndex = 0;

							displayTasks = "Task with the longest duration: " + "\n";

							for (int i = 0; i < taskList.size(); i++) {
								if (taskList.get(i).getTaskHours() > highestHours) {
									highestHours = taskList.get(i).getTaskHours();
									tempIndex = i;
								}
							}

							displayTasks = displayTasks + "\nDeveloper: " + taskList.get(tempIndex).getDevName()
									+ "\nTask Name: " + taskList.get(tempIndex).getTaskName() + "\nTask Duration: "
									+ taskList.get(tempIndex).getTaskHours();
							JOptionPane.showMessageDialog(null, displayTasks);
							break;

						case 4: // Cancel
							break;

						}
						break;

					case 1: // Delete a Task

						taskNames = new String[taskList.size()];

						for (int i = 0; i < taskList.size(); i++) {

							taskNames[i] = taskList.get(i).getTaskName();
						}
						String searchTask = (String) JOptionPane.showInputDialog(null,
								"Please select the task name to be deleted:", "Select One",
								JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

						if (searchTask == null) {
							break;
						}

						for (int i = taskList.size() - 1; i >= 0; i--) {

							if (taskList.get(i).getTaskName().equals(searchTask)) {
								taskList.remove(i);
							}
						}

						JOptionPane.showMessageDialog(null, "Entry '" + searchTask + "' successfully deleted!");
						break;

					case 2: // Cancel
						break;
					}
					break;

				case 3: // Back

					application = 1;
					break;

				}

			} // WHILE LOOP (application == 2)

		} // WHILE LOOP (menu == 0)

	} // MAIN

} // CLASS
