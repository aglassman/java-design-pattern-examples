# Builder

### Type: Creational

## Intent (From GOF book)

Separate the construction of a complex object from its representation so that the same construction process can create different representations (aka a Product object).

## Example

This example shows how the Builder pattern can be used to create different complex objects, yet allow the process by which those objects are created to remain reusable.  The `DocumentDirector` reads in the testFile.txt from the test package.  the `DocumentDirector` is the code that remains reusable, despite which concrete implementation of `DocBuilder` is used.  Note that the calling code in Main does not cast the concrete `DocBuilder` to the `DocBuilder` interface.  This is because the implementations of `DocBuilder` can be vastly different in the `Product` object they create.  It wouldn't make sense to constrain the `Product` object to a specific Class.  The reason the `DocBuilder` interface is used is so that the `DocumentDirector` can work on many different types of `DocBuilders`, without knowing how they are implemented, or what their `Product` object will be.

This example uses a `DocumentDirector` that takes an input file with a simple format.  The text file defines three types of input: integer, date, and text.  The `Director` reads each line, parses the type of line, creates the appropriate object, then sends that object to the DocBuilder.  There are three simple implementations of DocBuilder:

**SystemOutDocBuilder:**  This Builder simply prints the data passed to the builder to stdOut.  This builder does not supply a `Product` object.

**CountingDocBuilder:**  This Builder keeps track of how many of each type of object has been passed to it.  This Builder's `Product` object is a string containing the counts.

**XmlDocBuilder:**  This Builder stores the data passed to it in a `StringBuilder`, which conform to a basic XML format.  This Builder's `Product` object is an XML String.

Look at the `DocumentDirector` to determine the file format, and date format, or look at the test file at *builder/testFile.txt*.

## How to run
The following command will display the command line options for this example:

	java -cp design-patterns.jar designpatterns.builder.Main -help
	
If you don't specify a fileName, the builder/testFile.txt resource will be used that is packaged with the JAR.
