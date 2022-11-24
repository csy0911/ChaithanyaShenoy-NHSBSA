package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	private static int Row=0;
	private static int Col=0;
	private static String Path = "./Resources/DataSheet/NHSCostCheckerTestData.xls";
	private static String auditDataPath = "./Resources/AuditResults/NHSCostCheckerResults.xls";
	
	public static HashMap<String, String> ExcelDataRead(String SheetName, String TestData) throws Exception
	{
		
		// Read Excel	
		FileInputStream fis = new FileInputStream(Path);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet worksheet = workbook.getSheet(SheetName);
		
		int RowCount=worksheet.getPhysicalNumberOfRows();
		int ColCount = worksheet.getRow(0).getPhysicalNumberOfCells();

		
// To get number of rows present before EOF		
		for (int i=0;i<=RowCount;i++)
		{
			if (worksheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("EOS"))
			{
				Row=i;
				break;
			}
		}
		
		
// To get the column number to read the test data from excel		
		for (int i=0;i<=ColCount;i++)
		{
			if(worksheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(TestData))
			{
				Col=i;
				//System.out.println("Which Column data needs to be picked: "+ Col);
				break;
			}
		}
	
	
// To insert the excel values to HasMap	for required test data column	
		
		 HashMap<String, String> TestDataRead = new HashMap<String, String>();
		
			
		for (int i=0; i<=Row; i++)
		{
			Cell cell=worksheet.getRow(i).getCell(Col);
			
			switch(cell.getCellType()){
			
			case STRING:
			TestDataRead.put(worksheet.getRow(i).getCell(0).getStringCellValue(), 
					         worksheet.getRow(i).getCell(Col).getStringCellValue());
			break;
			
			case NUMERIC:
			TestDataRead.put(worksheet.getRow(i).getCell(0).getStringCellValue(),
					      String.valueOf(worksheet.getRow(i).getCell(Col).getNumericCellValue()));
			break;
			
			case BOOLEAN:
			TestDataRead.put(worksheet.getRow(i).getCell(0).getStringCellValue(),
				      String.valueOf(worksheet.getRow(i).getCell(Col).getBooleanCellValue()));
		    break;
			
			}
						
		}
				
		//System.out.println("Value from HashMap: " + TestDataRead.get("Username"));
		
		fis.close();
		workbook.close();
		
		return TestDataRead;
		
		
	}
	
	
	public static void auditTestExcel(ArrayList<String> resultOutputList) throws IOException
	{
		
		// To Excel	
		FileOutputStream fos = new FileOutputStream(auditDataPath);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("NHSCostCheckerResults");
		
		HSSFRow header = worksheet.createRow(0);
		
		for(int i=0;i<resultOutputList.size();i++)
		{
			header.createCell(i).setCellValue(resultOutputList.get(i));
		}
		
		workbook.write(fos);
		fos.close();
		workbook.close();
		
	}
	

}
