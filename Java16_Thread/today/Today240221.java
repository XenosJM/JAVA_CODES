package today;

public class Today240221 {

	/* 오늘의 수업내용
	 * InnerClass
	 */
	/* 변수 선언 : 
	 * 1. 멤버 변수(필드) : 클래스에서 선언된 변수
	 *  - 클래스 내부 어느 곳에서나 사용할 수 있는 변수
	 *  - 수식어(public, private, static, ...)를 사용할 수 있음
	 * 2. 지역 변수 : 메소드 안에서 선언하는 변수
	 *  - 지역 변수가 선언된 곳에서 변수가 속한 블록({})이
	 *    끝나는 곳까지 사용할 수 있는 변수
	 *  - 접근 수식어(public, private, static, ...)를 사용할 수 없음
	 *  - final은 가능
	 *  
	 *   내부 클래스(Inner Class) : 다른 클래스 내부에서 정의된 클래스
	 *   1. 멤버 내부 클래스(member inner class)
	 *   - 멤버 변수를 선언하는 위치에서 정의하는 내부 클래스
	 *   - 외부 클래스의 인스턴스가 생성되어야만 객체 생성이 가능함
	 *   2. static 내부 클래스(static inner class), 중첩 클래스(nested class)
	 *   - 멤버 변수를 선언하는 위치에서 static으로 정의한 내부 클래스
	 *   - 외부 클래스의 인스턴스를 생성하지 않아도 객체 생성이 가능함
	 *   - 외부 클래스와 상관이 없는 클래스라고 생각해도 됨
	 *   3. 지역 내부 클래스(local inner class) : 메소드 안에서 정의하는 클래스
	 *   4. 익명 클래스(Anonymous class) : 이름이 없는 내부 클래스
	 *   -> 람다 표현식 사용 가능  
	 */
	/* 외부클래스의 멤버 변수는 내부 클래스에서 직접 사용이 가능하다.
	 * 내부 클래스 자체는 객체를 생성할수 없지만, 외부클래스에서 객체가
	 * 생성되면 내부클래스도 생성이 가능해 진다.
	 * 예)
	 *  외부 클래스 OuterClass의 인스턴스 생성 :
	 *	OuterClass out1 = new OuterClass(n);
	 *	
	 *  내부 클래스의 인스턴스 생성 : 
	 *  (외부 클래스 이름).(내부 클래스 이름) 변수이름 = 
	 *  (외부 클래스의 참조변수).new (내부 클래스 생성자)();
	 *	OuterClass.InnerClass inner1 = out1.new InnerClass(n);
	 */
	/* 멤버 내부 클래스(member inner class)를 사용하는 경우
	 *  상속 관계로 묶을 수 없지만,
	 *  A라는 객체가 생성된 이후에만 존재할 수 있는 B라는 객체가 있다면
	 *  B를 A의 내부 클래스로 정의
	 *  (예) 자동차 - 타이어, PC - CPU/RAM 등
	 */
	/*	 
	 * 	외부 클래스의 멤버 변수 이름과
	 *	내부 클래스의 멤버 변수 이름이 같을때
	 *	외부 클래스의 멤버 변수를 참조하는 방법
	 *	외부클래스 이름.this.멤버 변수
	 */
	/* static 내부 클래스(중첩 클래스, nested class) 에서는
	 * 외부 클래스의 static이 아닌 변수는 참조할 수 없고,
	 * 외부 클래스에서 static으로 선언된 변수는 참조가 가능하다.
	 *   
	 * static 멤버 변수 사용 : (클래스이름).(변수이름)
	 * 
	 * 중첩 클래스(static 클래스)
	 * (외부클래스 이름).(중첩클래스 이름) 변수이름 = 
	 * 		new (외부클래스 이름).(내부클래스 이름)();
	 */
	/* 지역 클래스의 메소드들을 외부에서 사용하는 방법 :
	 *	 1. 지역 클래스의 메소드들을 선언한 인터페이스를 정의
	 *	 2. 지역 클래스가 인터페이스를 구현하도록 정의
	 *	 3. 다형성을 사용하여 메소드의 리턴타입으로 인터페이스를 사용할 수 있음
	 */
	/* 익명 클래스란 한번만 사용되고 안쓰는 값을 선언과 동시에 메소드를
	 * 사용하는 클래스 작성 방법 :
	 * 클래스이름 변수이름 = new 클래스이름 {
	 * 		@Override
	 * 		public 변수타입 메소드이름(매개변수1, 매개변수2, ...) {
	 * 			return;
	 * 		}
	 * 	}; // end 익명 클래스
	 */
	/* new Hello() {본체}
	 * 본체 : Hello interface를 구현하는 클래스의 내용(객체)
	 * 
	 * * 익명 클래스를 사용하는 이유
	 * - 인터페이스의 메소드가 한 개인 경우,
	 * 	 클래스 외부에서 선언하여 implements하지 않고 사용하기 위해
	 * - 익명 클래스를 사용하면 클래스를 외부에서 생성할 필요가 없음
	 * - 객체를 한 번 생성하고 더 이상 생성하지 않을 경우 사용
	 */
		
	// Lambda
	
	/* FunctionalInterface : 추상 메소드가 하나뿐인 메소드
 	 * 람다(lambda) 표현식은 funtion interface만 사용 가능 
	 * @FunctionalInterface으로 어노테이션 해놓고 생성
	 */
	/*	다음은 FunctionalInterface를 적용한 인터페이스를 이용하여
	 *  같은 코드를 여러 코드로 실행한 예시)
	 * 
	 * System.out.println("[1] 인터페이스를 구현하는 클래스 사용");
	 *	Adderimple adder1 = new Adderimple();
	 *	double result = adder1.add(2.0, 4.0);
	 *	System.out.println("result = " + result);
		
	 *System.out.println("[2] 다형성 사용");
	 *	Adder adder2 = new Adderimple();
	 *	result = adder2.add(1.1, 2.2);
	 *	System.out.println("result = " + result);
		
	 *System.out.println("[3] 익명 클래스 사용");
	 *	Adder adder3 = new Adder() {			
	 *		@Override
	 *		public double add(double x, double y) {
	 *			return x + y;
	 *		}
	 *	};
	 *	result = adder3.add(2.0, 1.0);
	 *	System.out.println("result = " + result);
		
	 *System.out.println("[4] 람다 사용");
	 *	Adder adder4 = (x, y) -> x + y;
	 *	result = adder4.add(1.1, 2.2);
	 *	System.out.println("result = " + result);
	 */
	/* 람다(Lambda) 표현식 : 코드의 약어
	 * (매개변수1, 매개변수2, ...) -> {실행문; 리턴; }
	 * 매개변수와 리턴타입 형태는 인터페이스의 추상메소드에 따라 결정됨
	 * 인터페이스 변수이름 = 람다 표현식
	 */
	
	// Exception
	
	/* 컴파일 에러 : 소스코드 빌드 시 발생하는 에러
	 * -> 실행 파일이 만들어지지 않았기 때문에 실행할 수 없음
	 * 예외(Exception) : 
	 * -> 소스코드를 빌드할 때는 에러가 없지만,
	 * 		프로그램을 수행할 때 발생하는 오류
	 * 논리적 오류 : 
	 * -> 컴파일 에러도 없고, 실행할 때 예외도 발생하지 않았지만
	 * 	  논리적인 문제 때문에 원하는 실행 결과가 나오지 않는 경우
	 */
	/* 이런 오류들을 처리하기 위해 사용하는 코드가 아래의
	 * try-catch 구문이다.
	 * 
	 * 예외 처리 : try-catch 구문
	 * - 예외 발생 상황에 대해 처리해주는 기능
	 * - 예외가 발생될시 catch로 넘어가짐.
	 * try{
	 * 		정상적인 실행 문장들;
	 * } catch (예외클래스 변수이름) {
	 * 		예외 상황일 때 실행할 문장들;
	 * }
	 */
	/* Exception : 예외 처리를 위한 클래스, 수많은 자식을 가지고 있음
	 * ㄴ ArithmeticException
	 * ㄴ NullPointerException
	 * ㄴ ...
	 */
	/* 하나의 try 구문에서 여러 개의 catch를 사용하는 경우,
	 * 자식 클래스의 Exception을 먼저 catch 구문에서 사용하고
	 * 가장 마지막에 최상위 부모 클래스인 Exception을 사용해야함
	 */
	/* 하나의 try 구문에서 여러 개의 catch를 사용하는 방법2 : Java 7버전부터
	 * try{
	 * 	 	정상 상황일 때 사용할 코드;
	 * } catch ( Ex1 | Ex2 | Ex3 | ... e) {
	 * 		예외 상황일 때 코드
	 * } catch (Exception e) {...}
	 */
	/* try {
	 * 		정상적인 경우에 실행할 코드들;
	 * } catch (Exception e) {
	 * 		예외 상황일 때 실행할 코드들;
	 * } finally {
	 * 		정상적인 경우든, 예외 상황이든 상관없이 항상 실행할 코드
	 * }
	 */
	
	// Thread
	
	/* OS(운영체제) : 사용자의 하드웨어, 시스템 리소스를 제어하고
	 * 		프로그램에 대한 서비스를 지원하는 시스템소프트웨어
	 * 운영체제 종류 : Windows, Linux, Unix, MacOS
	 * 프로세스 : 운영체제 내에서 연속적으로 실행되고 있는 프로그램
	 * 쓰레드(Thread) : 하나의 작업을 순차적으로 진행하는 실행 코드
	 * 멀티 쓰레드 프로그램 :
	 * - 하나의 프로그램(프로세스)에서 여러 개의 쓰레드를 동작하는 프로그램
	 * - 예) 채팅 프로그램 : 채팅 + 파일 전송
	 */
	/* 자바에서 쓰레드를 생성하고 사용하는 방법 1:
	 * 1. Thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
	 * 2. 정의한 새로운 크랠스 안에서 run() 메소드를 override
	 * -> run : 쓰레드가 해야 할 기능 구현
	 * 3. 정의한 클래스의 인스턴스 생성
	 * 4. 생성된 인스턴스에서 start()메소드를 호출
	 * -> 쓰레드가 가져야 할 메모리 공간을 확보, 스케쥴링을 위해 쓰레드 등록, 초기화
	 * -> 쓰레드의 run() 메소드가 자동으로 실행됨
	 * 1. Thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
	 * 2. 정의한 새로운 클래스 안에서 run() 메소드를 override
	 *  * -> run : 쓰레드가 해야 할 기능 구현
	 * 메인 함수도 쓰레드에서 동작 : 메인 쓰레드
	 * 3. 정의한 클래스의 인스턴스 생성
	 * 4. 생성된 인스턴스에서 start()메소드를 호출
	 */
	

} // end Today240221





