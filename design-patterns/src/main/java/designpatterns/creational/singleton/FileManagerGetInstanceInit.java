package designpatterns.creational.singleton;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class FileManagerGetInstanceInit {

	private static FileManagerGetInstanceInit singleton;

	private final String commonPrefix;
	private final Map<String, File> fileMap = new HashMap<>();

	private FileManagerGetInstanceInit(String commonPrefix) {
		this.commonPrefix = commonPrefix;
		System.out.println("Creating FileManagerGetInstanceInit singleton.");
	}

	public static FileManagerGetInstanceInit getInstance(String commonPrefix) {
		if(singleton == null)
			singleton = new FileManagerGetInstanceInit(commonPrefix);
				
		return singleton;
	}
	
	public File getFile(String filePath) {
		
		String prefixedFilePath = commonPrefix + filePath;
		
		File cachedFile = fileMap.get(prefixedFilePath);
		
		if(cachedFile != null)
		{
			return cachedFile;
		}
		
		File file = new File(prefixedFilePath);

		if (file.exists()) {
			fileMap.put(prefixedFilePath, file);
			return file;
		} 
		
		return null;
		
	}
}
