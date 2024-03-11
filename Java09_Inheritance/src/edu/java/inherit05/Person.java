package edu.java.inherit05;

public class Person {
	private String name;

	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Object의 toString은 기본형인 주소값 출력을 하는 메소드이고,
	// 재정의를 해서 재정의한 값을 toString 메소드를 출력
	// ㄴ 내가 이해한 내용
	
	// 자바의 모든 클래스는 java.lang.Object 클래스를 상속받아서 만들어짐!
	// 자바의 모든 클래스는 Object 클래스의 public 메소드들을 사용 가능
	// Object 클래스의 toString 메소드 :
	// - 패키지이름.클래스이름@참조값(주소값) 리턴
	// ㄴ 강사님의 설명
	@Override // annotation(어노테이션) : 특정 변수나 메소드, 클래스의 상태를 표시. 주석이랑은 다름
	public String toString() {
		return name + "입니다.";
	}
	
	
} // end Person
