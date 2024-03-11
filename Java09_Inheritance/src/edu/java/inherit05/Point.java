package edu.java.inherit05;

public class Point {
	
	// 멤버 변수
	double x;
	double y;
	
	// 기본 생성자
	public Point() {
		super();
	}
	
	// 매개변수 생성자
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
	// 즉석 퀴즈)
	// 1. point 클래스 생성
	// - 멤버 변수(double x, double y)
	// - 기본 생성자
	// - 매개변수 생성자
	// - toString()을 오버라이드하여 (x, y)형식의 문자열을 리턴하는 메소드 생성
	// 2. InheritMain의 main() 메소드에서 Point 인스턴스 생성 및 변수 저장
	// 아래와 같이 출력
	// - 예시(1.0, 2.0)
	// - toString() 메소드를 활용
}
