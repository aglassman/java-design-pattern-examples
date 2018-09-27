package designpatterns.creational.abstractfactory;

/**
 * <h1>Abstract Factory</h1>
 * 
 * Declares an interface for operations that create abstract product objects.
 * 
 * @author 755251
 *
 */
public interface UserInterfaceComponentFactory {
	public Notifier getNotifier();

	public InputGetter getInputGetter();
}
