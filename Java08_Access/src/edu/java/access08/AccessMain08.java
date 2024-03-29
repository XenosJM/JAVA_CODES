package edu.java.access08;

import java.util.Scanner;

// * Java Runtime Environment(JRE)
// - Java 애플리케이션을 생성하고 실행하기 위한 구성 요소
// - JRE는 Java 개발 도구(Java Development Kit, JDK)의 일부
// - 운영체제와 Java 프로그램 사이에서 조정 역할을 수행

// * JVM(Java Virtual Machine) 
// - Java 바이트 코드를 실행하는 주체(소프트웨어)
// - 특정 공간을 할당하여 '메모리' 관리

// * JVM이 관리하는 메모리 영역 : // 한꺼번에 저장 하면 필요 없어진 메모리 공간을 정리하기 불편하므로 공간을 나눠서 저장 관리 한다.
// - Stack(스택) : 지역 변수들이 저장되는 메모리 영역
// - Heap(힙) : 인스턴스(참조 자료형)가 저장되는 메모리 영역 - 예) new로 선언될 때 생성됨
// - Method(메소드) : Static으로 선언한 변수, 메소드의 실행 코드들이 저장되는 메모리 영역 
//		ㄴ static으로 선언된 변수, 메소드들은 미리 생성된다. static으로 선언되면 계속 인지(사용)이 되고 있어서
//		ㄴ 잠깐 쓰고 버리는 값도 버려지지 못하고 계속 메모리 영역을 차지한다. 즉 메모리가 무거워진다.
//		ㄴ static은 가장 먼저 불러와진다. 언제든 불러올 수 있다. 종료될때까지 유지된다. 그래서 필수 또는 자주 사용하는 값을 선언.

// * final 제한자 
// - '초기화된 값을 바꿀 수 없음.'
// - final : 최종적인, 변경할 수 없는
// - final + 멤버 변수, 지역 변수 : 상수(한 번 초기화된 값을 변경할 수 없는 변수)
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스

public class AccessMain08 {
	public static final int MENU_INSERT = 1; 
	public static final int MENU_DELETE = 2;
	public static int test = 100;

	public static void main(String[] args) {
		String str = "test";
		// "test"는 힙 영역에 메모리를 차지
		// str에는 주소값이 저장
		str = "garbage"; // str에 "garbage"의 주소값이 저장
		// "test"는 힙 영역에서 삭제되지 않음
		// 이러한 객체를쓰레기 값이라고 하며,
		// 자바는 Garbage Collector를 이용하여 쓰레기 값을 자동으로 제거
		
		// 멤버 변수 : 클래스 단계에서 선언된 변수
		// 지역 변수 : 메소드나 특정 위치에 포함된 곳에서 선언된 변수
		// - 지역 변수의 이름은 멤버 변수와 동일하게 선언되면 안됨
		int x = 10; // - 지역 변수
		test = 20; // 멤버 변수 초기화
		
//		MENU_INSERT = 2; // final 변수는 초기화된 값을 변경할 수 없음
		
		System.out.println("1. 등록 2. 삭제");
		System.out.println("메뉴 선택>");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
		switch(select) {
		case MENU_INSERT:
			System.out.println("등록");
			break;
		case MENU_DELETE:
			System.out.println("삭제");
			break;
		}
		
		if(select == MENU_INSERT) {
			System.out.println("추가 기능");
		}
		
		
		
	} // end main()

} // end AccessMain08








