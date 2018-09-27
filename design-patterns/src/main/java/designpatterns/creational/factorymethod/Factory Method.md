# Factory Method 

### Type: Creational

## Intent (From GOF book)

Define an interface for creating an object, but let subclasses decide which class to instantiate.  Factory Method lets a class defer instantiation to subclasses.  Also known as Virtual Constructor.

## Example
In this example, we have a simple Task Manager application that manages Task objects.  Task objects are objects that implement the Task interface.  The base application framework should be able to create new Tasks from the file menu.  It would be beneficial to the application developer to not have to modify base application code every time the development team wants to add a new subclass of the `Task` object.  This is where the `TaskFactory` comes in.  The application can pass the `TaskFactory` factory method a string for the type of Task we would like to create.  The `TaskFactory` will supply the application with a `Task` object without the application having to know which subclass was actually created.


**How is this different from Abstract Factory?**
This design pattern differs from Abstract Factory in that the factory is not creating a family of related objects.  The Factory Method is very specific in that it only creates subclasses of a specific object.  

## How to run
The following command will run this example:

	java -cp design-patterns.jar designpatterns.creational.factorymethod.Main
	
## Try It Out
Pull the code, and try adding a subclass of Task with your own special modification.  Add the class to the `taskFactoryClassList` in the `TaskFactory` constructor to make it available in the "Add Task" menu options.
	
