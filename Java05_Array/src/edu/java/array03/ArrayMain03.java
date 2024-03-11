package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		// n명의 학생 점수를 입력받아(입력되는 만큼 배열의 길이가 변화되도록)
		// 모든 점수, 총합, 평균을 출력하기(점수는 직접 입력)
		// 뽀나스) 최대값, 최소값도 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("n명 입력>");
		int n = sc.nextInt();
		int[] scores = new int[n];
		
		System.out.println("점수를 입력하세요");
		for(int i = 0; i < n; i++) {
			scores[i] = sc.nextInt(); // 배열의 인덱스의 값이 입력받은 값이 되도록 지정
		}
		// 모든 점수 출력
		for(int i = 0; i < scores.length;i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		
		// 모든 점수의 합
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum+=scores[i];
		}
		System.out.println("합계 = " + sum);
		
		// 모든 점수의 평균 출력하기(소수점까지 표현)
		double avg = ((double) sum) / n;
		System.out.println("평균 = " + avg);
		
		// 점수 최댓값 출력
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if (scores[i] > max) { // 배열에 저장된 값이 max보다 큰경우
				max = scores[i];
			}
		}
		System.out.println("최댓값 = " + max);
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				
			}
			System.out.print(scores[i]);
		}
		System.out.println("최소값 = " + min);
		
		
	} // end main()

} // end ArrayMain03



