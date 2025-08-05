package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	

	public static List<HashMap<String, String>> data(String filepath, String sheetName) throws IOException 
	 {
		
		List<HashMap<String, String>> mydata = new ArrayList<>();      
		
		
		    //opening the file in reading mode
			FileInputStream file = new FileInputStream(filepath);
			
			//opening the workbook
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			//getting the sheet
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			//get the total number of rows present
			int totalRows=sheet.getLastRowNum();
			
			//getting the first row that will be our header or key for every record
			 XSSFRow headerRow=sheet.getRow(0);
			
			
			for (int i = 1; i <= totalRows; i++) 
				{
				//getting the current row
				XSSFRow currentRow = sheet.getRow(i);
				
				
				//this  will be individual hash
				HashMap<String, String> currentHash = new HashMap<String, String>();
				
				for (int j = 0; j < currentRow.getLastCellNum(); j++) 
					{
					//getting the current cell
					XSSFCell currentCell = currentRow.getCell(j); 
					
					//Adding the rows in current hash map
					currentHash.put(headerRow.getCell(j).toString(), currentCell.toString());
				 }
				
				//one row adding to the list
				mydata.add(currentHash);
				}
			
			//closing the workbook
			workbook.close();
			
			//closing the file
			file.close();
			
		return mydata;
	}
}
