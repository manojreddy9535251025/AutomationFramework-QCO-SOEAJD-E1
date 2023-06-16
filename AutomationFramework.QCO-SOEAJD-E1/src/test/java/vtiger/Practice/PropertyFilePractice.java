package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	public static void main(String[] args) throws IOException {
		
		// Step 1: Open the file in java readble format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		
		// Step 2: create object of properties class from java.util
		Properties pobj = new Properties();
		
		// Step 3: Load the file into properties
		pobj.load(fis);
		
		//Step 4: Give the key and Read the value
		String value = pobj.getProperty("browser");
		System.out.println(value);
		
		String value1 = pobj.getProperty("password");
		System.out.println(value1);
		
	}
}
