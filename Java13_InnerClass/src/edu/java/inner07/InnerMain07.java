package edu.java.inner07;
interface Hello{
	public abstract void hello();
} // end Hello

class Person implements Hello {
	@Override
	public void hello() {
		System.out.println("안녕?");
	}
	
} // end Person

class dog implements Hello {
	@Override
	public void hello() {
		System.out.println("멍멍?");
	}
} // end dog

public class InnerMain07 {

	public static void main(String[] args) {
		Person p1 = new Person(); // 원래 형태1
		p1.hello();
		
		Hello p2 = new Person(); // 원래 형태2
		p2.hello();
		
		Hello dog = new dog(); // 원래 형태3
		dog.hello();
		
		Hello cat = new Hello() { // 한번 쓰고 말 코드에는 이렇게 사용한다.
								  // ㄴ 익명 클래스
			@Override
			public void hello() {
				System.out.println("냐옹?");
			}
			
		}; // 익명 클래스 사용.
		cat.hello();
		
		/* new Hello() {본체}
		 * 본체 : Hello interface를 구현하는 클래스의 내용(객체)
		 * 
		 * * 익명 클래스를 사용하는 이유
		 * - 인터페이스의 메소드가 한 개인 경우,
		 * 	 클래스 외부에서 선언하여 implements하지 않고 사용하기 위해
		 * - 익명 클래스를 사용하면 클래스를 외부에서 생성할 필요가 없음
		 * - 객체를 한 번 생성하고 더 이상 생성하지 않을 경우 사용
		 */
	} // end main()

} // end InnerMain07




