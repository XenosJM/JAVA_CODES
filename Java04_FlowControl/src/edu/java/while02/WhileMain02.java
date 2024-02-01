package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

	public static void main(String[] args) {
		System.out.println("구구단 연습");
		Scanner sc = new Scanner(System.in);
//		int dan = sc.nextInt();			
//		int i = 1;
//		while (i <= 9) {
//			System.out.println(dan + " * " + i + " = " + (dan * i));
//			i++;
//		}

		// 반복문의 반복 구절을 큰것부터 만들고 작은것을 안으로 넣는다.

		// 2 ~ 9까지 반복
		int dan = 2;
		while (dan <= 9) {
			System.out.println(dan + "단");
			int i = 1;
			while (i <= 9) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
				i++;
			}
			dan++;
		}

		// for문으로 구구단 출력하기
		// 단 : 4 ~ 8
		// 곱하는 수 : 2 ~ 7

		for (int x = 4; x <= 8; x++) {
			for (int y = 2; y <= 7; y++) {
				System.out.println(x + " x " + y + " = " + x * y);
			}
		}

		// 별그리기에 앞서 바탕이 되는 사각형 만들기
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (i >= j) {
//					System.out.print("*");					
//				}
//			}
//			System.out.println();
		int n = sc.nextInt();
		
		for (int i = 0; i < n / 2 + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j < n / 2 || (j - i >= n / 2 + 1)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		} // 별그리기는 재미로 접근하고 짜증만 난다 싶으면넘기기

	} // end main()

} // end WhileMain02
