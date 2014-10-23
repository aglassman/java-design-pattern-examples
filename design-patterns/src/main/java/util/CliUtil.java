package util;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CliUtil {

	public static CommandLine parse(String appName, Options options, String[] args) {
		CommandLineParser clp = new BasicParser();
		CommandLine cmd = null;
		try{
			cmd = clp.parse(options, args);
		} catch (ParseException e){
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp(appName, options);
		}
		return cmd;
	}
}
