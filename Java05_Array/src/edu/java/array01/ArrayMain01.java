package edu.java.array01;

import java.util.Scanner;

// 배열
// - 같은 타입의 변수들을 하나의 목록으로 저장할 때 사용
// - 배열의 선언과 초기화
//		배열타입[] 배열이름 = new 배열타입[배열길이];
// 		배열이름[인덱스] = 값;
//	or
//		배열타입[] 배열이름 = {값1, 값2, ...}
// - 배열의 인덱스는 0부터 시작하고, 배열 길이 -1에 끝남

public class ArrayMain01 {

	public static void main(String[] args) {
		System.out.println("배열(array)");
		Scanner sc = new Scanner(System.in);
		
		int score1 = 100;
		int score2 = 90;
		int score3 = 80;
		int score4 = 70;
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
		System.out.println(score4);
		
		System.out.println("============");
		int n = sc.nextInt();
		int[] scores = new int[n];
		scores[0] = 90;
		scores[1] = 80;
		scores[2] = 70;
		scores[3] = 60;
		for(int i = 0; i < 4; i++) {
			System.out.println(scores[i]);
		}
		

	} // end main()

} // end ArrayMain01
