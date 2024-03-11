package edu.java.today;

import edu.java.access04.Contact;

public class 오늘수업정리0213 {

	// class
//		클래스의 생성자 설명 MyRectangle
//	클래스 : 
//	상태(속성, 성질) : 멤버 변수(field, property)
//	기능 - 메소드
//	생성자(constructor) - 멤버 변수들을 초기화
//		- 클래스 이름과 동일
//		- 매개변수는 있을 수도 있고, 없을 수도 있음
//		- 클래스를 작성할 때 생성자를 하나도 정의하지 않은 경우,
//		  자바 컴파일러가 기본 생성자를 자동으로 만들어 줌.
//		- 생성자를 하나라도 정의한 경우에는, 자동으로 기본 생성자를 만들지 않음

	// 매개변수
	String 오늘;
	String 수업정리;

	public 오늘수업정리0213() {
	} // 매개변수가 없는 기본 생성자
	// 매개변수가 따로 있는게 아니기 때문에 변수를 선언해서 초기화할 값을 할당 해줘야한다
	// ㄴ 내가 이해한 내용.

	public 오늘수업정리0213(String 오늘, String 수업정리) { // 매개변수가 있는 생성자
		// 매개변수가 있는 생성자를 호출하여 인스턴스를 생성하면 변수를 선언할 필요가없이
		// 초기화할 값만 할당 하면된다. <- 내가 이해한 내용.
		this.오늘 = "오늘";
		this.수업정리 = "수업정리";
		// this = 자기 자신(오늘수업정리0213 클래스) = 출처표시
	}

	// Access
//		접근 제한수식어 01

	// 접근 제한 수식어(Access Modifier) (식별자)
	// 1. 종류 : private, (package), protected, public
	// 2. 기능 :
//			1) 멤버 변수에 대한 접근 권한을 설정
//			2) 메소드에 대한 접근 권한을 설정
//			3) 생성자에 대한 접근 권한을 설정
//			4) 클래스에 대한 접근 권한을 설정(package, public만 사용 가능)
	// 3. 종류 및 의미 :
//			1) private : 선언(정의)된 클래스 안에서 직접 접근(사용)이 가능
//			2) (package) : 같은 패키지에 있는 클래스에서 직접 접근(사용)이 가능
//			3) protected : 같은패키지에 있거나 상속받는 클래스들에서 직접 접근(사용)이 가능
//			4) public : 어디서든지 직접 접근(사용) 가능
	// 4. 사용 범위 : private < (package) < protected < public

	// 예문)

//		private int n1; // 클래스 내부에서 사용
//		int n2; // (package) 내부에서 사용 (package)는 생략이 가능하다.
//		protected int n3; // 같은 패키지 혹은 상속받은 클래스들에서 사용
//		public int n4; // 어디서든지 사용

	// 이제 위의 예문을 다른 패키지에 불러와서 적용시켜보면

//		t1.n1 = 100; // private : 접근 불가(컴파일 에러가 남)
	// private 멤버 변수는 다른 클래스에서 직접전근이 불가능(보이지 않음)
	// -> 값을 직접 변경하거나 읽어오지못함
//		t1.n2 = 200; // (package) : 다른 패키지에 있으므로 접근 불가
	// ㄴ 같은 패키지 내에 있을경우 접근이 가능해짐
//		t1.n3 = 300; // protected : 다른 패키지이고, 상속받지 않았으므로 접근 불가
	// ㄴ 마찬가지로 같은 패키지인경우 접근이 가능해진다.
//		t1.n4 = 400; // public : 어디서든지 접근 가능
	// 이렇게 된다

//		접근 제한자 03

	// 캡슐화(encapsulation)
	// - 클래스를 설계할 때, 멤버 변수(필드)들을 private으로 선언하여
//		 외부 클래스에서 멤버 변수들을 직접 접근해서 읽거나 쓰지 못하게 하는 것
	// - 필요한 경우 한해서 public 메소드를 정의하여
//		 private 멤버 변수를 간접적으로 읽거나 쓰는 것을 가능하게 할 수 있음
	// - 필요에 의해 사용할 경우 getter 와 setter 메소드를 사용해 '간접적'으로 읽거나 변경이 가능

	// private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
	public String get오늘() {
//			System.out.println("누가 이거 씀?"); // 사용될때 로그에 알려주는용도 ㅋㅋ
		return 오늘;
	}

	// private 멤버 변수를 간접적으로 변경하는 메소드 - setter
	public void set수업정리(String 수업정리) {
		this.수업정리 = 수업정리;
	}

	
//		객체 저장방식 04
	// 예문과 함께 정리.
	
	public static void main(String[] args) {
	// 객체 생성 및 데이터 저장 방식 1
	// 메소드를 이용하여 한번에 입력해서 초기화
	Contact c1 = new Contact(0, "유재석", "010-1111-1111", "you@gmail.com");
	// 매개변수가 있는 생성자를 사용하여 Contact 클래스의 인스턴스 생성
	System.out.println(c1.toString()); // 변수값이 제대로 초기화 됬는지 확인

	System.out.println();
	// 전화번호를 변경해라!
	c1.setPhone("010-1234-5678"); // setter를 이용해 간접적으로 변수값을 변경
	System.out.println(c1.toString()); // 변경이 됬는지 확인

	// 객체 생성 및 데이터 저장 방식 2
	// 각 데이터를 일일이 setter 메소드를 사용하여 데이터값을 초기화
	Contact c2 = new Contact(); // 기본 생성자를 사용하여 Contact 클래스의 인스턴스 생성
		System.out.println(c2.toString());
		c2.setNo(1);
		c2.setName("박명수");
		c2.setPhone("010-3333-3333");
		c2.setEmail("park@gmail.com");
		System.out.println(c2.toString());

	// 3명의 연락처 정보를 배열로 묶음

	Contact[] contacts = new Contact[3];
	// Contact 클래스를 인덱스가 3개인 contacts 배열로 만듦 <- 내가 이해했던것
	// Contact 클래스를 사용하여 크기가 3인 배열을 생성하여 contacts에 할당 <- 맞는 해석 이걸로 이해해야함

	// 유재석의 정보를 contacts[0]에 저장
	// 객체의 주소값을 변경한것을 참조해오는 참조변수이기 때문에 중간 어디서든 
	// setter를 이용해 간접변경을 하면변경이 된 주소값을 보여준다.
	contacts[0]=c1;
	// 박명수의 정보를 contacts[1]에 저장
	contacts[1]=c2;
	// 아이유의 정보를 contacts[2]에 저장
	contacts[2]=new Contact(2,"아이유","010-2222-3333","iu@gmail.com"); // 이런 방식의 코드도 가능
	
	for(Contact c:contacts) {
		// 배열 contacts의 각 요소에 대해 반복하여 변수 c에 할당
		System.out.println("no = " + c.getNo()); // c의 번호 출력
		System.out.println("name = " + c.getName()); // c의 이름 출력
		System.out.println("phone = " + c.getPhone()); // c의 전화번호 출력
		System.out.println("email = " + c.getEmail()); // c의 e-mail 출력
	}

	for(Contact c:contacts) {
		// 배열 contacts의 각 요소에 대해 반복하여 변수 c에 할당
		System.out.println(c.toString()); // == System.out.println(c);
		// 각 contact 객체의 문자열 표현을 출력합니다. toString() 메서드는 생략 가능합니다.
		}
	
	
	// 클래스의 접근 제한 수식어 : public, (package)
	// 1. public class : 어디서든지 인스턴스 생성이 가능한 클래스
	// 2. (package) class : 같은 패키지에 속한 클래스만 인스턴스 생성이 가능
	// 주의사항 : 
	// - public class의 이름은 반드시 java 파일의 이름과 같아야함!
	// - 하나의 java 파일에 여러 개의 클래스를 정의하는 것은 가능하지만,
//		 파일 내에 public class는 오직 하나만 있어야 함
	// 다른 패키지에 속한 클래스에서는 인스턴스 생성 불가능 
	
	}
}
