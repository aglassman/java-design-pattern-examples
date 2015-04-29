# Singleton

## Intent (From GOF book)

Ensure a class only has one instance, and provide a global point of access to it. 

(Note from aglassman): This pattern is generally avoided in Java programming. Using singletons can make testing your code much harder.  See this Stack Overflow post for further explanation: http://stackoverflow.com/questions/137975/what-is-so-bad-about-singletons 

## Example

This example shows how to create a few different singletons in Java.  The FileManagerStaticInit singleton instance is created using the static initializer and a private constructor.  The FileManagerGetInstanceInit singleton instance is created when getInstance() is called for the first time.  

## How to run
The following command will run this example:

	java -cp design-patterns.jar designpatterns.singleton.Main 
	
You can see in the system output that FileManagerStaticInit was created first, and getInstance did not have to be called.  Only once getInstance is called on FileManagerGetInstanceInit is the singleton created.  
	


