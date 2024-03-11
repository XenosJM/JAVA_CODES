package edu.java.homework;

import java.io.Serializable;

public class Student2 implements Serializable {
	// 멤버(필드) 변수
	private String name;
	private int math;
	private int eng;
	
	
	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student2(String name, int math, int eng) {
		super();
		this.name = name;
		this.math = math;
		this.eng = eng;
	}
	
	public void displayInfo() {
		System.out.println("학생 이름 : " + name);
		System.out.println("수학 점수 : " + math);
		System.out.println("영어 점수 : " + eng);
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
	
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", math=" + math + ", eng=" + eng + "]";
	}
	
	
	
}

//	1. Student 클래스를 생성
//	- 이름, 수학, 영어 멤버 변수 생성
//	- 매개변수가 있는 생성자 생성
//	- displayInfo() 함수 만들어서 위의 변수의 값을 출력
//	- implements Serializable로 파일 객체로 사용 가능하게