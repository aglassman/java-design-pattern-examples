# Prototype 

## Intent (From GOF book)

Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

## Example
The application starts with a base `Rectangle` prototype.  You modify the base prototype's color, size, and border width.   When you want to save a setting, you can click "clone prototype", and a new Rectangle object will be available in the palate.  This design pattern allows for many different types of Rectangles without exploding the class hierarchy.  It also allows our Palate tool to not have to know about any different types of shapes since they all inherit from the prototype interface Shape.




## How to run
The following command will run this example:

	java -cp design-patterns.jar designpatterns.prototype.Main
	

