package grading.modal;

import grading.beans.*;

import java.io.IOException;
import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 *   data analysis for excel version(.xsl) 
 * @written by Dan B
 */
public class OldExcelDataManager extends ExcelDataManager {

	HSSFWorkbook workbook;

	HSSFRow row;
	HSSFCell cell;

	public OldExcelDataManager(InputStream fis, GradingBean initgrading)
			throws IOException {
		super(fis, initgrading);
		// TODO Auto-generated constructor stub
		this.workbook = new HSSFWorkbook(fis);
		sheetCn = workbook.getNumberOfSheets();

	}

	@Override
	public ObservableList<Student> getDataFromSheet() {
		// TODO Auto-generated method stub

		ObservableList<Student> data = FXCollections.observableArrayList();

		for (int i = 0; i < sheetCn; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);

			int rows = sheet.getPhysicalNumberOfRows();

			grading.setStudentNum(rows);
			setGradingList(sheet);
			for (int j = 1; j < rows; j++) {
				row = sheet.getRow(j);
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					Student student = new Student();
					for (int cnCell = 0; cnCell < cells; cnCell++) {
						cell = row.getCell(cnCell);
						if (cell != null) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC
									|| cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) { // scores
								ScoreBean score = new ScoreBean();
								score.setScoreName(grading.getGradingList()
										.get(cnCell - 2));
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									score.setScore(0);
								} else {
									score.setScore(cell.getNumericCellValue());
								}
							} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) { // name
								if (cnCell == 0) {
									student.setLastName(cell
											.getStringCellValue());
								} else if (cnCell == 1) {
									student.setFirstName(cell
											.getStringCellValue());
								} else if (cnCell == grading.getGradingList()
										.size()) { // grade
									student.setGrade(cell.getStringCellValue());
								}
							}
						}
					} // cell
					data.add(student);
				}
			} // rows

		} // sheet

		return data;
	}

	// number of sheet

	/**
	 * make Data STRUCTURE FROM EXCEL SHEET(.XSL)
	 * 
	 * @return
	 */

	/*
	 * disseminate name tag for each score
	 */
	private void setGradingList(HSSFSheet sheet) {

		row = sheet.getRow(0);
		int cells = row.getPhysicalNumberOfCells();

		ObservableList<String> gradingList = FXCollections
				.observableArrayList();
		for (int i = 2; i < cells; i++) {

			cell = row.getCell(i);

			if (cell != null || cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				if (cell.getStringCellValue().toUpperCase().equals("GRADE"))
					break;
				gradingList.add(cell.getStringCellValue());
			}

		}

		if (grading.getGradingList() == null)
			grading.setGradingList(gradingList);

		return;
	}

}
