package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		
		int[] english = {100, 90, 80};
		System.out.println(english.length);
		
		// for문을 사용한 출력
		for(int i = 0; i < english.length; i ++) {
			System.out.println(english[i]);
		}
		
		// for-each 구문(향상된 for 구문)
		// for (타입 변수이름 : 배열) { ... }
		// - 타입은 배열과 동일한 타입으로 선언
		// - 배열에 있는 모든 데이터를 접근할 때 사용
		// - for-each 문은 사용하기 위해서는 배열을 순차적으로 내려야한다
		//  ㄴ 2차원 배열을 -> 1차원 배열로, 1차원 배열을 -> 문자열로
		
		for(int x : english) { // 배열안에 있는 모든 데이터에 접근한다.
			System.out.println(x);
		}
		
		
	} // end main()

} // end ArrayMain04



