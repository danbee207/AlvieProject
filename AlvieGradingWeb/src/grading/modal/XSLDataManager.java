package grading.modal;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XSLDataManager {

	HSSFWorkbook workbook;

	public XSLDataManager(InputStream fis) throws IOException {
		super();
		this.workbook = new HSSFWorkbook(fis);
	}
	
	
}
