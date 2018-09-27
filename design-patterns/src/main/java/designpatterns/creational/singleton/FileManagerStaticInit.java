package designpatterns.creational.singleton;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class FileManagerStaticInit {

	private static final FileManagerStaticInit singleton;

	static {
		singleton = new FileManagerStaticInit();
	}
	

	private final Map<String, File> fileMap = new HashMap<>();

	private FileManagerStaticInit() {
		System.out.println("Creating FileManagerStaticInit singleton.");
	}

	public static FileManagerStaticInit getInstance() {
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
