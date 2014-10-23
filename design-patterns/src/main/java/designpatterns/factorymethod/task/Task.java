package designpatterns.factorymethod.task;


public abstract class Task {
	public String taskName;
	public String taskDescription;
	public boolean complete = false;
	
	public Task(String taskName, String taskDescription)
	{
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	@Override
	public String toString()
	{
		return "Task: " + taskName + " : " + taskDescription + " : Complete = " + complete;
	}
}
