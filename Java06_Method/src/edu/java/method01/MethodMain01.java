package edu.java.method01;

// 메소드 : 기능을 수행하기 위한 코드. 주로 *반복적으로 기능을 수행할 때* 생성
// - 메소드는 클래스 안에서, 그리고 다른 메소드 외부에서 만든다.
// - (주의) 메소드 안에 또 다른 메소드를 만들 수 없음
// - 이름을 쉽게 직관적으로 알수있게 지어야 쓰기 좋다.
// - 메소드 정의 :
//		[수식어] 리턴타입 메소드이름 ([매개변수1, 매개변수2, ...]) {본문}
//		수식어 종류 : public, private, static, ... - public 생략 가능
//		리턴타입 : 자료타입(int, double, String, class, ...), void(없음)
//		매개변수 : 함수 호출시 전달되는 데이터를 저장하는 변수
//				 전달받는 데이터가 없으면 매개변수 선언 생략 가능
//		{ 본문 } : 메소드 본체(body). 수행해야 할 기능을 작성


public class MethodMain01 {
	// 메소드 생성
	public static void sayHello(String name) { // String name : 매개변수(파라미터, 받는애)
		System.out.println("안녕하세요~");
		System.out.println("저는 " + name + "입니다.");		
	} // end sayHello()
	
	public static void sayAge(int age) { // int age : 매개변수
		System.out.println("제 나이는 " + age + "입니다.");
	} // end sayAge()
	
	// static 수식어 : 프로그랭이 실행될 때 생성하도록 선언하는 키워드
	// static 메소드에서는 static으로 선언된 메소드만 호출 가능
	public static void main(String[] args) {
		 System.out.println("저는 컴퓨터입니다,");
		 System.out.println("저는 스마트폰 입니다.");
		 
		 sayHello("박정민");	// 메소드 호출. 인자값(넘겨주는애)으로 "박정민"을 넘겨줌
		 
		 sayAge(28);
		 
	} // end main()

} // end MethodMain01()




