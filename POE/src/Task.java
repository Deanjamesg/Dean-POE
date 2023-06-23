import java.util.ArrayList;

public class Task {

	private String taskName;
	private String taskDesc;
	private String devName;
	private String taskID;
	private String taskStatus;
	private int taskNumber;
	private int taskHours;

	public Task() {

	}

	public Task(String taskName, int taskNumber, String taskDesc, String devName, int taskHours, String taskID,
			String taskStatus) {

		this.taskName = taskName;
		this.taskNumber = taskNumber;
		this.taskDesc = taskDesc;
		this.devName = devName;
		this.taskHours = taskHours;
		this.taskID = taskID;
		this.taskStatus = taskStatus;

	}

	// Setters

	public void setTaskName(String taskName) {

		this.taskName = taskName;
	}

	public void setTaskNumber(int taskNumber) {

		this.taskNumber = taskNumber;
	}

	public void setTaskDesc(String taskDesc) {

		this.taskDesc = taskDesc;
	}

	public void setDevName(String devName) {

		this.devName = devName;
	}

	public void setTaskHours(int taskHours) {

		this.taskHours = taskHours;
	}

	public void setTaskID(String taskID) {

		this.taskID = taskID;
	}

	public void setTaskStatus(String taskStatus) {

		this.taskStatus = taskStatus;
	}

	// Getters

	public String getTaskName() {

		return taskName;
	}

	public int getTaskNumber() {

		return taskNumber;
	}

	public String getTaskDesc() {

		return taskDesc;
	}

	public String getDevName() {

		return devName;
	}

	public int getTaskHours() {

		return taskHours;
	}

	public String getTaskID() {

		return taskID;
	}

	public String getTaskStatus() {

		return taskStatus;
	}

	public boolean checkTaskDescription() {

		boolean result = false;

		if (taskDesc.length() <= 50) {
			result = true;
		}

		return result;
	}

	public String createTaskID() {

		String ID;

		ID = taskName.substring(0, 2) + ":" + taskNumber + ":"
				+ devName.substring(devName.length() - 3, devName.length());
		ID = ID.toUpperCase();

		return ID;
	}

	public String printTaskDetails() {

		String printTask = "Task Name: " + taskName + "\n" + "Task Number: " + taskNumber + "\n" + "Task Description: "
				+ taskDesc + "\n" + "Developer Name: " + devName + "\n" + "Task Duration: " + taskHours + " Hours\n"
				+ "Task ID: " + taskID + "\n" + "Task Status: " + taskStatus;

		return printTask;
	}

	public int returnTotalHours(ArrayList<Task> taskList) {

		int result = 0;

		for (int i = 0; i < taskList.size(); i++) {

			result = result + taskList.get(i).getTaskHours();
		}

		return result;
	}

}
