package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingDataToExcelUsingMap1 {

	public static void main(String[] args) throws Throwable, IOException {
		

		FileInputStream fis=new FileInputStream("./src\\test\\resources\\ExcelTest.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("sheet1");
		
         LinkedHashMap<Integer, String> map=new LinkedHashMap<Integer,String>();
	      map.put(1,"hydrabad");
		  map.put(2,"Banglore");
		  map.put(3,"goa");
		  map.put(4,"pune");
		   int rowNo=0;
		   for(Entry<Integer,String>m:map.entrySet())
		   {
			   Row row=sheet.createRow(rowNo++);
			   row.createCell(0).setCellValue((Integer)m.getKey());
			   row.createCell(1).setCellValue((String) m.getValue());
		   }
		
		 OutputStream fos=new FileOutputStream("./src\\\\test\\\\resources\\\\ExcelTest.xlsx");
		 book.write(fos);
		 book.close();

	}

}

