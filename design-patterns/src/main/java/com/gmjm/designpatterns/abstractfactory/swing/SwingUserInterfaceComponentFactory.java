package com.gmjm.designpatterns.abstractfactory.swing;

import com.gmjm.designpatterns.abstractfactory.InputGetter;
import com.gmjm.designpatterns.abstractfactory.Notifier;
import com.gmjm.designpatterns.abstractfactory.UserInterfaceComponentFactory;

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
