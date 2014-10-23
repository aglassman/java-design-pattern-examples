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
public class XmlDocBuilder implements DocBuilder{

	StringBuilder sb = new StringBuilder();
	
	public void createDoc() {
		sb.append("<xml>");
	}

	public void addText(String text) {
		sb.append("<text>").append(text).append("</text>");
	}

	public void addInteger(Integer integer) {
		sb.append("<integer>").append(integer).append("</integer>");
	}

	public void addDate(Date date) {
		sb.append("<date>").append(date).append("</date>");
	}

	public String getProduct() {
		sb.append("</xml>");
		return sb.toString();
	}

}
