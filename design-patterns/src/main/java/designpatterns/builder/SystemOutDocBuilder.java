package designpatterns.builder;

import java.util.Date;

/**
 * <h1>Concrete Builder</h1>
 * 
 * Constructs and assembles parts of the product by implementing the Builder interface.
 * 
 * Defines and keeps track of the represntation it creates.
 * 
 * Provides an interface for retrieving the product.
 * 
 * @author 755251
 *
 */

public class SystemOutDocBuilder implements DocBuilder{

	public void createDoc() {
		// TODO Auto-generated method stub
		
	}

	public void addText(String text) {
		System.out.println(text);
	}

	public void addInteger(Integer integer) {
		System.out.println(integer);
	}

	public void addDate(Date date) {
		System.out.println(date);
	}


}
