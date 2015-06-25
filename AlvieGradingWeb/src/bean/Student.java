package bean;

import java.util.ArrayList;

public class Student {

	private String name;
	private char grade;
	private ArrayList<Float> scores;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
}
