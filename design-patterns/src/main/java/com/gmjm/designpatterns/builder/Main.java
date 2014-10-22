package com.gmjm.designpatterns.builder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.gmjm.util.CliUtil;

public class Main {

	private static Options getOptions()
	{
		Options o = new Options();
		o.addOption("fileName", true, "File name of text file to transform.");
		o.addOption("builder", true, "The type of builder to use [counting, sysOut, xml].");
		return o;
	}
	
	public static void main(String[] args) throws IOException {
		CommandLine cmd = CliUtil.parse("Builder : ", getOptions(), args);
		
		if(cmd.hasOption("fileName"))
		{
			String builderType = cmd.getOptionValue("builder");
			if("counting".equalsIgnoreCase(builderType))
			{
				CountingDocBuilder builder = new CountingDocBuilder();
				DocumentDirector documentCreator = new DocumentDirector(builder);
				documentCreator.construct(new File(cmd.getOptionValue("fileName")));
				System.out.println(builder.getProduct());
			} else if ("sysOut".equalsIgnoreCase(builderType))
			{
				SystemOutDocBuilder builder = new SystemOutDocBuilder();
				DocumentDirector documentCreator = new DocumentDirector(builder);
				documentCreator.construct(new File(cmd.getOptionValue("fileName")));
			} else if ("xml".equalsIgnoreCase(builderType))
			{
				XmlDocBuilder builder = new XmlDocBuilder();
				DocumentDirector documentCreator = new DocumentDirector(builder);
				documentCreator.construct(new File(cmd.getOptionValue("fileName")));
				System.out.println(builder.getProduct());
			}
		}
		
	}

}
