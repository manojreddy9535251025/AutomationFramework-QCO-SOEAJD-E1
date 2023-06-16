package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void sampleDataTest(String name, String model,int qty)
	{
		System.out.println(name+" <-> "+model+" <-> "+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[4][3];
		
		data[0][0] = "Samsung";
		data[0][1] = "A50";
		data[0][2] =  10;
		
		data[1][0] = "Redmi";
		data[1][1] = "Note8";
		data[1][2] = 15;
		
		data[2][0] = "Vivo";
		data[2][1] = "V20";
		data[2][2] = 20;
	
		data[3][0] = "Nokia";
		data[3][1] = "1100";
		data[3][2] = 25;
				
		return data;	
	}

}
