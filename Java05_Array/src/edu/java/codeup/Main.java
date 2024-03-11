package edu.java.codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 보너스 : 코드업 1402, 1403, 1405, 1411	
		
		// ===================================== 1403문제
		
//		k개의 숫자를 입력받고 그 숫자들을 두번 출력하시오.
		
		int k = sc.nextInt();
		int[] arr = new int[k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			System.out.println(arr[i]);
			
		}
		
		
		
		
		
		// ===================================== 1402문제  코드 정상 통과 확인.
		
		// 이번에는 데이터의 개수가 n개가 들어오고, n개의 데이터를 거꾸로 출력하는 프로그램을 작성하시오.
//		int n = sc.nextInt(); // n만큼 입력을 하겠다.
//		int[] arr = new int[n]; // arr 배열의 길이는 n만큼이다.
//		
//		for(int i = 0; i < n; i++) { // 배열 arr[i]의 길이는 n만큼이고 인덱스 i 값이 1씩 올라가며										
//			arr[i] = sc.nextInt();	 // n만큼 입력한 숫자가 순서대로 초기화된다.
//		}
//			
//		for(int i = n-1; i >= 0; i--) { // 초기화 되있는 배열 arr[i]의 값들을 인덱스 i값을 1씩 줄이며 출력한다.
//			System.out.print(arr[i] + " ");
//		}
		
		
		
		
		
		
//		1 2 3 4 5 -> 0, 1, 2, 3, 4 -> 0, 1, 2, 3, 4 규칙성 찾기
//		
//		2 3 4 5 1 -> 1, 2, 3, 4, 0 -> 1, 2, 3, 4, 5
//		
//		3 4 5 1 2 -> 2, 3, 4, 0, 1 -> 2, 3, 4, 5, 6
//		
//		4 5 1 2 3 -> 3, 4, 0, 1, 2 -> 3, 4, 5, 6, 7
//		
//		5 1 2 3 4 -> 4, 0, 1, 2, 3 -> 4, 5, 6, 7, 8
		
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		for(int i = 0; i < n; i++) {
////			System.out.println("i = " + i);
//			for(int j = 0; j < n; j++) {
//				System.out.print(arr[(i + j)%n] + " ");
////				System.out.print("j = " + (i + j) % n + ", ");
//			}
//			System.out.println();
//		}
//		
		
		
		
		
		// ================================================
		
//		int n = sc.nextInt(); // 카드 갯수
//		
//		int [] cp = new int[51]; // 카드 번호 저장할 배열
//		
//		for(int i = 0; i < n - 1; i++) {
//			int a = sc.nextInt();
//			cp[a]++;
//		} 
//		
//		for (int i = 1; i <= n; i++) {
//			if(cp[i] == 0) {
//				System.out.println(i);
//			}
//		}
		
		
		
//	==================================================================
		
//		String str = sc.nextLine();
//		
//		for(int i = 0; i < str.length(); i++) {
//			if(str.charAt(i) != ' ') { // 문자열의 각 자리에 공백이 있는지 확인
//				System.out.print(str.charAt(i));
//			}
//		}
		
// ===================================================================		
		
//		int n = sc.nextInt();
//		
//		int[] arr = new int[24]; // 배열생성 첫 생성시 각 자리에는 0이 들어간다.
//		
//		for(int i = 0; i < n; i++) { // n번만큼 반복
//			int a = sc.nextInt();
//			arr[a] += 1; // 입력된 번호의 자리에 1씩 더한다.
//		}
//		
//		for(int i = 1; i <= 23; i++) {
//			System.out.print(arr[i]);
//		}
		

	} // end main()

} // end Main
