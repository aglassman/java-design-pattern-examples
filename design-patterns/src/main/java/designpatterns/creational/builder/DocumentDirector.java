package designpatterns.creational.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * <h1>Director</h1>
 * 
 * Constructs an object using the Builder interface.
 * 
 * @author 755251
 *
 */

public class DocumentDirector {
	
	private final DocBuilder docBuilder;
	
	public static final String TEXT = "text: ";
	public static final String INTEGER = "integer: ";
	public static final String DATE = "date: ";
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public DocumentDirector(DocBuilder docBuilder)
	{
		this.docBuilder = docBuilder;
	}
	
	public void construct(InputStream inputStream) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		
		String line = null;
		
		docBuilder.createDoc();
		
		while((line = br.readLine()) != null)
		{
			
			if(line.indexOf(TEXT) != -1)
			{
				docBuilder.addText(line.substring(TEXT.length(), line.length()));
			}
			else if(line.indexOf(INTEGER) != -1)
			{
				docBuilder.addInteger(new Integer(line.substring(INTEGER.length(), line.length())));
			}
			else if(line.indexOf(DATE) != -1)
			{
				try {
					docBuilder.addDate(sdf.parse( line.substring(DATE.length(), line.length()) ));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		br.close();
		
	}
	
}
