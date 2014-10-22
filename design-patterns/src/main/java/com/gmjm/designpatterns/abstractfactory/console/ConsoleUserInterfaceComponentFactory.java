package com.gmjm.designpatterns.abstractfactory.console;

import com.gmjm.designpatterns.abstractfactory.InputGetter;
import com.gmjm.designpatterns.abstractfactory.Notifier;
import com.gmjm.designpatterns.abstractfactory.UserInterfaceComponentFactory;

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
