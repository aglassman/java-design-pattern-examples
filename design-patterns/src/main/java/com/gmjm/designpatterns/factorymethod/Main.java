package com.gmjm.designpatterns.factorymethod;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.gmjm.util.CliUtil;

public class Main {
	private static Options getOptions()
	{
		Options o = new Options();
		o.addOption("", true, "");
		return o;
	}
	
	public static void main(String[] args)
	{
		CommandLine cmd = CliUtil.parse("Factory Method : ", getOptions(), args);
		
		
	}
}
