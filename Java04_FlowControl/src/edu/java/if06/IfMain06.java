package edu.java.if06;

import java.util.Scanner;

public class IfMain06 {

	public static void main(String[] args) {
		System.out.println("if 중첩문 연습");

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		sc.close();
		
		// 1) 입력된 정수에 대해 짝수와 홀수로 나눔
		// 2) 여기서 만약 짝수인 경우,
		//		ㄴ 입력된 정수가 4의 배수면 -> 4의 배수 출력
		//		ㄴ 입력된 정수가 4의 배수가 아니면 -> 4의 배수가 아닌 짝수 출력
		//			만약 홀수인 경우,
		//			ㄴ 아무것도 출력 안함
		
		
		if(num % 2 == 0) {// 짝수인 경우
			System.out.println("짝수");
			if(num % 4 == 0) {// 4의 배수일 때
				System.out.println("4의 배수");				
			} else {// 4의 배수가 아닐때 
				System.out.println("4의 배수가 아닌 짝수");
			}
		} else {// 홀수일 때
			System.out.println("홀수");
		}
		
		
		
		/* 위 코드를 보고 내가 해석한 내용
		 * 
		 * 주어진 정수 num을 2로 나눈 몫이 0이면 "짝수"로 출력
		 * 주어진 정수 num을 4로 나눈 몫이 0이면 "4의 배수"로 출력
		 * 아니라면 나머지를 "4의 배수가 아닌 짝수"로 출력
		 * 짝수가 아닌 나머지는 "홀수"로 출력
		 */

		
		
		
	} // end main()

} // end IfMain06
