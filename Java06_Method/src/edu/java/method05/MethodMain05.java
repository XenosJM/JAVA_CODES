package edu.java.method05;

// 메소드 overloading
// 1. 매개변수의 개수가 다르거나
// 2. 매개변수의 타입이 다른 경우
// 같은 이름으로 정의할 수 있음
// (주의) 메소드의 리턴 타입만 다른 경우는 같은 이름으로 메소드를 정의할 수 없음
// 예) 같은 이름의 


public class MethodMain05 {

	public static void main(String[] args) {
		System.out.println();	
		System.out.println("문자열");
		System.err.println(1);
		System.out.println(1.0);
		System.out.println(true);
		
		sayHello("박정민");
		
	} // end main()
	
	public static void sayHello() { // 메소드 생성
		System.out.println("안녕하세요.");
	} // end sayHello()
	// 위와 아래 메소드는 이름이 같지만 타입이 다르기 때문에 메소드 정의가가능하다.
	public static void sayHello(String name) {
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 " + name + "입니다.");
	} // end sayHello()
	
	

} // end MethodMain05




