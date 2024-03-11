package edu.java.access07;
// 주석 처리된 코드는 복습할 필요가 없음
public class MyNumber {
	// 멤버 변수
	private int number;
	
	// 생성자
	public MyNumber(int number) {
		this.number = number;
	}
	
	// private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
	public int getNumber() {
//		System.out.println("누가 이거 씀?");
		return number;
	}
	
	// private 멤버 변수를 간접적으로 변경하는 메소드 - setter
	public void setNumber(int number) {
//		if(number==10) {
//			this.number = 0;
//		} else {
			this.number = number;
			
//		}
	}
	
	// 이런식으로 하지말것
	
	// 기능 : 현재 객체(this : MyNumber)의 number 변수와
	//		 매개 변수로 받아온 객체의 number를 더한 후,
	//		 현재 객체의 number에 저장
	// 리턴타입 : MyNumber
	// 함수 이름 : add
	// 매개변수 : MyNumber number
	public MyNumber add(MyNumber number) {
		this.number = this.number + number.number;
		return this;
	}
	
	
} // end MyNumber





