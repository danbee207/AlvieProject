package grading.beans;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class GradingBean {

	private int studentNum;
	private float gradingTotal;
	private ObservableList<String> gradingList;
	private ObservableList<Float> gradingPercentage; 			// Each kinds percentage (i.e Quiz 3 : 5%) 
	private ObservableList<Float> gradingStandard;				// A B C D F
	
	public float getGradingTotal() {
		return gradingTotal;
	}
	public void setGradingTotal(float gradingTotal) {
		this.gradingTotal = gradingTotal;
	}
	public ObservableList<String> getGradingList() {
		return gradingList;
	}
	public void setGradingList(ObservableList<String> gradingList) {
		this.gradingList = gradingList;
	}
	public ObservableList<Float> getGradingPercentage() {
		return gradingPercentage;
	}
	public void setGradingPercentage(ObservableList<Float> gradingPercentage) {
		this.gradingPercentage = gradingPercentage;
	}
	public ObservableList<Float> getGradingStandard() {
		return gradingStandard;
	}
	public void setGradingStandard(ObservableList<Float> gradingStandard) {
		this.gradingStandard = gradingStandard;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	
	
	
	
}
