package designpatterns.creational.abstractfactory.swing;

import javax.swing.JOptionPane;

import designpatterns.creational.abstractfactory.InputGetter;

/**
 * <h1>ConcreteProduct</h1>
 * 
 * Defines a product object to be created by the corresponding concrete factory..
 * 
 * This interface defines an product object that will return
 * a string from user input via a Swing input dialog box.
 * 
 * @author 755251
 *
 */
public class SwingInputGetter implements InputGetter {

	public String getInput() {
		return JOptionPane.showInputDialog("Enter Input");
	}

}
