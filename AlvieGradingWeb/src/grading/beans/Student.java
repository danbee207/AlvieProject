package grading.beans;

import java.util.ArrayList;

public class Student {

	private String lastName, firstName;
	private char grade;
	private ArrayList<Float> scores;
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
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public ArrayList<Float> getScores() {
		return scores;
	}
	public void setScores(ArrayList<Float> scores) {
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
