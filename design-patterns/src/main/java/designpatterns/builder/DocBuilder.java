package designpatterns.builder;

import java.util.Date;

/**
 * <h1>Builder</h1>
 * 
 * Specifies an abstract interface for creating parts of a Product object
 * 
 * @author 755251
 *
 */
public interface DocBuilder {
	public void createDoc();
	public void addText(String text);
	public void addInteger(Integer integer);
	public void addDate(Date date);
}
