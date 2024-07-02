package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable, Throwable {
		
		//step1:- path connections
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\ExcelTest.xlsx");
		
		//step2:-open workbook in read mode
		Workbook book=WorkbookFactory.create(fis);
		
		//step3:- get the control of the sheet
		Sheet sheet=book.getSheet("sheet1");
		
		//step4:- get control of the row
		Row row=sheet.getRow(0);
		
		
		//step5:- get control of the cell
		Cell cell=row.getCell(0);
		
		
		String ExcelData=cell.getStringCellValue();
		System.out.println(ExcelData);
		
		

	}

}
