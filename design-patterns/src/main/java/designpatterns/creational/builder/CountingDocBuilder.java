package designpatterns.creational.builder;

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
public class CountingDocBuilder implements DocBuilder{

	int texts = 0;
	int integers = 0;
	int dates = 0;
	
	public void createDoc() {
		// TODO Auto-generated method stub
		
	}

	public void addText(String text) {
		texts++;
	}

	public void addInteger(Integer integer) {
		integers++;
	}

	public void addDate(Date date) {
		dates++;
	}

	public String getProduct() {
		return String.format("Counts: [texts = %s , integers = %s, dates = %s]",texts,integers,dates);
	}
	
}
