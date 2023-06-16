package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws IOException {
		
		// Step 1: Open the file in java Readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		// Step 2 : Create a workbook Factory
		Workbook wb = WorkbookFactory.create(fise);
		
		// Step 3 : get control of sheet
		Sheet sh = wb.getSheet("Organizations");
		
		// Step 4 : get control of Row
		Row rw = sh.createRow(6);
		
		// Step 5: get control of cell
		Cell ce = rw.createCell(4);
		
		// step 6 : set the cell value
		ce.setCellValue("Manoj");
		
		// Step 7 : open the file in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//Step 8 : Write the data into file
		wb.write(fos);
		System.out.println("Data Written");
		wb.close();
		
	}

}
