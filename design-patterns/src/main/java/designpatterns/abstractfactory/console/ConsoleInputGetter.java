package designpatterns.abstractfactory.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import designpatterns.abstractfactory.InputGetter;

/**
 * <h1>ConcreteProduct</h1>
 * 
 * Defines a product object to be created by the corresponding concrete factory..
 * 
 * This interface defines an product object that will return
 * a string from the user via the stdIn console.
 * 
 * @author 755251
 *
 */
public class ConsoleInputGetter implements InputGetter{

	public String getInput() {
		System.out.print("Enter Input: ");
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
		String input = null;
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		return input;
	}
	
}
