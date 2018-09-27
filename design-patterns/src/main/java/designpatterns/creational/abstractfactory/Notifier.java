package designpatterns.creational.abstractfactory;

/**
 * <h1>Abstract Product</h1>
 * 
 * Declares an interface for a type of product object.
 * 
 * This interface defines an product object that will display 
 * a string message to the UI user.
 * 
 * @author 755251
 *
 */
public interface Notifier {
	public void notify(String message);
}
