package DataDriven_MSexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Writing {
	
	public static void main (String[] args) throws FileNotFoundException, IOException {
		
		
		//Excel file-->Workbook-->Sheets-->Row-->Cells
		
		/*
		Excel file -->Reading-->FileInputStream
		   		   -->Writing-->FileOutputStream
		Workbook-->XSSFWorkbook
		Sheets-->XSSFSheet
		Row-->XSSFRow
		Cells-->XSSFCell
		*/
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/testdata/Employee_Sample_Data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet("Data");
		int numberOfRows= sheet.getLastRowNum();
		int numberOfCells = sheet.getRow(numberOfRows).getLastCellNum();
		
		System.out.println("Total number of rows: " + numberOfRows);
		System.out.println("Total number of cells: " + numberOfCells);
		
		
		for(int i=0;i<=numberOfRows;i++)
		{

			XSSFRow Rows=sheet.getRow(i);
			
			for(int j=0;j<numberOfCells;j++)
			{
				XSSFCell Cells =Rows.getCell(j);
				System.out.print(Cells.toString()+ "\t");
			}
			
			System.out.println();
		}
		
		
		workbook.close();
		file.close();
	}

}
