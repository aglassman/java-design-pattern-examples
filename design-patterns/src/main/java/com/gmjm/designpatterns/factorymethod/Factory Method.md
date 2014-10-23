# Factory Method 

## Intent (From GOF book)

Define an iterface for creating an object, but let subclasses decide which class to instantiate.  Factory Method lets a class defer instantiation to subclasses.  Also known as Virtual Constructor.

## Example

This example shows how the Abstract Factory can be used to provide two different user interface implementations for one program.  The BasicFileWritingApp is coded to the UserInterface interface.  The UserInterface object is injected with a UserInterfaceComponenetFactory when it is instantiated.  Depending on which Concrete Factory is used, the user will either interface with the app via the console, or via a windowed Swing interface.

## How to run
The following command will display the command line options for this example:

	java -cp design-patterns.jar com.gmjm.designpatterns.abstractfactory.Main -help
	
To exit the program, type "exit" into the input field.