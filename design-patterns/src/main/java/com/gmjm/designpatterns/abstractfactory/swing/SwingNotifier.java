package com.gmjm.designpatterns.abstractfactory.swing;

import javax.swing.JOptionPane;

import com.gmjm.designpatterns.abstractfactory.Notifier;

/**
 * <h1>ConcreteProduct</h1>
 * 
 * Defines a product object to be created by the corresponding concrete factory..
 * 
 * This interface defines an product object that will return
 * display a string to the user via a Swing message box.
 * 
 * @author 755251
 *
 */
public class SwingNotifier implements Notifier{

	public void notify(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
