package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apachii {
	public static void writeInExcel(String sheetName , int rowIdx , int colIdx ,String data) throws IOException {
		String filePath = "C:\\Users\\2303458\\eclipse-workspace\\hackproject\\testData\\Output.xlsx";
		FileInputStream infile = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(infile);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//XSSFRow row = sheet.createRow(rowIdx);
		XSSFRow row = null;
		if(sheet.getRow(rowIdx)==null) {
			row = sheet.createRow(rowIdx);
		}
		else {
			row = sheet.getRow(rowIdx);
		}
		XSSFCell cell = row.createCell(colIdx);
		cell.setCellValue(data);
	 
		//FileOutputStream outfile = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\Output.xlsx");
		FileOutputStream outfile = new FileOutputStream("C:\\Users\\2303458\\eclipse-workspace\\hackproject\\testData\\Output.xlsx");

		workbook.write(outfile);
		workbook.close();
		infile.close();
		outfile.close();		
	}
	

}
