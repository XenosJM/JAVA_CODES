package edu.java.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// 기본 생성자를 사용하여 MyRactangle 클래스의 인스턴스 생성
		MyRectangle rect1 = new MyRectangle();
		// 매개변수가 따로 있는게 아니기 때문에 변수를 선언해서 초기화할 값을 할당 해줘야한다
		rect1.width = 3.0; // rect1.width 변수에 3.0을 저장
		rect1.height = 4.0; // rect1.height 변수에 4.0을 저장
		System.out.println("넓이 : " + rect1.width);
		System.out.println("높이 : " + rect1.height);
		System.out.println("면적 : " + rect1.calcArea());
		
		System.out.println("====================");
		// 매개변수가 있는 생성자를 호출하여 인스턴스 생성
		MyRectangle rect2 = new MyRectangle(3.0, 4.0); 
		// 매개변수가 있는 생성자를 호출하여 인스턴스를 생성하면 변수를 선언할 필요가없이
		// 초기화할 값만 할당 하면된다.
		System.out.println("넓이 : " + rect2.width);
		System.out.println("높이 : " + rect2.height);
		System.out.println("면적 : " + rect2.calcArea());
		
		
	} // end main()

} //  end ClassMain02
