package edu.java.today;

import edu.java.inherit08.Employee;
import edu.java.inherit08.Manager;

public class 오늘수업정리0215 {
// access 10 정리
	
// 싱글톤 디자인 패턴(singleton design pattern)
// - 클래스의 인스턴스를 오직 하나만 생성할 수 있도록 작성하는 설계 기법
// 1. 클래스는 자신 타입의 private static 변수를 선언
// 2. 생성자는 private으로 선언
// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
// 처음 생성한 인스턴스는 변경이 불가능(주소값이 같음)	
	
// 싱글톤 패턴 : 생성자가 여러 차례 호출되더라도실제로 생성되는 객체는 하나이고
//	최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴

// 예시) 헬리콥터로 수송을 하는데 필요로 하는곳마다 사서(인스턴스를 생성해서) 모든 곳에서 헬리콥터를 쓰면 낭비이니
//		공용으로 쓸 헬리콥터를 하나 사서(초기 인스턴스) 두고 사용하는것 샀을 때에는 기본위치(초기 인스턴스 값)
//		에 있지만 누군가 불러내서 사용 할 때 마다 헬리콥터의 위치가 변한다(호출되어 입력받은 인스턴스 값)
	
//	예시 코드 ↓
//public class PublicToilet {
//		
//		// 1. 클래스는 자신 타입의 private static 변수를 선언
//		private static PublicToilet instance = null;
//	
//		// 2. 생성자는 private으로 선언
//		private PublicToilet() {}
//	
//		// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
//		public static PublicToilet getInstance() {
//			if(instance == null) { // instance 값이 null 일 경우에 
//				instance = new PublicToilet(); // instance를 생성
//			}
//			return instance; // instance 값을 돌려준다.
//		} 
//	
//		public String getLocation() {
//			return location;
//		}
//	
//		public void setLocation(String location) {
//			this.location = location;
//		}
//	}	
	
// 	inherit 01 ~ 08
	
// inherit 01
	// BasicTv(예) : 상위 클래스(super class), 부모 클래스(parent class), 기본 클래스(base class)
	// SmartTv(예) : 하위 클래스(sub class), 자식 클래스(child class), 유도 클래스(derived class)
	// 자식 클래스는 부모 클래스의 메소드 사용 가능
	// 부모 클래스는 자식 클래스의 메소드를 사용할 수 없음
	
// inherit 02
	/*  * 생성자 - 반드시 하나는 있어야함. 없으면 컴파일러가 인스턴스 생성시에 자동으로 생성.
	 *  - 자식 클래스의 생성자가 호출되면, 부모 클래스의 생성자가 먼저 호출되어야 함
	 *  - 부모 클래스의 생성자를 명시적으로 호출할 때는 super();
	 *  - 부모 클래스의 생성자를 명시적으로 호출하지 않으면,
	 *    부모 클래스의 "기본 생성자"가 자동으로 호출됨
	 *    // 기본 생성자가 호출이 되면 super(); 같이 호출이 되는데 이때 super();
	 *    	 는 생략이 가능하다.
	 *  - 부모 클래스의 매개변수가 있는 생성자는 자동으로 호출되지 않기 때문에,
	 *    필요한 경우는 반드시 명시적으로 호출해야 함
	 *    // super(매개변수);의 형식으로 호출 되는데, 이 때는 부모 클래스에 있는 매개변수 를 자식 클래스로
	 *    	 호출해서 사용 하려고 하는 것이므로 super(매개변수); 형태로 반드시 호출시켜서 사용해야한다.
	 *  - 예시) super(매개변수)
	 *  - 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출할 때는
	 *    다른 어떤 코드보다 먼저 부모 클래스를 호출해야 함
	 */
	
// inherit 03
	/*  생성자
	 * - 자식 클래스의 생성자가 호출되면,
	 * 부모 클래스의 생성자가 먼저 실행된 후에,
	 * 자식 클래스의 코드들이 실행된다.
	 * 1) 부모 크래스의 생성자를 명시적으로 호출하지 않을 때는
	 * 	  super();가 자동으로 호출된다.
	 * 2) 부모클래스의 생성자를 명시적으로 super(); 또는
	 * 	  super(매개변수);로 호출가능
	 * 	- 만약에 부모 클래스가 기본 생성자를 가지고 있지 않은 경우에는
	 * 	  super();가 자동으로 호출될 수 없기 때문에,
	 * 	  자식 클래스의 생성자에서 super(매개변수)를 호출하는 코드가
	 * 	  반드시 있어야 한다.
	 * 
	 *    클래스의 기본 생성자를 생략하면 컴파일러가 기본생성자를 만들어 줌.
	 *    ㄴ-> new로 콜 했을시 "무조건" 생성자를 불러와야하기 때문에
	 *	  생성자를 하나라도 정의한 경우,
	 *	  자바 컴파일러는 기본 생성자를 자동으로 만들어주지 않음
	 *  
	 */ 
	
// inherit 04
	/* 
	 * 	// 메소드 재정의(override)
	 *	// - 부모 클래스가 가지고 있는 메소드를 자식 클래스에서 재정의(다시 정의)
	 *	// - 메소드의 리턴 타입, 이름, 매개변수 모두 부모 클래스의 메소드와 일치해야 함
	 *
	 *  Animal[] a = new Animal[3]; 
	 *  // 서로 다른 객체인 즉 타입이 다른경우인 객체들을 같은속성으로 묶는다.
	 *     (부모/자식 관계인 클래스는 부모클래스의 자산 즉 멤버 변수, 생성자, 메소드 등 기능을
	 *     자식 클래스가 가져와 쓸수있기 때문에 같은 타입으로 처리가 가능하다) 
	 *	a[0] = animal; // 부모 클래스
	 *	a[1] = dog; // 자식 클래스 
	 *	a[2] = cat; // 자식 클래스 
	 *	for(int i = 0; i < a.length; i++) {
	 *	a[i].speak(); // 부모에 정의된 메소드를 재정의한 자식들을 부모와 자식 모두 한 배열로 묶어서
	 *				     메소드를 실행하면 배열에 속한 다른 객체들이 같은 메소드를 실행한다.
	 *					 - 부모클래스에 있는 메소드를 가져와 오버라이드(override)하여 사용한다.
	 *					 - 이 때 	메소드의 이름이 같기 때문에 한꺼번에 실행이 가능하다.
	 *  } // end for문
	 *  
	 */
	 
// inherit 05
		
	/*  toString() : 객체가 가지고 있는 정보를 문자열로 출력
	 *	Object 클래스의 toString은 모든 클래스에서 사용 가능
	 *	기본적으로는 주소값을 나타낸다.
	 *	p1과 p1.toString()은 같은 결과를 출력
	 * 
	 * 	Object의 toString은 기본형인 주소값 출력을 하는 메소드이고,
 	 *	재정의를 해서 재정의한 값을 toString 메소드를 출력
 	 *	ㄴ 내가 이해한 내용
	 *
 	 *	자바의 모든 클래스는 java.lang.Object 클래스를 상속받아서 만들어짐!
 	 *	자바의 모든 클래스는 Object 클래스의 public 메소드들을 사용 가능
 	 *	Object 클래스의 toString 메소드 :
 	 *	- 패키지이름.클래스이름@참조값(주소값) 리턴
 	 *	ㄴ 강사님의 설명
 	 *
 	 *	@override
 	 *	ㄴ annotation(어노테이션) : 특정 변수나 메소드, 클래스의 상태를 표시. 주석이랑은 다름 
	 * 
	 */
		
// inherit 06
	
	/* 	다형성(Polymorphism)
 	 *	- 객체(인스턴스)를 여러 가지 타입으로 호출할 수 있는 것.
 	 *	- 생성된 인스턴스를 가리키는(참조하는) 참조 변수를 선언할 때
	 * 	생성된 인스턴스의 클래스 타입으로 변수를 선언할 수도 있고,
	 * 	그 부모 타입으로 변수를 선언할 수 있는 것
 	 *	- 다형성의 장점
	 * 	1. 배열을 사용할 때 부모 타입으로만 선언해도
	 *		그 배열에는 부모/자식 타입 모두 저장 가능.
	 * 	2. 메소드를 정의할 때 메소드의 매개변수나 리턴타입으로 부모 클래스 타입만
	 *		사용해도 부모/자식 타입 모두 매개변수나 리턴값으로 사용할 수 있음. 
	 *
	 * 		 자식 클래스에 부모 클래스 객체는 저장이 불가.
	 * 
	 */
	
// inherit 07
	
	/*  class1은 ParentClass 타입으로 선언했기 때문에
 	 *	ChildClass에서 정의한 getY() 메소드를 사용할 수 없음
 	 *	다만, 실제 인스턴스는 ChildClass 타입이기 때문에
 	 *	강제 형 변환(casting)을 하면, ChildClass가 가지고 있는 메소드 사용 가능
 	 *  
 	 *  위 내용은 부모 클래스에 자식클래스의 객체를 부모클래스 타입으로 저장해서 보이는 것은
 	 *  부모클래스의 객체처럼 보이지만 사실은 자식클래스의 타입인 객체이므로 자식 클래스의 메소드를
 	 *  사용할수가 있는데 선언하고 나서는 자식클래스의 메소드를 바로 사용하질못한다 마치 자신이 
 	 *  부모클래스 객체로 인식을 하는 중이기 때문. 그래서 강제 형 변환을 해주면 다시 자식클래스의
 	 *  메소드가 사용 가능해진다.
 	 *  
 	 *  System.out.println(class1.getY()); // 강제 형 변환을 하지않아 안되는 코드
 	 *	
 	 *	System.out.println(((ChildClass) class1).getY());
	 *	// 위 아래 같은 코드
	 *	ChildClass c =  (ChildClass) class1;
	 *	System.out.println(c.getY());
	 * 
	 * 
	 */
	
// inherit 08
	
	/* instanceof
 	 * - 기본 형태
	 *	 참조변수 instanceof 클래스 이름
 	 * - 명시한 클래스 타입의 인스턴스와 같으면 true, 아니면 false를 리턴하는 키워드
 	 * - 특정 인스턴스가 실제 어떤 클래스인지 확인할 때 사용
	 * 	 
	 * instanceof 키워드를 쓰는 이유는 부모 클래스와 자식 클래스의 객체들로 이루어진 배열을
	 * 클래스들에 정의된 메소드를 이용하여 배열의 인덱스에 저장된 값을 출력하거나 변경할때
	 * 부모 클래스에 정의된 메소드를 이용할때는 문제가 없지만, 자식 클래스에 정의된 메소드를
	 * 이용하게 되면 java.lang.ClassCastException 이런 형변환 오류가 발생하게 된다.
	 *  
	 * 이것은 메소드를 이용하기 전 진행되는 형변환이 잘못되었을때 나오는 오류 문구이다.
	 * 이 오류를 해결하려고 강제 형변환을 해줘도 같은 오류가 나는데 이는 자식클래스의 메소드가 
	 * 부모클래스의 객체를 형변환 시키려고 해서, 즉 다운 캐스팅이 되어서 생기는 문제이다.
	 * 
	 * 그래서 이 오류를 해결하기 위해 사용하는게 instanceof 키워드이다.
	 * 아래는 강제형변환만 시켜주었지만 오류가 여전히 생기는 코드이고 
	 * 그 다음 코드가 instanceof 코드를 이용해 해결 코드이다.
	 * 
	 */
	
	// 오류가 여전히 생기는 코드
//	public static void printEmployeeInfo(Employee[] emps) {
//		for(Employee e : emps) {
//				System.out.println("이름 : " + e.getName());
//				System.out.println("직책 : " + ((Manager)e).getType());				
//			}	// getType 메소드는 자식 클래스에 있는 메소드여서 사용하기위해 강제 형변환으로 
				// 자식클래스로 배열을 형변환 해준 코드이다. 다만 여기서 이제 부모객체도 같이 형변환을
				// 시키려고해서 오류가 난다.
//		};
//	}
	
	// instanceof 키워드를 사용해 해결한 코드
//	public static void printEmployeeInfo(Employee[] emps) {
//		for(Employee e : emps) {
//			if(e instanceof Manager) { // Manager 클래스 인스턴스인경우 true
//				System.out.println("이름 : " + e.getName());
//				System.out.println("직책 : " + ((Manager)e).getType());				
//			} else if (e instanceof Employee) { // Employee 인스턴스인경우 true
//				System.out.println("이름 : " + e.getName());
//				System.out.println("직책 : 사원");	
//			}
//		};
//	}
	
}












