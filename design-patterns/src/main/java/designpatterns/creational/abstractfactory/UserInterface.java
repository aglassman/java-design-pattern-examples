package designpatterns.creational.abstractfactory;

/**
 * <h1>Client</h1>
 * 
 * Uses only interfaces declared by AbstractFactory and AbstractProduct classes.
 * 
 * This interface defines an product object that will return
 * a string from user input.
 * 
 * @author 755251
 *
 */
public class UserInterface {
	
	private final UserInterfaceComponentFactory factory;
	
	public UserInterface(UserInterfaceComponentFactory factory)
	{
		this.factory = factory;
	}	
	
	public void notify(String message)
	{
		Notifier notifier = factory.getNotifier();
		notifier.notify(message);
	}
	
	public String getInput()
	{
		InputGetter inputGetter = factory.getInputGetter();
		String input = inputGetter.getInput();
		
		return input;
	}
}
