package DDT;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class InsertDataToExcelUsingMap {


	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\Excel1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("sheet1");
		
         LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
	      map.put("10","hydrabad");
		  map.put("20","Banglore");
		  map.put("30","goa");
		  map.put("40","pune");
		   int rowNo=0;
		   for(Entry<String,String>m:map.entrySet())
		   {
			   Row row=sheet.createRow(rowNo++);
			   row.createCell(0).setCellValue((String)m.getKey());
			   row.createCell(1).setCellValue((String) m.getValue());
		   }
		
		 OutputStream fos=new FileOutputStream("./src\\\\test\\\\resources\\\\Excel1.xlsx");
		 book.write(fos);
		 book.close();

	}

}
