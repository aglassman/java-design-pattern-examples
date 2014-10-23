package designpatterns.factorymethod;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import designpatterns.factorymethod.task.Task;
import designpatterns.factorymethod.task.TaskFactory;
import util.CliUtil;

public class Main {
	private static Options getOptions()
	{
		Options o = new Options();
		o.addOption("", true, "");
		return o;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		CommandLine cmd = CliUtil.parse("Factory Method : ", getOptions(), args);
		
		
		if(cmd == null)
			return;
		
		new TaskManager();

	}
}
