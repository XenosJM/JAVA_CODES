package edu.java.access04;

public class AccessMain04 {

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
		contacts[0] = c1;
		// 박명수의 정보를 contacts[1]에 저장
		contacts[1] = c2;
		// 아이유의 정보를 contacts[2]에 저장
		contacts[2] = new Contact(2, "아이유", "010-2222-3333", "iu@gmail.com");
		
		for(Contact c : contacts) { 
			// 배열 contacts의 각 요소에 대해 반복하여 변수 c에 할당
			System.out.println("no = " + c.getNo()); // c의 번호 출력
			System.out.println("name = " + c.getName()); // c의 이름 출력
			System.out.println("phone = " + c.getPhone()); // c의 전화번호 출력
			System.out.println("email = " + c.getEmail()); // c의 e-mail 출력
		}
		
		for(Contact c : contacts) { 
			// 배열 contacts의 각 요소에 대해 반복하여 변수 c에 할당
			System.out.println(c.toString()); // == System.out.println(c);
			// 각 contact 객체의 문자열 표현을 출력합니다. toString() 메서드는 생략 가능합니다.
		}
		
		
		
		
	} // end main()

} // end AccessMain04
