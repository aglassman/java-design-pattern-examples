package designpatterns.creational.abstractfactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BasicFileWritingApp {
	
	final UserInterface ui;
	
	public BasicFileWritingApp(UserInterface ui){
		this.ui = ui;
	}
	
	public void start(String fileName) throws IOException
	{
		BufferedWriter bw = getFile(fileName);
		
		String currentInput = ui.getInput();
		
		while(currentInput != null && !currentInput.equalsIgnoreCase("exit"))
		{
			bw.write(currentInput + "\n");
			currentInput = ui.getInput();
		}
		
		ui.notify("Writing has completed.");
		
		bw.close();
	}

	private BufferedWriter getFile(String fileName) throws IOException {
		File file = new File(fileName);
		ui.notify("Writing to file: " + file.getAbsolutePath());
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		return bw;
	}

	
}
