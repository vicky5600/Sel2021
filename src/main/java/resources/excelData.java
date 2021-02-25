package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelData{
	
	@Test
	public ArrayList<String> dataDriven(String testCase) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/ExcelDataSheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int sheetSize = workBook.getNumberOfSheets();
		for(int i=0;i<sheetSize;i++)
		{
			if(workBook.getSheetName(i).equalsIgnoreCase("Ecommerce"))
			{
				XSSFSheet workSheet = workBook.getSheetAt(i);
				Iterator<Row> rows = workSheet.iterator();
				Row row = rows.next();
				Iterator<Cell> cells =  row.cellIterator();
			//	Cell cell = cells.next();
				int k=0;
				int column = 0;
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					if(cell.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					Row ro = rows.next();
					if(ro.getCell(column).getStringCellValue().equalsIgnoreCase(testCase))
					{
						Iterator<Cell> cl = ro.cellIterator();
						while(cl.hasNext())
						{
							a.add(cl.next().getStringCellValue());
						}
					}
				}
			}
		}
		return a;
	}

}
