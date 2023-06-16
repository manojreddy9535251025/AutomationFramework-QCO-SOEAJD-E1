package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws IOException {
		
		// Step 1: Load file location into File Input Stream
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//step 2 : create a workbook factory
		Workbook wb = WorkbookFactory.create(fise);
		
		//step 3 : get control  of sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//step 4 : get control  of Row
		Row rw = sh.getRow(4);
		
		//step 5 : get control  of Cell
		 Cell ce = rw.getCell(2);
		
		//step 6 : caprture the information inside the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		
	}

}
