import java.util.ArrayList;
import javax.swing.JOptionPane;

public class runLogin {

	public static void main(String[] args) {

		/*
		 * Creating two array lists of type, "Login" and "Task", to store every new
		 * account that is registered successfully and every task that is added
		 * correctly. A few accounts were created and added to the array list <Login>
		 * and a few tasks were created and added to the array list <Task>. These
		 * accounts and tasks were added as test data.
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

		/**
		 * Declaring and initializing these String arrays, which will be used in the
		 * JOptionPane menu. When an option is selected, depending on the selection of
		 * the user, the function will return an integer which will then be passed to a
		 * switch case to perform the desired operation.
		 */

		String[] menu1 = { "Login", "Register", "Quit", "Display Accounts" };
		String[] menu2 = { "Edit Account", "EasyKanban", "Logout" };
		String[] menu3 = { "Change First Name", "Change Last Name", "Change Password", "Delete Account", "Done" };
		String[] menu4 = { "Add Task", "Show Report", "More", "Back" };
		String[] menu5 = { "Search for a Task", "Delete a Task", "Cancel" };
		String[] menu6 = { "Developer", "Task Name", "Status", "Longest Duration", "Cancel" };
		String[] statusOptions = { "To Do", "Done", "Doing" };

		String[] taskNames;
		String[] developer;
		String displayTasks;

		int index, application, mode, totalTasks, totalHours, taskNumber;
		boolean menu, status;

		/**
		 * This is the start of the application. There are three while-loops, within
		 * one, large while-loop (menu). The while-loop (menu) ensures that the
		 * application will continue running, until the user selects quit. The other
		 * three while-loops, are for the three menus, while their conditions remain
		 * true. The three menu's conditions are dependent on the variable,
		 * "application", which is determined on the user's input and selection of
		 * options.
		 * 
		 * The first menu, is for the user deciding whether to login, register or quit.
		 * Once the user has logged in successfully, the user will be directed to the
		 * second menu.
		 * 
		 * The second menu, offers the user to, edit their account, continue to
		 * EasyKanban or to logout. If the user selects, EasyKanban, they will then
		 * continue to the third menu.
		 * 
		 * The third menu, contains all the "Task" operations. The user may, show the
		 * report of all the captured tasks, search for a task, delete a task, or the
		 * user may go back to the second menu. If the user wishes to quit the
		 * application, they are required to first logout then to quit from the first
		 * menu.
		 */

		index = 0;
		application = 0;
		status = false;
		menu = true;

		/**
		 * This while-loop (menu) will run until the user has "Quit" the application.
		 * The user is given options to either Login, Register, Display accounts or
		 * Quit. If the user already has an account registered they may select Login,
		 * which will return an integer that gets passed to a switch statement. If they
		 * select register, they will be required to enter their first name, last name,
		 * username, and password. Their account will be successfully registered if
		 * their username and password meet the requirements. Once the user has
		 * successfully logged in, the boolean 'status' will be set to true and the
		 * integer variable, 'application' will be set to 1. Enabling the user to
		 * continue to the next menu.
		 */

		while (menu) {

			while (application == 0) {

				mode = JOptionPane.showOptionDialog(null, "What would you like to do?", null, 0,
						1, null, menu1, null);

				// String[] menu1 = { "Login", "Register", "Quit", "Display Accounts" };
				switch (mode) {

					case 0: // Login

						status = false;

						JOptionPane.showMessageDialog(null, "Welcome! Please login with your details.", null,
								JOptionPane.PLAIN_MESSAGE);

						String targetUsername = "Dean_";
						String targetPassword = "Dean123!";

						// String targetUsername = JOptionPane.showInputDialog("Please enter your
						// username.", null);
						// String targetPassword = JOptionPane.showInputDialog("Please enter your
						// password.", null);

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
							JOptionPane.showMessageDialog(null, accountList.get(index).returnLoginStatus(status), null,
									JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, user.returnLoginStatus(status), null,
									JOptionPane.PLAIN_MESSAGE);
						}

						break;

					case 1: // Register

						try {
							user = new Login();

							user.setFirstName(JOptionPane.showInputDialog("Enter your First Name:", "First Name"));
							if (user.getFirstName() == null) {
								break;
							}

							user.setLastName(JOptionPane.showInputDialog("Enter your Last Name:", "Last Name"));
							if (user.getLastName() == null) {
								break;
							}

							user.setUsername(JOptionPane.showInputDialog("Create your Username:", "Username"));

							while (!user.checkUsername()) {
								JOptionPane.showMessageDialog(null, user.registerUser(), null,
										JOptionPane.PLAIN_MESSAGE);
								user.setUsername(JOptionPane.showInputDialog("Create your Username:", "Username"));
							}

							JOptionPane.showMessageDialog(null, "Username Successfully Captured.", null,
									JOptionPane.PLAIN_MESSAGE);

							user.setPassword(JOptionPane.showInputDialog("Create your Password:", "Password"));

							while (!user.checkPasswordComplexity()) {
								JOptionPane.showMessageDialog(null, user.registerUser(), null,
										JOptionPane.PLAIN_MESSAGE);
								user.setPassword(JOptionPane.showInputDialog("Create your Password:", "Password"));
							}

							JOptionPane.showMessageDialog(null, "Password Successfully Captured.", null,
									JOptionPane.PLAIN_MESSAGE);

							JOptionPane.showMessageDialog(null, user.registerUser(), null, JOptionPane.PLAIN_MESSAGE);

							/**
							 * This catches the "NullPointerException" which occurs when the user selects
							 * "Cancel" whilst entering the username or password. The exception occurs
							 * because the username and password are checked to see if they meet the
							 * requirements, but the username and password checks, can't check a "null"
							 * string, which is what gets returned, if the user selects, "Cancel".
							 */

						} catch (NullPointerException e) {
							break;
						}
						accountList.add(user);
						break;

					case 2: // Quit

						application = 3;
						menu = false;
						break;

					case 3: // Display Accounts

						String displayAccounts = "Registered Accounts: \n" + "\n";

						for (Login searchArray : accountList) {
							displayAccounts = displayAccounts + searchArray.displayAccounts() + "\n";
						}

						JOptionPane.showMessageDialog(null, displayAccounts, null, JOptionPane.PLAIN_MESSAGE);
						break;

				} // End of switch statement

				/**
				 * This is the second menu where the user is taken to after a successful login.
				 * The user has the options to edit their account details, continue to
				 * EasyKanban or Logout.
				 * 
				 * If the user selects 'edit account' an integer is
				 * returned and passed to a switch statement, where they will have more options
				 * to select. On any of the options the user selects, a set method is used to
				 * update their new details. If the user wishes to change their password, they
				 * will still need to meet the password requirements. The user may also be
				 * allowed to delete their account, which removes that object from the array
				 * list, indexed at the correct position using a variable called, 'index' which
				 * is set when the user successfully logs in.
				 * 
				 * The other option, EasyKanban, will set, application to 2, break out of the
				 * switch statement and direct the user to the next menu, EasyKanban.
				 * The Logout option, sets application back to 1, and status to false.
				 */

			} // WHILE LOOP Ending for (application == 0)

			while (application == 1) {

				mode = JOptionPane.showOptionDialog(null,
						"What would you like to do, " + accountList.get(index).getFirstName() + "?", null,
						0,
						1, null, menu2, null);

				// String[] menu2 = { "Edit Account", "EasyKanban", "Logout" };
				switch (mode) {

					case 0: // Edit Account

						mode = JOptionPane.showOptionDialog(null,
								"Account Details: \n\n" + accountList.get(index).displayAccounts(), "Edit Account",
								0,
								1, null, menu3, null);

						// String[] menu3 = { "Change First Name", "Change Last Name", "Change
						// Password", "Delete Account", "Done" };
						switch (mode) {

							case 0: // Change First Name

								String tempFirstName = accountList.get(index).getFirstName();
								accountList.get(index)
										.setFirstName(
												JOptionPane.showInputDialog("Please Enter your NEW First Name:", null));
								if (accountList.get(index).getFirstName() == null) {
									accountList.get(index).setFirstName(tempFirstName);
									break;
								}
								JOptionPane.showMessageDialog(null, "First Name Successfully Updated!", null,
										JOptionPane.PLAIN_MESSAGE);
								break;

							case 1: // Change Last Name

								String tempLastName = accountList.get(index).getLastName();
								accountList.get(index)
										.setLastName(
												JOptionPane.showInputDialog("Please Enter your NEW Last Name:", null));
								if (accountList.get(index).getLastName() == null) {
									accountList.get(index).setLastName(tempLastName);
									break;
								}
								JOptionPane.showMessageDialog(null, "Last Name Successfully Updated!", null,
										JOptionPane.PLAIN_MESSAGE);
								break;

							case 2: // Change Password

								String tempPassword = accountList.get(index).getPassword();
								try {
									accountList.get(index)
											.setPassword(JOptionPane.showInputDialog("Please Enter your NEW Password:",
													null));

									while (!accountList.get(index).checkPasswordComplexity()) {
										JOptionPane.showMessageDialog(null, accountList.get(index).registerUser(), null,
												JOptionPane.PLAIN_MESSAGE);
										accountList.get(index).setPassword(
												JOptionPane.showInputDialog("Please Enter your NEW Password:", null));
									}

									JOptionPane.showMessageDialog(null, "Password Successfully Updated!", null,
											JOptionPane.PLAIN_MESSAGE);
									break;

								} catch (NullPointerException e) {
									if (accountList.get(index).getPassword() == null) {
										accountList.get(index).setPassword(tempPassword);
									}
									break;
								}
							case 3: // Delete Account

								if (JOptionPane.showConfirmDialog(null,
										"Are you sure you want to \nDELETE your Account?") == 0) {

									accountList.remove(index);
									JOptionPane.showMessageDialog(null, "Your Account has been Deleted!", null,
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

				/**
				 * This while loop is for the EasyKanban menu. The user has four options:
				 * 
				 * Add Task, which allows the user to enter as many tasks as they would like.
				 * 
				 * Show Report, this function displays all the tasks that have been captured,
				 * excluding the tasks that have been deleted, or unsuccessfully added.
				 * 
				 * More, this option allows the user to search for specific tasks via the task
				 * name, developer name, task status, which will then display the task details.
				 * The user may also delete a task or display the task with the longest
				 * duration.
				 */

			} // WHILE LOOP Ending for (application == 1)

			if (application == 2) {
				JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!", null,
						JOptionPane.PLAIN_MESSAGE);
				displayTasks = "Task List";
				totalHours = 0;
			}

			while (application == 2) {

				mode = JOptionPane.showOptionDialog(null, "EasyKanban", "Select an Option", 0, 1, null, menu4,
						null);

				// String[] menu4 = { "Add Task", "Show Report", "More", "Back" };
				switch (mode) {

					/**
					 * If the user has selected "Add Task", the following operations will take
					 * place.
					 * 
					 * The task number will be set to the number of tasks that have been captured +
					 * 1, so that the the task number will be indexed as the last element of the
					 * array list, taskList. totalTasks will be initialized as it will be set with
					 * the user's input. A try and catch is used to catch the
					 * "NumberFormatException" which is if the user inputs a string rather than a
					 * number.
					 * 
					 * Once the user has successfully inputed the number of tasks they would like to
					 * add, a for loop will be executed. It will iterate until the counter variable
					 * is equal to the number of tasks the user would like to add.
					 * 
					 * At the start of the for loop, an object of "Task" will be created, which will
					 * be used to set the attributes of that object. The user will be prompt with a
					 * few required inputs for each task, such as the task name, task description,
					 * who the task is assigned to, the task duration, and the task status.
					 * 
					 * If the user has successfully inputed all the details of the task, and the
					 * task description meets the requirements, that object of "Task" will be added
					 * to the array list of type "Task", or else if the user has unsuccessfully
					 * added a task, all the tasks that were previously added correctly will remain
					 * captured, but the for loop will break and the user will have to add the tasks
					 * that were not captured.
					 */

					case 0: // Add Task

						taskNumber = taskList.get(taskList.size() - 1).getTaskNumber() + 1;
						totalTasks = 0;

						try {
							// Number of tasks
							totalTasks = Integer.parseInt(
									JOptionPane.showInputDialog(
											"Please Enter the Number of Tasks you would like to add:"));
						} catch (NumberFormatException e) {

							JOptionPane.showMessageDialog(null, "You need to Enter a Number, Please Try Again!", null,
									JOptionPane.PLAIN_MESSAGE);
							break;
						}
						displayTasks = "Captured Tasks: \n";

						for (int i = 0; i < totalTasks; i++) {

							tasks = new Task();

							// Task Name
							tasks.setTaskName(JOptionPane.showInputDialog("Please Enter the Name of the Task:", null));
							if (tasks.getTaskName() == null) {
								break;
							}

							// Task Number
							tasks.setTaskNumber(taskNumber);

							// Task Description and check if description is valid
							tasks.setTaskDesc(
									JOptionPane.showInputDialog("Enter a brief Description of this Task:", null));
							if (tasks.getTaskDesc() == null) {
								break;
							}

							while (!tasks.checkTaskDescription()) {
								JOptionPane.showMessageDialog(null,
										"Please Enter a Task Description of less than 50 Characters.", null,
										JOptionPane.PLAIN_MESSAGE);
								tasks.setTaskDesc(
										JOptionPane.showInputDialog("Enter a brief Description of this Task:"));
							}

							// Developers Name
							tasks.setDevName(JOptionPane.showInputDialog("Enter the Developer's Name:", null));
							if (tasks.getDevName() == null) {
								break;
							}

							// Task Duration
							try {
								tasks.setTaskHours(Integer.parseInt(
										JOptionPane.showInputDialog("Please Enter the Duration of the Task (Hours):")));
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "You need to Enter a Number. \nPlease Try Again!",
										null,
										JOptionPane.PLAIN_MESSAGE);
								break;
							}

							// Task ID + createTaskID
							try {
								tasks.setTaskID(tasks.createTaskID());

								/**
								 * A try and catch statement, for if the developer's name and the task name is
								 * too short for the "createTaskID" method.
								 */

							} catch (StringIndexOutOfBoundsException e) {
								JOptionPane.showMessageDialog(null,
										"The Task Name must be atleast 2 Characters,\nand the Developer's Name atleast 3 Characters. \n"
												+ "Please Try Again!",
										null, JOptionPane.PLAIN_MESSAGE);
								break;
							}

							// Task Status
							tasks.setTaskStatus((String) JOptionPane.showInputDialog(null,
									"Please Select the Status of the Task", "Select One", JOptionPane.QUESTION_MESSAGE,
									null, statusOptions, statusOptions[0]));
							if (tasks.getTaskStatus() == null) {
								break;
							}

							// End of for loop and successful task added.
							JOptionPane.showMessageDialog(null, "Task Successfully Captured.", null,
									JOptionPane.PLAIN_MESSAGE);
							taskList.add(tasks);
							taskNumber++;
						}

						totalHours = tasks.returnTotalHours(taskList);

						for (Task searchArray : taskList) {
							displayTasks = displayTasks + "\n" + searchArray.printTaskDetails() + "\n";
						}

						JOptionPane.showMessageDialog(null, displayTasks + "\nTotal Hours = " + totalHours + " Hours");
						break;

					/**
					 * This case will display all the captured tasks, excluding the ones that have
					 * been deleted. It starts by setting the displayTasks string to a new heading.
					 * The for loop will iterate through the entire array list called taskList,
					 * temporarily store it in "searchArray", add that string to "displayTasks" and
					 * then uses JOptionPane to display that string.
					 */

					case 1: // Show Report

						displayTasks = "Captured Tasks: \n";
						totalHours = tasks.returnTotalHours(taskList);

						for (Task searchArray : taskList) {

							displayTasks = displayTasks + "\n" + searchArray.printTaskDetails() + "\n";

						}
						JOptionPane.showMessageDialog(null, displayTasks + "\nTotal Hours = " + totalHours + " Hours",
								null, JOptionPane.PLAIN_MESSAGE);
						break;

					/**
					 * In this case, the option "More" has been selected and this is where all the
					 * functions for manipulating the existing tasks is executed. The user may
					 * select either "Search for a Task" or "Delete a Task".
					 */

					case 2: // More

						mode = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an Option", 0,
								1, null, menu5, null);

						switch (mode) {

							case 0: // Search for Task

								mode = JOptionPane.showOptionDialog(null, "Search for a Task by:", "Select an Option",
										0, 1, null, menu6, null);

								/**
								 * The user has selected "Search for a Task", and now has the options to select
								 * in what way they would like to search for a task. In either of the cases,
								 * they all search for tasks in the same way.
								 * 
								 * The string arrays are initialized with the size of the "taskList", it then
								 * iterates through the array list with a for loop and populates the string
								 * array, depening on the selection of how the user would like to search for a
								 * task.
								 * 
								 * Once the string array is populated, it is used in JOptionPane to
								 * display a drop down menu so the user may select all the existing options.
								 * Their selection is then stored in a string, and that string is then compared
								 * to every element in the array list. If the two strings are equal, then all
								 * the attributes of that element in the array list is stored in a string. That
								 * string is then used to display all the task details.
								 */

								switch (mode) {

									case 0: // Developer

										developer = new String[taskList.size()];

										for (int i = 0; i < taskList.size(); i++) {

											developer[i] = taskList.get(i).getDevName();
										}

										String searchDev = (String) JOptionPane.showInputDialog(null,
												"Please select the Developer's Name:", "Select an Option",
												JOptionPane.QUESTION_MESSAGE,
												null, developer, developer[0]);

										if (searchDev == null) {
											break;
										}

										displayTasks = "Tasks Assigned to: " + searchDev + "\n";

										for (Task searchArray : taskList) {
											if (searchArray.getDevName().equals(searchDev)) {
												displayTasks = displayTasks + "\nTask Name: "
														+ searchArray.getTaskName() + "\nTask Status: "
														+ searchArray.getTaskStatus() + "\n";
											}
										}

										JOptionPane.showMessageDialog(null, displayTasks, null,
												JOptionPane.PLAIN_MESSAGE);
										break;

									case 1: // Task Name

										taskNames = new String[taskList.size()];

										for (int i = 0; i < taskList.size(); i++) {

											taskNames[i] = taskList.get(i).getTaskName();
										}

										String searchTask = (String) JOptionPane.showInputDialog(null,
												"Please select the Task's Name:", "Select an Option",
												JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

										if (searchTask == null) {
											break;
										}

										displayTasks = "Tasks with Task Name: " + searchTask + "\n";

										for (Task searchArray : taskList) {
											if (searchArray.getTaskName().equals(searchTask)) {
												displayTasks = displayTasks + "\nDeveloper: "
														+ searchArray.getDevName() + "\nTask Status: "
														+ searchArray.getTaskStatus() + "\n";
											}
										}

										JOptionPane.showMessageDialog(null, displayTasks, null,
												JOptionPane.PLAIN_MESSAGE);
										break;

									case 2: // Status

										String searchStatus = (String) JOptionPane.showInputDialog(null,
												"Please select the Status of the Task:", "Select an Option",
												JOptionPane.QUESTION_MESSAGE,
												null, statusOptions, statusOptions[0]);

										if (searchStatus == null) {
											break;
										}

										displayTasks = "Tasks with the Status: " + searchStatus + "\n";

										for (Task searchArray : taskList) {
											if (searchArray.getTaskStatus().equals(searchStatus)) {
												displayTasks = displayTasks + "\nDeveloper: "
														+ searchArray.getDevName() + "\nTask Name: "
														+ searchArray.getTaskName() + "\nTask Duration: "
														+ searchArray.getTaskHours() + " Hours\n";
											}
										}

										JOptionPane.showMessageDialog(null, displayTasks, null,
												JOptionPane.PLAIN_MESSAGE);
										break;

									/**
									 * To calculate the longest duration, two temporary variables are intialized. A
									 * variable to hold the largest amount of hours as a integer, and the other
									 * variable to hold the index of that task in the array list.
									 * 
									 * The for loop iterates through the entire array list, comparing the duration
									 * of each task to the max hours and if it is greater than the max then it
									 * stores the new max in the temp variable, "highestHours" and the index of that
									 * element, "tempIndex" is set to i.
									 * 
									 * Once the entire array list has been looped through,
									 * the task with the longest duration's index is stored in "tempIndex" and the
									 * taskList then gets the task's details with "tempIndex" and displays it.
									 */

									case 3: // Longest Duration

										int highestHours = 0;
										int tempIndex = 0;

										displayTasks = "Task with Longest Duration: " + "\n";

										for (int i = 0; i < taskList.size(); i++) {
											if (taskList.get(i).getTaskHours() > highestHours) {
												highestHours = taskList.get(i).getTaskHours();
												tempIndex = i;
											}
										}
										displayTasks = displayTasks + "\nDeveloper: "
												+ taskList.get(tempIndex).getDevName() + "\nTask Duration: "
												+ taskList.get(tempIndex).getTaskHours() + " Hours";
										JOptionPane.showMessageDialog(null, displayTasks, null,
												JOptionPane.PLAIN_MESSAGE);
										break;

									case 4: // Cancel
										break;

								}
								break;

							/**
							 * To delete a task, it is required to delete a task via the task name.
							 * Therefore the string array taskName is initialized and populated by iterating
							 * through the array list, taskList, and getting all the task names. The
							 * taskName array is then used to display all the task names to the user for
							 * their selection.
							 * 
							 * Once the user has selected what task they would like to
							 * delete, the task name is returned as a string and stored in the string
							 * called, "searchTask". The taskList is then iterated through starting at the
							 * last element and going through to the first element, so that if there are any
							 * dupicate tasks, all the tasks with that name are removed, because if the loop
							 * starts at the first element, the array size is reduced and the last elements
							 * are skipped.
							 */

							case 1: // Delete a Task

								taskNames = new String[taskList.size()];

								for (int i = 0; i < taskList.size(); i++) {

									taskNames[i] = taskList.get(i).getTaskName();
								}
								String searchTask = (String) JOptionPane.showInputDialog(null,
										"Please Select the Task Name to be Deleted:", "Select an Option",
										JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

								if (searchTask == null) {
									break;
								}

								for (int i = taskList.size() - 1; i >= 0; i--) {

									if (taskList.get(i).getTaskName().equals(searchTask)) {
										taskList.remove(i);
									}
								}

								JOptionPane.showMessageDialog(null, "Entry '" + searchTask + "' Successfully Deleted!",
										null, JOptionPane.PLAIN_MESSAGE);
								break;

							case 2: // Cancel
								break;
						}
						break;

					case 3: // Back

						application = 1;
						break;

				}

			} // WHILE LOOP Ending for (application == 2)

		} // WHILE LOOP Ending for (menu == 0)

	} // End of Main

} // End of Class
