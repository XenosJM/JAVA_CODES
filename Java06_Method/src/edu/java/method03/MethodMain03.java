package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		// 2. 메소드를 정의하여 입력받은 점수를 호출
		printScores(kor, eng, math);
		// 3. 메소드를 정의하여 세 과목의 총점을 출력
		System.out.println("세 과목의 총합 = " + calcTotal(kor, eng, math));
		// int sum = calcTotal(kor, eng, math);
		
		// 4. 메소드를 정의하여 세 과목의 평균을 출력
		System.out.println("세 과목의 평균 + " + calcAverage(kor, eng, math));
		// double avg = calcAverage(sum)
		// system.out.println("평균 = " + avg);
		
		// 5. 메소드를 정의하여 평균에 따른 등급을 출력
//		System.out.println("평균에 따른 등급 = " + selectGrade(kor, eng, math));
		
		
	} // end main()
	
	// 국 / 영 / 수 점수를 출력하는 메소드
	// 메소드 이름 : printScores()
	public static void printScores(int kor, int eng, int math) {		
		System.out.println("국어 = " + kor + " 영어는 " + eng + " 수학은 = " + math);
	}
	// 총점을 리턴하는 메소드
	// 메소드 이름 : calcTotal()
	public static int calcTotal(int kor, int eng, int math) {
		// == int calcTotal(int sum) {
		// int 
		return kor + eng + math;
	}
	// 평균을 리턴하는 메소드
	// 메소드 이름 : calcAverage()
	public static double calcAverage(double kor, double eng, double math) {
		// == double calcAverage(double sum) {
		return (kor + eng + math) / 3.0;
		//==  return sum / 3.0;
	}
	// 등급을 리턴하는 메소드
	// 메소드 이름 : selectGrade()
//	public static void selectGrade(int kor, int eng, int math) {
//	public static char selectGrade (double avg) {
//		char result = 0;
//		if (100>= avg && avg >= 90) {
//			result = 'A';
//		} else if (avg >= 80) {
//			result = 'B';
//		} else if (avg >= 70) {
//			result = 'C';
//		} else {
//			result = 'F';
//		}
//	}
//		double avg = calcAverage(kor, eng, math);
//		double avg = calcAverage(sum)
//		if(avg >= 90) {
//			System.out.println("평균에 따른 등급 = " + 'A');
////			return 'A';
//		} else if(avg >= 80) {
//			System.out.println("평균에 따른 등급 = " + 'B');
////			return 'B';
//		} else if(avg >= 70) {
//			System.out.println("평균에 따른 등급 = " + 'C');
////			return 'C';
//		} else {
//			System.out.println("평균에 따른 등급 = " + 'f');
////			return 'F';
//		}
//		
//	}
	
} // end MethodMain03




