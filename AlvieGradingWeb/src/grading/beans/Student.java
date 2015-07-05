package grading.beans;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Student {

	private String lastName, firstName;
	private StringProperty grade;
	private ObservableList<ScoreBean> scores;
	private int total;
	private float percentage;
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getGrade(){
		return grade.get();
	}
	
	
	public StringProperty gradeProperty() {
		return grade;
	}
	public void setGrade(String initgrade) {
		grade.set(initgrade);
	}
	public ObservableList<ScoreBean> getScores() {
		return scores;
	}
	public void setScores(ObservableList<ScoreBean> scores) {
		this.scores = scores;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
	
}
