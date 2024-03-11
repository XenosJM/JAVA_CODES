package edu.java.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		System.out.println("배열 연습2");
		
		boolean[] arr1 = {true, false, true, false};
		
		for(boolean b : arr1) {
			System.out.println(b);
		}
		
		System.out.println("====================");
		// arr1 배열에 저장되어 있는 값이 true면
		//	ㄴ "참"이라는 문자열을 배열에 저장
		// arr1 배열에 저장되어있는 값이 false면
		//	ㄴ "거짓"이라는 문자열을 배열에 저장
		String[] arr2 = new String[4];
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == true) { // == if(arr1[i]) 같은 코드
				arr2[i] = "참";
			} else {
				arr2[i] = "거짓";
			}
		}
		for(String result : arr2) {
			System.out.println(result);
		}
		

	} // end main()

} // end ArrayMain06





