package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		//step1:- path connections
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\ExcelTest.xlsx");
		
		//step2:-open workbook in read mode
		Workbook book=WorkbookFactory.create(fis);
		
		//step3:- get the control of the sheet
		Sheet sheet=book.getSheet("sheet1");
		
		Row row=sheet.createRow(5);
		
		Cell cell=row.createCell(5);
		
		cell.setCellValue("123456");

		 OutputStream fos=new FileOutputStream("./src\\\\test\\\\resources\\\\ExcelTest.xlsx");
		 book.write(fos);
		 book.close();
		 System.out.println(book);
	}

}
