package edu.java.collection04;

public class Student {
	// 멤버 변수
	private String name;
	private Score score;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Score score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	
	
} // end Student
