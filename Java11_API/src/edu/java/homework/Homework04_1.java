package edu.java.homework;

public class Homework04_1 {

	public static void main(String[] args) {
		String str = "2024년 02월 19일 16:37:53";
//		String[] result = str.split("년 | |월 | |일 | |:");
		String[] result = str.split("[^0-9]+"); // 숫자를 기준으로 자른다.
		// str에서 숫자만 추출
		for(String x : result) { // result 배열의 모든값 확인
			System.out.println(x);
		} // end for 
		// 숫자만 남은 result 값을 int로 형변환?
		int[] result1 = new int[result.length]; // int배열 result1을 result의 길이만큼 선언		
		int sum = 0;
		for(int i = 0; i < result.length; i++) { // 인덱스를 result.length만큼까지
			result1[i] = Integer.parseInt(result[i]);
			// result1[i] result1의 인덱스 i값을 Integer.parseInt로
			// result[i]의 값을 형변환시켜서 result1[i]에 초기화
			
			sum+=result1[i];
			// result1의 i 인덱스 값은 인트로 형변환된 result의 i값이 된다.
		} // end for
		System.out.println(sum); // sum값을 출력

	} // end main()

} // end Homework04_1
