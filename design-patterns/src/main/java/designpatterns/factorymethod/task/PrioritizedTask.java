package designpatterns.factorymethod.task;

import javax.swing.JOptionPane;

public class PrioritizedTask extends Task {

	public int priority = 0;
	
	public PrioritizedTask(String taskName, String taskDescription) {
		super(taskName, taskDescription);
		
		Integer inputInteger = null;
		
		while(inputInteger == null)
		{
			String integerString = JOptionPane.showInputDialog("Input Priority (Integer)");
			try{
				inputInteger = new Integer(integerString);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Number format exception, please input an integer.");
			}
		}
		
		priority = inputInteger;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " : Priority = " + priority;
	}

}
