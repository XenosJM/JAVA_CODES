package edu.java.inherit05;


// 모든 자바 클래스는 무적권 Object의 자손이다.
public class InheritMain05 {

	public static void main(String[] args) {
		System.out.println("오버라이드(override) 연습");
		
		Person p1 = new Person("둘리");
		System.out.println(p1);
		// toString() : 객체가 가지고 있는 정보를 문자열로 출력
		// Object 클래스의 toString은 모든 클래스에서 사용 가능
		// p1과 p1.toString()은 같은 결과를 출력
		
		String str = new String("문자열");
		System.out.println(str.toString());
		
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
		
		Point p = new Point(2.0, 3.0);
		System.out.println(p);
		
	} // end main()

} // end InheritMain05










