package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	private Properties properite;
	private FileInputStream inputFile;

	public PropertyFile(String filePath) {

		properite = new Properties();

		try {
			inputFile = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("The File Not Exists");
			e.printStackTrace();

		}
		try {
			properite.load(inputFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			inputFile.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getValue(String key) {
		if (properite.containsKey(key)) {
			String value = properite.getProperty(key);
			return value.trim();
		} else {
			return "";
		}
	}

}
