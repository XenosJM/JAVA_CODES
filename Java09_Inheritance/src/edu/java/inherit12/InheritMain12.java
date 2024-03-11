package edu.java.inherit12;

// abstract : 추상적인, 실체가 없는

// abstract 메소드(추상 메소드) : // 구현 강제화
// - 메소드의 원형(prototype : 리턴타입, 이름, 매개변수)만 선언하고
//	 메소드의 본체(body : {}를 구현하지 않는 메소드
// - {...}이 없음
// - 선언 타입
//	 abstract 리턴타입 메소드이름(매개변수1, 매개변수2, ...);

// abstract 클래스(추상 클래스)
// - 추상 메소드를 하나라도 가지고 있는 클래스
// - 선언 타입
//	 abstract class 클래스이름 {...}
// - 추상 클래스는 인스턴스를 생성할 수 없음(생성자를 호출할 수 없음)
// - 상속받는 클래스에서 메소드를 override하면 인스턴스를 생성할 수 있음

abstract class TestAbstract { // 부모의 역할(독립적인 사용x)
	public abstract void hello();
} // end TestAbstract

class TestChild extends TestAbstract { 

	@Override
	public void hello() {}
	
}

public class InheritMain12 {

	public static void main(String[] args) {
		
	} // end main()

} // end InheritMain12
