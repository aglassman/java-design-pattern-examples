package designpatterns.creational.abstractfactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import util.CliUtil;
import designpatterns.creational.abstractfactory.console.ConsoleUserInterfaceComponentFactory;
import designpatterns.creational.abstractfactory.swing.SwingUserInterfaceComponentFactory;

public class Main {
	private static List<String> concreteFactories = Arrays.asList("swing","console");
	
	private static Options getOptions()
	{
		Options o = new Options();
		o.addOption("factory", true, "Pick which abstract factory to use: " + concreteFactories.toString());
		o.addOption("fileName", true, "The name of the file to be generated.");
		return o;
	}
	
	public static void main(String ... args) throws IOException
	{
		
		
		Options options = getOptions();
		
		CommandLine cmd = CliUtil.parse("Abstract Factory : Basic File Writing App",options,args);
		
		if(cmd == null)
			return;
		
		String factoryName = null;
		String fileName = null;
		
		if(cmd.hasOption("factory"))
		{
			factoryName = cmd.getOptionValue("factory");
		}
		
		if(cmd.hasOption("fileName"))
		{
			fileName = cmd.getOptionValue("fileName");
		}
		
		if(!concreteFactories.contains(factoryName))
		{
			System.out.println(factoryName + " is not a valid UserInterface factory.  Valid choices: " + concreteFactories.toString());
		}
		else if(fileName == null || fileName.isEmpty())
		{
			System.out.println("File name cannot be empty or null.");
		}
		else
		{
			UserInterface ui = new UserInterface(getFactory(factoryName));
			BasicFileWritingApp basicFileWritingApp = new BasicFileWritingApp(ui);
			basicFileWritingApp.start(fileName);
		}
		
		
	}
	
	private static UserInterfaceComponentFactory getFactory(String factoryName)
	{
		System.out.println("Instantiating UserInterface factory: " + factoryName);

		UserInterfaceComponentFactory uiFactory = null;
		
		if("swing".equals(factoryName))
		{
			uiFactory = new SwingUserInterfaceComponentFactory();
		}
		else if("console".equals(factoryName))
		{
			uiFactory = new ConsoleUserInterfaceComponentFactory();
		}
		
		return uiFactory;
	}
}
