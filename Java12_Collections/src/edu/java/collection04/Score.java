package edu.java.collection04;

public class Score {
	// 멤버 변수
	private int math;
	private int eng;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(int math, int eng) {
		super();
		this.math = math;
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	@Override
	public String toString() {
		return "Score [math=" + math + ", eng=" + eng + "]";
	}
	
	
	
} // end Score
