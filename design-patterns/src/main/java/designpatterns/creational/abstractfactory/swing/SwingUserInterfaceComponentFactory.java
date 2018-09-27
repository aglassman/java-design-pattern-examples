package designpatterns.creational.abstractfactory.swing;

import designpatterns.creational.abstractfactory.InputGetter;
import designpatterns.creational.abstractfactory.Notifier;
import designpatterns.creational.abstractfactory.UserInterfaceComponentFactory;

/**
 * <h1>ConcreteFactory</h1>
 * 
 * Implements the operations to create concrete product objects.
 * 
 * This Concrete Factory creates Swing UI Components.
 * 
 * @author 755251
 *
 */
public class SwingUserInterfaceComponentFactory implements UserInterfaceComponentFactory{

	public Notifier getNotifier() {
		return new SwingNotifier();
	}

	public InputGetter getInputGetter() {
		return new SwingInputGetter();
	}

}
