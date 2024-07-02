package DDT;

import java.io.File;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class FetchingDataFromPdf_File {

	public static void main(String[] args) throws Throwable  {
		
		File file=new File("./src\\test\\resources\\ranjana1.docx");
		 PDDocument doc=PDDocument.load(file);

		 int pages=doc.getNumberOfPages();
		 System.out.println(pages);
		 
		 PDFTextStripper pdfData=new PDFTextStripper();
	    String Data=pdfData.getText(doc);
		 System.out.println(Data);
		 
		 
	pdfData.setStartPage(4);
	String pageData=pdfData.getText(doc);
	System.out.println(pageData);
	}

}
