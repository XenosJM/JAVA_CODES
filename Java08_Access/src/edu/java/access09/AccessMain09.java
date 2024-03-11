package edu.java.access09;

// * static : 멤버 변수 또는 메소드를 선언(정의)할 때 사용
// - 인스턴스 생성 이전에 프로그램이 처음 시작될 때 static 메모리 영역에 자동으로 생성
//	 인스턴스 - new로 선언할 때 메모리에 생성 - garbage collector가 관리.
//	 static - 프로그램이 처음 실행될 때 메모리에 생성 - garbage collector가 관리하지 않음.

// * 클래스 멤버 변수(static 변수) : static으로 선언한 멤버 변수
// - 인스턴스를 생성하지 않아도 사용 가능
// - static 변수는 메소드 영역에 생성된 공간에서 공유됨
// - 모든 인스턴스들이 공유하기 때문에 값의 변경에 대해서 주의해야 함!
//		ㄴ 
// - 사용 형식 : 
//		클래스이름.변수이름

// * 인스턴스 멤버 변수 : static이 선언되지 않은 멤버 변수
// - 인스턴스를 생성한 후에만 사용할 수 있는 변수
// - 사용 형식 :
//		Any 참조변수 = new Any();
//		참조변수.변수이름

// * 클래스 메소드(static 메소드) : static으로 선언한 메소드
// - 인스턴스를 생성하지 않아도 사용 가능한 메소드
// - 사용 형식 : 
//		클래스이름.메소드()

// * 인스턴스 메소드 : static으로 선언되지 않은 메소드
// - 인스턴스를 생성한 후에만 사용할 수 있는 메소드
// - 사용 형식 : 
//		Any 참조변수 = new Any();
//		참조변수.메소드()

public class AccessMain09 {

	public static void main(String[] args) {
		// static 멤버 변수 - 인스턴스 생성 없이 사용 가능
		// static으로 선언 된 값은 프로그램이 종료될때 까지 사용되기 때문에 
		// 원치 않는 결과값이 나올수 있으므로 주의해야한다.
		TestStatic.num2 = 123;
		System.out.println(TestStatic.num2);
		
		// 인스턴스 멤버 변수 - 인스턴스 생성 해야만 사용 가능
		// 1회용으로 사용 되고 버려짐
		TestStatic test = new TestStatic();
		test.num1 = 100;
		System.out.println(test.num1);
		
		// static 메소드 - 인스턴스 생성 없이 사용 가능
		TestStatic.display2();
		
		test.display1();
		
		
	} // end main()

} // end AccessMain09








