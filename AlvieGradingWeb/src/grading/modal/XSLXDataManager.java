package grading.modal;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSLXDataManager {
	
	XSSFWorkbook workbook;
	
		
	public XSLXDataManager(InputStream fis) throws IOException {
		super();
		this.workbook = new XSSFWorkbook(fis);
	}




	
}
