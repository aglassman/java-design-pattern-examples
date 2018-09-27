package designpatterns.creational.singleton;

public class Main {
	public static void main(String ... args) throws ClassNotFoundException
	{
		/*
		 * If you comment out the following lines you will get a compile error.  This is
		 * because the constructors are private.  You could still call the constructors via
		 * reflection.  This is another reason to avoid this pattern.  It is hard to enforce
		 * a single instance of an object at runtime.
		 * 
		 */
		
		//This triggers the static initializer block to be executed.
		Class<FileManagerStaticInit> clazz = (Class<FileManagerStaticInit>) Class.forName(
        "designpatterns.creational.singleton.FileManagerStaticInit");
		
		//FileManagerStaticInit fileManagerStaticInit = new FileManagerStaticInit();
		//FileManagerGetInstanceInit fileManagerGetInstanceInit = new FileManagerGetInstanceInit();
		
		FileManagerGetInstanceInit fileManager = FileManagerGetInstanceInit.getInstance("C:/myDirectory");
		
	}
}
