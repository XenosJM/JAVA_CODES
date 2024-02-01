package edu.java.while01;

/* while문
 * - for문과 같은 반복문
 * - 선언 형태
 * 		while(조건) {// while : 조건이 참인 동안
 * 			(본문)
 * 		}
 * */


public class WhileMain01 {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		// 0 ~ 10 까지 출력
		int x = 0;
		while (x <= 10) {
			System.out.print(x + " ");
			x++;
		}
		System.out.println();
		
		// while문을 사용하여 10, 9, 8, ... 2, 1까지 출력하기
		x= 10;
		while(x >= 1) {
			System.out.print(x + " ");
			x--; // 일반적으로는 증감 연산자를 가장 끝에 두는것이 좋다.
		}
		
		
		
	} // end main()

} // end WhileMain01
