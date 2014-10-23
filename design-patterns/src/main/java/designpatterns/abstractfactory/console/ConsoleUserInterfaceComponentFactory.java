package designpatterns.abstractfactory.console;

import designpatterns.abstractfactory.InputGetter;
import designpatterns.abstractfactory.Notifier;
import designpatterns.abstractfactory.UserInterfaceComponentFactory;

/**
 * <h1>ConcreteFactory</h1>
 * 
 * Implements the operations to create concrete product objects.
 * 
 * This Concrete Factory creates Console UI Components.
 * 
 * @author 755251
 *
 */
public class ConsoleUserInterfaceComponentFactory implements UserInterfaceComponentFactory{

	public Notifier getNotifier() {
		return new ConsoleNotifier();
	}

	public InputGetter getInputGetter() {
		return new ConsoleInputGetter();
	}
	
}
