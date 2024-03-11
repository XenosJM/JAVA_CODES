package edu.java.lambda02;

import java.util.Scanner;

@FunctionalInterface
interface Test1{
	public abstract void testPrint();
} // end Test1

@FunctionalInterface
interface Test2{
	public abstract void testPrint(int n);
} // end Test2

public class LambdaMain02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("- 익명 클래스, 람다 표현식 연습 -");
		/* 람다(Lambda) 표현식
		 * (매개변수1, 매개변수2, ...) -> {실행문; 리턴; }
		 * 매개변수와 리턴타입 형태는 인터페이스의 추상메소드에 따라 결정됨
		 * 인터페이스 변수이름 = 람다 표현식
		 */
		// 1. "익명 클래스 연습!"을 출력하는 익명 클래스(Test1) 생성 및 출력하기
		Test1 test1 = new Test1() {
			@Override
			public void testPrint() {
				System.out.println("익명 클래스 연습!");
			}			
		}; 
		test1.testPrint();		
		// 2. "람다 표현식 연습!"을 출력하는 람다 표현식(Test1) 생성 및 출력하기
		Test1 test2 = () -> {
			System.out.println("람다 표현식 연습!");
			}; // void 타입은 {} 바디를 적어도 되고 빼도 되지만 적는편이 가독성에
				// 도움이 된다.
		test2.testPrint();
		// 3. Test2를 이용하여 정수 하나를 입력받아서 "입력한 숫자는 : 100"을
		//			출력하는 익명 클래스 생성 및 출력하기
		Test2 test3 = new Test2() {
			@Override
			public void testPrint(int n) {
				System.out.println("입력한 숫자는 : " + n);	
			}
		};
		test3.testPrint(100);		
		// 4. Test2를 이용하여 정수 하나를 입력받아서 "입력한 숫자는 : 200"을
		//			출력하는 람다 표현식 생성 및 출력하기
		
		Test2 test4 = (n) -> {
			System.out.println("입력한 숫자는 : " + n);
		};
		test4.testPrint(200);
		
	} // end main()

} // end LambdaMain02
