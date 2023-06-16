package vtiger.Practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("browser");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organizations", 1, 2);
		System.out.println(data);
		
//	    eUtil.writeDataIntoExcel("Trail", 3, 4, "Spiderman");
//	    System.out.println("Data Added");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemInFormat());
		
		
	}

}
