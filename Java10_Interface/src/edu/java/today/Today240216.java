package edu.java.today;

public class Today240216 {

	// interface 1 ~
	
	/*
	 *  인터페이스(Interface) : 
	 *  1. 인터페이스의 모든 메소드는 public abstract로 선언(Java 7버전까지)
	 *  -> public abstract 수식어 생략 가능
	 *  2. 인터페이스의 모든 멤버 변수는 public static final로 선언
	 *  -> public static final 수식어 생략 가능
	 *  3. 인터페이스를 선언할 때는 interface 키워드 사용
	 *  4. 인터페이스를 구현(상속)하는 클래스는 implements 키워드 사용
	 *  5. 클래스는 다중 상속이 불가능
	 *   (예) class Child extends Parent1, Parent2 (x)
	 *  6. 인터페이스는 다중 구현이 가능
	 *   (예) class Child extends Inter1, Inter2 (o)
	 */
		// 인터페이스 멤버 변수 : public static final
		// 인터페이스는 객체 생성이 불가능하기 때문에 반드시 static이 있어야함.	
		// 인터페이스는 인스턴스 생성 불가능
	
		/*Java 8 버전부터 바뀐 인터페이스 :
		 *  인터페이스가 가질 수 있는 멤버들 :
		 *  1. public static final 멤버 변수 - Java 7 버전과 동일
		 *  2. public abstract 메소드 - Java 7 버전과 동일
		 *  3. default 메소드 : // 안쓰이는 코드 있구나 정도만 인지하고 넘어가는 용도
		 *   - 본체(body)가 구현되어 있는 메소드
		 *   - default 키워드를 사용하여 선언
		 *   - 인스턴스가 생성되어야만 사용할 수 있는 코드
		 *  4. static 메소드
		 *   - 본체(body)가 구현되어 있는 메소드
		 *   - static 키워드 사용. 인스턴스 생성 없이 사용 가능한 메소드
		 */
	
/* 
 * 1. MVC(Model-View-Controller) pattern을 이용
	@ MVC 패턴
 * 아키텍쳐 패턴 중 하나
 * 애플리케이션 전체를 모델, 뷰, 콘트롤러 관점으로 구분하는 패턴
 * 모델(Model)
	- 개발자가 처리할 데이터를 표현하는 클래스
	- VO(Value Object), DTO(Data Transfer Object)
 * 뷰(View)
	- 애플리케이션의 사용자 인터페이스(UI) 영역
 * 콘트롤러(Controller)
	- 애플리케이션의 특정 로직을 처리하는 영역
 * 
 * 오늘 배운 내용이 인터페이스(interface) 관련해 위의 내용인건데...
 * 오늘 배운건 이해가 잘 가는거 같았는데 한순간에 물거품처럼
 * 바스라져 사라진듯하다.
 * 아니 이게 내것이 된 건가 싶은 생각이 매우 강하게 든다.
 * 전에 만들었던 연락처 관리 프로그램을 오늘 배운 저 MVC 모델을 이용해
 * 여태까지 해왔던 코딩이 클래스 하나에서만 모든걸 짜고 처리햇다면
 * 이제 클래스내에 나뉘어진 파일들을 각각 짜서 인터페이스와 클래스들을
 * 사용해서 코드를 짜 실행시키는 수업이었다. 분명 이론쪽을 할때는 이해가
 * 간듯했는데, 직접 코드를 짜면서 보여주신 부분부터는 조금씩 어? 하면서
 * 날아가다가 내가 직접 코드를 짜면서 완전히 오늘 하루 배운게 아무것도
 * 없어진거같다. 다행히 오늘 수업 부분을 영상으로 찍어주신 부분이 있어서
 * 그걸 바탕으로 주말동안.. 다시 복습해서 해봐야겠다..
 */
	
} // end Today240216
