package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable {
	// 멤버(필드) 변수
	private String name;
	private int math;
	private int eng;
	
	// 기본 생성자
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 매개변수 있는 생성자
	public Student(String name, int math, int eng) {
		super();
		this.name = name;
		this.math = math;
		this.eng = eng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void displayInfo() {
		System.out.println("학생 이름 : " + name);
		System.out.println("수학 점수 : " + math);
		System.out.println("영어 점수 : " + eng);
		
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", eng=" + eng + "]";
	}
	
	
	
} // end Student
