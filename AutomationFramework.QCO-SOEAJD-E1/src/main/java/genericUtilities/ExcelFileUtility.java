package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method consists of generic methods related to excel sheet.
 * @author Manoj
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel and return the value to caller.
	 * @param sheet
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheet, int rowNo, int celNo) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
		
	}
	/**
	 * This method will write data into Excel.
	 * @param sheet
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String sheet, int rowNo, int celNo, String value) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(rowNo).createCell(celNo).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method will read multiple datafrom excel and has to given to data provider.
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for (int i = 0; i < lastRow; i++) 
		{
			for (int j = 0; j < lastCel; j++)
			{
				data[i][j]  = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;
	}

}
