package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		// 1. 입력받은 준비 : Scanner 생성
		
		Scanner sc = new Scanner(System.in);
		
		// 2. 국어, 영어, 수학 점수를 정수로 입력받아서 변수에 저장
		
		System.out.println("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.println("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.println("수학 점수 입력 : ");
		int math = sc.nextInt();
				
		// 3. 국어, 영어, 수학 점수를 출력
		
		System.out.println(("국어 점수 : " + kor) + ("영어 점수 : " + eng) + ("수학 점수 : " + math));
		
		// 4. 총점을 계산하여 출력
		int total = kor + eng + math;
		System.out.println("총점 : " + total);
		
		// 5. 평균을 계산하여 출력(소수점 셋째자리까지)
		
		System.out.printf("평균 점수 : %.3f", total / 3.0);

	} // end main()

} // end ScoreMain
