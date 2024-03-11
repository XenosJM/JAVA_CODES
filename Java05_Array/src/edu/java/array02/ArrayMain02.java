package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		System.out.println("배열의 선언, 초기화, 출력");
		
		// int형 정수 10개를 저장할 수 있는 배열 선언
		int[] array = new int[10];
		
		System.out.println("배열의 길이 : " + array.length);
		
		// 배열의 인덱스 : 0 ~ (length - 1)
		
		// for문을 사용하여 배열에 순차적으로 1 ~ 10까지의 값을 저장
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		// a[o] = 1;
		// a[1] = 2;
		// ...
		// a[9] = 10;
		
		// for 문을 사용하여 배열의 모든 값을 출력
		for(int i = 0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		// 좀더 명확하게 보기 쉽게 출력
		for(int i = 0; i<array.length; i++) {
			System.out.println("a[" + i + "] = " + array[i]);
		}
		
		// for문을 사용하여 배열의 값을 내림차순 (10, 9, .. 1)으로 출력
		// 인덱스의 변화 9, 8, 7, ... 0
		for(int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[array.length - 1 - i]); // 위 코드에 비해 직관적이지 못해서 한눈에 보기 힘듦
		}
		
		// for 문을 사용하여 배열의 모든 값(원소)들을 더하기
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("sum = " + sum);
		
		
		
	} // end main()

} // end ArrayMain02
