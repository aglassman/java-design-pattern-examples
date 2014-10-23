package designpatterns.abstractfactory;

/**
 * <h1>AbstractProduct</h1>
 * 
 * Declares an interface for a type of product object.
 * 
 * This interface defines an product object that will return
 * a string from the UI user.
 * 
 * @author 755251
 *
 */
public interface InputGetter {
	public String getInput();
}
