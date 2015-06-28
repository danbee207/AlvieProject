package grading.beans;

import java.util.ArrayList;

public class GradingBean {

	private float gradingTotal;
	private ArrayList<String> gradingList;
	private ArrayList<Float> gradingPercentage; 			// Each kinds percentage (i.e Quiz 3 : 5%) 
	private ArrayList<Float> gradingStandard;				// A B C D F
	
	public float getGradingTotal() {
		return gradingTotal;
	}
	public void setGradingTotal(float gradingTotal) {
		this.gradingTotal = gradingTotal;
	}

	public ArrayList<Float> getGradingStandard() {
		return gradingStandard;
	}
	public void setGradingStandard(ArrayList<Float> gradingStandard) {
		this.gradingStandard = gradingStandard;
	}
	public ArrayList<Float> getGradingPercentage() {
		return gradingPercentage;
	}
	public void setGradingPercentage(ArrayList<Float> gradingPercentage) {
		this.gradingPercentage = gradingPercentage;
	}
	public ArrayList<String> getGradingList() {
		return gradingList;
	}
	public void setGradingList(ArrayList<String> gradingList) {
		this.gradingList = gradingList;
	}
	
	
	
}
