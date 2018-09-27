package designpatterns.creational.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import util.CliUtil;

public class Main {

	private static Options getOptions()
	{
		Options o = new Options();
		o.addOption("fileName", true, "(optional) File name of text file to transform.");
		o.addOption("builder", true, "The type of builder to use [counting, sysOut, xml].");
		return o;
	}
	
	public static void main(String[] args) throws IOException {
		CommandLine cmd = CliUtil.parse("Builder : ", getOptions(), args);
		
		if(cmd == null)
			return;
		
		InputStream inputStream = null;
		
		if(cmd.hasOption("fileName"))
		{
			inputStream = new FileInputStream(new File(cmd.getOptionValue("fileName")));
		}
		else
		{
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("builder/testFile.txt");
		}

		if(inputStream == null)
		{
			System.err.println("Could not find input resource.");
			return;
		}
		
		
		String builderType = cmd.getOptionValue("builder");
		
		if("counting".equalsIgnoreCase(builderType))
		{
			CountingDocBuilder builder = new CountingDocBuilder();
			DocumentDirector documentCreator = new DocumentDirector(builder);
			documentCreator.construct(inputStream);
			System.out.println(builder.getProduct());
		} else if ("sysOut".equalsIgnoreCase(builderType))
		{
			SystemOutDocBuilder builder = new SystemOutDocBuilder();
			DocumentDirector documentCreator = new DocumentDirector(builder);
			documentCreator.construct(inputStream);
		} else if ("xml".equalsIgnoreCase(builderType))
		{
			XmlDocBuilder builder = new XmlDocBuilder();
			DocumentDirector documentCreator = new DocumentDirector(builder);
			documentCreator.construct(inputStream);
			System.out.println(builder.getProduct());
		}
		
	}

}
