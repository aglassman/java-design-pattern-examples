package designpatterns.abstractfactory.console;

import designpatterns.abstractfactory.Notifier;

/**
 * <h1>ConcreteProduct</h1>
 * 
 * Defines a product object to be created by the corresponding concrete factory..
 * 
 * This interface defines an product object that will display a message to the user
 * on the console via stdOut.
 * 
 * @author 755251
 *
 */
public class ConsoleNotifier implements Notifier{

	public void notify(String message) {
		System.out.println("Notification: " + message);
	}

}
