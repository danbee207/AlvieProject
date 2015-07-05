package grading.modal;

import grading.beans.GradingBean;
import grading.beans.ScoreBean;
import grading.beans.Student;

import java.io.IOException;
import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * 
 * data Analysis for Excel version(.xsls)
 * 
 */
public class NewExcelDataManager extends ExcelDataManager {
	
	XSSFWorkbook workbook;
	
	XSSFRow row;
	XSSFCell cell;
	
	
		
	public NewExcelDataManager(InputStream fis, GradingBean initgrading) throws IOException {
		super(fis,initgrading);
		this.workbook = new XSSFWorkbook(fis);
		
		sheetCn = workbook.getNumberOfSheets();
	}

	/**
	 * make DATA STRUCTURE FROM EXCEL SHEET(.XSLX)
	 * 
	 */

	@Override
	public ObservableList<Student> getDataFromSheet() {
		// TODO Auto-generated method stub
		ObservableList<Student> data = FXCollections.observableArrayList();
		
		for(int i=0;i<sheetCn;i++){
			XSSFSheet sheet = workbook.getSheetAt(i);
			
			int rows = sheet.getPhysicalNumberOfRows();
			
			grading.setStudentNum(rows);
			setGradingList(sheet);
			for(int j=1;j<rows;j++){
				row = sheet.getRow(j);
				if(row!=null){
					int cells = row.getPhysicalNumberOfCells();
					Student student = new Student();
					for(int cnCell=0; cnCell < cells; cnCell++){
						cell = row.getCell(cnCell);
						if(cell !=null){
							if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC || cell.getCellType()==XSSFCell.CELL_TYPE_BLANK ){
								ScoreBean score = new ScoreBean();
								score.setScoreName(grading.getGradingList().get(cnCell-2));
								if(cell.getCellType()==XSSFCell.CELL_TYPE_BLANK)
									score.setScore(0);
								else
									score.setScore(cell.getNumericCellValue());
								
							}else if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING){			//name
								
								switch(cnCell){
								case 0 : student.setLastName(cell.getStringCellValue()); break;	//last
								case 1 : student.setFirstName(cell.getStringCellValue()); break;//frist
								default : if(cnCell==grading.getGradingList().size()) student.setGrade(cell.getStringCellValue()); //grade
								}
								
								
							}
						}
					}
				}
			}
			
		}
		
		
		return data;
	}
	
	
	private void setGradingList(XSSFSheet sheet){
		
		row = sheet.getRow(0);
		
		int cells = row.getPhysicalNumberOfCells();
		
		ObservableList<String> gradingList= FXCollections.observableArrayList();
		
		for(int i=2;i<cells;i++){
			cell = row.getCell(i);
			if(cell!=null || cell.getCellType()==XSSFCell.CELL_TYPE_STRING){
				gradingList.add(cell.getStringCellValue());
			}
		}
		
		if(grading.getGradingList()==null)
			grading.setGradingList(gradingList);
		
		
		return;
	}
	
	




	
}
