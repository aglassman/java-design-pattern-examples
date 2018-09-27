package designpatterns.creational.factorymethod.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DateSpecificTask extends Task {

	public Date dueDate = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public DateSpecificTask(String taskName, String taskDescription) {
		super(taskName, taskDescription);
		
		Date inputDate = null;
		
		while(inputDate == null)
		{
			String dateString = JOptionPane.showInputDialog("Input Date: MM/dd/yyyy");
			try{
				inputDate = sdf.parse(dateString);
			} catch(ParseException e) {
				JOptionPane.showMessageDialog(null, "Parse exception, please use format: MM/dd/yyy");
			}
		}
		
		dueDate = inputDate;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " : Due Date = " + sdf.format(dueDate);
	}
	
}
