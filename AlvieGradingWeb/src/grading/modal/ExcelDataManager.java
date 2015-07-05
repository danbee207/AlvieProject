package grading.modal;

import grading.beans.GradingBean;
import grading.beans.Student;

import java.io.InputStream;

import javafx.collections.ObservableList;

public abstract class ExcelDataManager {

	GradingBean grading;
	
	int sheetCn;
	
	public ExcelDataManager(InputStream fis, GradingBean initgrading){
		super();
		
		this.grading = initgrading;
		
	}
	
	public abstract ObservableList<Student> getDataFromSheet();
	
}
