package edu.java.if07;

import java.util.Scanner;

public class IfMain07 {

	public static void main(String[] args) {
		// Ctrl + Shift + f : 코드 자동 정렬
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 3개 입력 >");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// 입력된 3 개의 숫자 중 가장 큰 수를 출력하시오
		if(a >= b) { // a가 b보다 크거나 같은가
			if(a >= c) { // a가 가장 클 경우
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		} else if (b >= c) { // b가 가장 클 경우
			if(b >= a) {
				System.out.println(b);
			} else {
				System.out.println(a);
			}
		} else if (c >= a) { // c가 가장 클 경우
			if (c >= b) {
				System.out.println(c);
			} else {
				System.out.println(b);
			}
		}
		
		
	} // end main()

} // end IfMain07
