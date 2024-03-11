package edu.java.access03;

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
} // end MyNumber
