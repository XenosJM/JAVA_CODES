package edu.java.homework;

import java.util.Scanner;

public class 박정민_HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//================================================ 1번 내 코드
		// 과제 1 : 배열 6 8 4 2 5의 값 중에 최대값 출력하기
		// * 배열 직접 선언할 것!
		int[] arr = new int[5];
		int max = Integer.MIN_VALUE; // int중 가장 작은 값으로 해야 입력한 값중 최대값을 구할수있다.
		
		for(int i = 0; i < arr.length; i++) { // 선언된 배열의 길이만큼만 i값이 증가
			arr[i] = sc.nextInt(); // arr배열의 길이 만큼의 인덱스에 입력한 값을 초기화(저장?)
				if (arr[i] > max) { // 배열에 저장된 값이 max보다 큰경우
					max = arr[i];				
//				System.out.println("(" + i +") = " + arr[i]); 배열에 입력한 값이 제대로 들어갔는지 확인용 출력
		}
	}
		System.out.println("이중 최대값은 = " + max); // 최대값 출력
		
		System.out.println();
		
		// -------------------------------------------------- 강사님 코드
		
		int [] array1 = {6, 8, 4, 2, 5};
		int max1 = array1[0];
		for (int i = 1; i < array1.length; i++) {
			if (array1[i] > max1) {
				max1 = array1[i];
			}
		}
		System.out.println(max1);
		
		// ================================================ 과제 2번 내 코드
		
		// 과제 2 : 배열 ( 6 8 4 2 5)의 전체 합과 평균 값을 구하기
		int[] arr1 = new int [5]; // 배열 선언
		int avg = 0;
		int sum = 0;
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
			sum += arr1[i]; // 합산 값
			avg = sum / 5; // 평균 값
		}
		System.out.println("합계 = " + sum);
		System.out.println("평균 = " + avg);
		
		System.out.println(); // 줄바꿈
		
		// ----------------------------------------------- 강사님 코드
		
		int sum1 = 0;
		for(int i = 0; i < array1.length; i++) {
			sum1 += array1[i];
		}
		double avg1 = ((double) sum1) / array1.length;
		System.out.println("합 = " + sum1);
		System.out.println("평균 = " + avg1);
		
		
		// ================================================ 내 코드
		
		// 과제 3 : 피보나치 수열 20개를 출력
		// 피보나치(Fibonacci) 수열 : 1, 1, 2, 3, 5, 8, 13, 21, ...
		// 힌트)
		// f[0] = 1
		// f[1] = 1
		// f[n] = f[n-1] + f[n-2], n >= 2
		// 1) 정수 20개를 저장할 수 있는 배열 선언
		// 2) 배열의 인덱스 0번째, 1번째 원소는 1로 초기화
		// 3) 배열의 인덱스 2번째 원소부터 19번째 원소까지는 반복문을 사용해서 초기화
		// 4) 배열의 내용을 출력
		
		int[] f = new int[20]; // 배열 선언
		for(int i = 0; i < f.length; i++) { 
			f[0] = 1; // f[0]과 f[1]의 값을 1로 초기화
			f[1] = 1;
			if (i >= 2) { // i 값이 0 또는 1로 시작하면 -1값이 배열로 들어가면서 index -1 out of bounds for length
				f[i] = f[i-1]+f[i-2]; // 오류가 나므로 2 이상부터 계산식이 실행되게 한다
			}
				System.out.println("(" + i +") = " + f[i]); // 배열에 입력한 값이 제대로 들어갔는지 확인용 출력 
		}
		
		System.out.println();
		
		// -------------------------------------------------- 강사님 코드
		// 1) 정수 20개를 저장할 수 있는 배열 선언
		int[] f1= new int[20];
		// 2) 배열의 인덱스 0번째, 1번째 원소는 1로 초기화
		f1[0] = 1;
		f1[1] = 1;
		
		// 3) 배열의 인덱스 2번째 원소부터 19번째 원소까지는 반복문을 사용해서 초기화
		for (int i = 2; i < 20; i++) {
			f1[i] = f1[i-1] + f1[i-2];
			System.out.println("(" + i +") = " + f1[i]);
		}
		System.out.println();
		// 4) 배열의 내용을 출력
		
		// ================================================= 내가 한 코드...
		
		// 과제 4 : 아래 2차원 배열의 전체 합과 평균, 최대값 구하기
//		int [][] arr2 = {
//				{95, 86},
//				{44, 22, 96},
//				{78, 83, 93, 87, 88}
//		};
		
			// 1. 2차원 배열의 전체 합을 구하기
		
//		int avg1 = 0;
//		int sum1 = 0;
//		for (int[] group : arr2) { 
//		    for (int array2 : group) {
//		        System.out.print(array2 + " "); // 문자열과 공백을 출력합니다.
//		        System.out.println();
//		        
//		        for(int i1 = 0; i1 < array2; i1++) {
//		        	for(int j1 = 0; j1 < array2; j1++) {
//		        		sum1 += array2;
//		        		 System.out.println(sum1);
//		        	}
//		        }
//			}
//		}
//		System.out.println();
		
		// ----------------------------------------------------- 강사님 코드
		int[][] arr2 = {
			    {95, 86},
			    {44, 22, 96},
			    {78, 83, 93, 87, 88}
			};
			int c = 0; // 요소의 개수를 세기 위한 변수를 초기화합니다.
			int sum2 = 0; // 요소들의 합을 저장할 변수를 초기화합니다.

			// 2차원 배열의 요소들을 출력하고, 각 요소를 누적하여 합을 구합니다.
			for (int i = 0; i < arr2.length; i++) {
			    for (int j = 0; j < arr2[i].length; j++) {
			        System.out.print(arr2[i][j] + " "); // 배열의 요소를 출력합니다.
			        sum2 += arr2[i][j]; // 배열의 요소를 합에 더합니다.
			        c++; // 요소의 개수를 증가시킵니다.
			    }
			    System.out.println(); // 한 행이 끝나면 줄을 바꿉니다.
			}

			System.out.println("전체 합: " + sum2); // 배열의 모든 요소의 합을 출력합니다.
			System.out.println("평균: " + ((double) sum2) / c); // 배열의 모든 요소의 평균을 출력합니다.

			int max2 = Integer.MIN_VALUE; // 최대값을 저장할 변수를 초기화합니다.
			// 2차원 배열의 요소들 중에서 최대값을 찾습니다.
			for (int i = 0; i < arr2.length; i++) {
			    for (int j = 0; j < arr2[i].length; j++) {
			        if (arr2[i][j] > max2) { // 현재 요소가 최대값보다 큰지 확인합니다.
			            max2 = arr2[i][j]; // 최대값을 현재 요소로 업데이트합니다.
			        }
			    }
			}

			System.out.println("최대값 = " + max2); // 최대값을 출력합니다.
		
		// 보너스 : 코드업 1402, 1403, 1405, 1411
		
		
		
	} // end main()

} // end 박정민_HW2





