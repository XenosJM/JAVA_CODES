package edu.java.homework;

// 이름 변경 단축키 : Alt + Shift + R

public class MyCircle {
	
	double radius; // 멤버 변수

	public MyCircle() { // 기본 생성자
	
	} // end 기본 생성자
	
	public MyCircle(double radius) { // 매개변수 있는 생성자
		this.radius = radius; // 매개변수(args)
	}
	
	public double calcArea() {
		return 3.14 * radius * radius;
	}
} // end MyCircle
