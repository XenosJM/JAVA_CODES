package edu.java.today;

public class 오늘수업정리0207 {
/**2024 / 02 / 07
 * 
 * 오늘의 수업은 메소드(method)에 관해 배움
 * 메소드란?
 * 메소드 : 기능을 수행하기 위한 코드. 주로 *반복적으로 기능을 수행할 때* 생성
   - 메소드는 클래스 안에서, 그리고 다른 메소드 외부에서 만든다.
   - (주의) 메소드 안에 또 다른 메소드를 만들 수 없음
   - 이름을 쉽게 직관적으로 알수있게 지어야 쓰기 좋다.
   ㄴ 혼자서'만' 코딩을 할거라면 신경쓸 필요가 없겠지만 팀단위로 할때는 모두가 알아보기쉬운 이름으로 만들어야한다.
   
   - 메소드 정의 :
		[수식어] 리턴타입 메소드이름 ([매개변수1, 매개변수2, ...]) {본문} 
		수식어 종류 : public, private, static, ... - public 생략 가능	
		// static 수식어 : 프로그램이 실행될 때 생성하도록 선언하는 키워드
		// static 메소드에서는 static으로 선언된 메소드만 호출 가능
		 * ㄴ static은 클래스 자체에 속한 메소드라고 선언하기 때문.
		리턴타입 : 자료타입(int, double, String, class, ...), void(없음)
		매개변수 : 함수 호출시 전달되는 데이터를 저장하는 변수
                 전달받는 데이터가 없으면 매개변수 선언 생략 가능
	    { 본문 } : 메소드 본체(body). 수행해야 할 기능을 작성
	    
	    배열을 변수로 사용하는 메소드를 다룰때는 배열의 위치 즉 주소값을 저장하고?
	    // 참조 변수 : 주 코드의 변화를 다른 코드들이 인식하는 변수
		// 주소값(위치값)이 같으면 같은 객체이다.
		 * 일반적으로 메소드를 불러오면 변수 선언 -> 공간 생성 -> 주소값 존재 하게 된다.
		 * 
	     
	     
	     
	     연습용으로 만들어본 메소드들 강사님이 메소드를 만들기에 앞서 어떤식으로 만들지
	     글로 정리한후 따라서 만들어본 메소드들
	     
	    // 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
		// 메소드 이름 : add
		// 리턴타입 : int
		// 매개변수 : int x, int y
		
	public static int add(int x, int y) {
		int result = x + y;
		return result; // == return x + y; 상황에 따라 다르게... 
	} // end add()
	
	
		// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 차를 리턴
		// 메소드 이름 : sub
		// 리턴타입 : int
		// 매개변수 : int x, int y
		
	public static int sub(int x, int y) {
		return x - y;
	//		return Math.abs(x - y); // 절대값
	} // end sub()
	
		// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
		// 메소드 이름 : mul
		// 리턴타입 : double
		// 매개변수 : double x, double y
	
	public static double mul(double x, double y) { 
		return x * y;
	} // end mul()
	
		// 기능 : 두 개의 실수를 매개변수로 전달받아서 x를 y로 나눈 값을 리턴
		// 메소드 이름 : div
		// 리턴타입 : double
		// 매개변수 : double x, double y
	
	public static double div(double x, double y) {
		return x / y;
	}
	
	====== 아래는 직접 메소드를 불러와서 매개변수를 선언하고 실행해본 결과물
	
	public static void main(String[] args) {
	    // 두 숫자를 더한 결과를 변수에 저장하고, 그 값을 출력합니다.
	    int result = add(10, 20);
	    System.out.println(result);
	    
	    // 두 숫자를 더한 결과를 직접 출력합니다.
	    System.out.println(add(10, 20));  
	    
	    // 두 숫자를 빼고 그 결과를 변수에 저장하고, 그 값을 출력합니다.
	    result = sub(20, 10);
	    System.out.println(result);
	    
	    // 두 숫자를 곱한 결과를 변수에 저장하고, 그 값을 출력합니다.
	    double m = mul(1.5, 2.0);
	    System.out.println("m = " + m);
	    
	    // 두 숫자를 나눈 결과를 변수에 저장하고, 그 값을 출력합니다.
	    // 정수를 정수로 나누어서 결과를 반환하므로 자동 형 변환 가능성을 염두합니다.
	    double d = div(3, 2);
	    System.out.println("d  = " + d);
 * 
 * 
 * 
 * 
 *
 */ 
		
	
} // end 오늘수업정리
