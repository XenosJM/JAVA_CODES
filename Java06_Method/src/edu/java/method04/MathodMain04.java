package edu.java.method04;

import java.util.Scanner;

// 참조 변수 : 주 코드의 변화를 다른 코드들이 인식하는 변수
// 주소값(위치값)이 같으면 같은 객체이다.

public class MathodMain04 {

	public static void main(String[] args) {
	    // 프로그램의 시작을 알리는 메시지 출력
	    System.out.println("배열을 매개변수로 갖는 메소드");
	    
	    // 크기가 5인 int형 배열 생성
	    int[] scores = new int[3];
	    // 배열의 주소값 출력
	    System.out.println("주소값 : " + scores);
	    
	    // inputScores 메서드 호출하여 사용자로부터 점수를 입력받음
	    inputScores(scores);
	    
	    // printScores 메서드 호출하여 입력한 점수를 출력
	    printScores(scores);
	} // end main()

	// 배열을 매개변수로 받아 사용자로부터 점수를 입력받는 메서드
	private static void inputScores(int[] scores) {
	    Scanner sc = new Scanner(System.in);
	    for(int i = 0; i < scores.length; i++) {
	        System.out.println("점수 : " + i + "번째 입력>");
	        // 사용자로부터 입력받은 점수를 배열의 해당 인덱스에 저장
	        scores[i] = sc.nextInt();
	    }
	    sc.close(); // Scanner 객체 닫기
	} // end inputScores

	// 배열을 매개변수로 받아 입력한 점수를 출력하는 메서드
	private static void printScores(int[] scores) {
	    // 배열의 주소값 출력
	    System.out.println("주소값 : " + scores);
	    // 배열의 모든 요소를 반복하면서 출력
	    for(int x : scores) {
	        System.out.println("입력한 점수 : " + x);
	    }
	} // end printScores

}// end MethodMain04()
