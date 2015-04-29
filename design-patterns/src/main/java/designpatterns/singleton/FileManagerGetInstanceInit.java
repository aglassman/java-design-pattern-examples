package designpatterns.singleton;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class FileManagerGetInstanceInit {

	private static FileManagerGetInstanceInit singleton;


	private final Map<String, File> fileMap = new HashMap<>();

	private FileManagerGetInstanceInit() {
		System.out.println("Creating FileManagerGetInstanceInit singleton.");
	}

	public static FileManagerGetInstanceInit getInstance() {
		if(singleton == null)
			singleton = new FileManagerGetInstanceInit();
		
		return singleton;
	}
	
	public File getFile(String filePath) {
		File cachedFile = fileMap.get(filePath);
		
		if(cachedFile != null)
		{
			return cachedFile;
		}
		
		File file = new File(filePath);

		if (file.exists()) {
			fileMap.put(filePath, file);
			return file;
		} 
		
		return null;
		
	}
}
