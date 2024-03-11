package edu.java.inherit03;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Phone {
	// 멤버 변수
	private String number;
	
//	 클래스의 기본 생성자를 생략하면 컴파일러가 기본생성자를 만들어 줌. -> new로 콜 했을시 "무조건" 생성자를 불러와야하기 때문에
//	 생성자를 하나라도 정의한 경우,
//	 자바 컴파일러는 기본 생성자를 자동으로 만들어주지 않음
	public Phone(String number) {
		this.number = number;
		System.out.println("Phone(number) 생성자 호출");
	}
	
	
} // end Phone
