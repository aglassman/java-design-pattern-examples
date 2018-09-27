package designpatterns.creational.factorymethod.task;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class TaskFactory {
	
	private List<Class<? extends Task>> taskFactoryClassList = new ArrayList<Class<? extends Task>>();
	
	public TaskFactory()
	{
		taskFactoryClassList.add(Task.class);
		taskFactoryClassList.add(DateSpecificTask.class);
		taskFactoryClassList.add(PrioritizedTask.class);
	}
	
	public List<Class<? extends Task>> getAvailableTaskClasses()
	{
		return Collections.unmodifiableList(taskFactoryClassList);
	}
	
	public Task createTask(Class<? extends Task> taskClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		int index = taskFactoryClassList.indexOf(taskClass);
		
		if(index < 0)
		{
			throw new IllegalArgumentException(taskClass + " is not a registered subclass of Task.");
		}
		
		String taskName = JOptionPane.showInputDialog("Input Task Name.");
		String taskDescription = JOptionPane.showInputDialog("Input Task Description.");
		
		return (Task) taskFactoryClassList.get(index).getConstructors()[0].newInstance(taskName,taskDescription);
	}
}
