package edu.java.homework;

import java.util.Scanner;

public class 박정민_HW1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		1. 반복문을 사용해서, 'A'부터 'Z'까지 출력하는 프로그램
		for(char i = 'A'; i <= 'Z'; i++) { // i의 변수를 char로 지정
			System.out.print(i + " ");
		}
		
		
		
//		2. While문과 Math.random() 함수를 이용해서 두 개의 주사위를 던졌을 때 나오는
//		눈의 합이 5이면 실행을 멈추고 5가 아니면 주사위를 계속 던지는 코드를 작성
//		예시) 합의 5가 나올때까지 아래와 같이 실행
//		(1, 3)
//		(2, 6)
//		(3, 1)
//		(4, 1) 끝
		
		System.out.println();
		
		while (true) {
			// random() : 0 <= x < 1 사이의 난수 발생
			double rX = Math.random();
			double rY = Math.random();

			// 0 + 1 * 6 <= x * 6 < 7(6.999999...)
			int x = (int) (6 * rX + 1);
			int y = (int) (6 * rY + 1);
			
			System.out.println("(" + x + ", " + y +")");
			if (x + y == 5) {
				System.out.println("주사위 눈의 합이 5가 나왔습니다.");
				break;
			}
		}
		
		
//		3. 숫자가 1 + (-2) + 3 + (-4) + 5 + ... + n 형태로 더해진다. 
//		(n은 값이 정해지지 않았음)
//		sum = 1 + (-2) + 3 + (-4) + 5 + ... + n 의 값이 100 이상으로 넘어갔을 때의 
//		n의 값과 sum의 값을 출력
		
		// 규칙 : 결국 sum값은 홀수 - 짝수가된다.
		// i가 n까지 숫자중 결국 홀수 - 짝수이기에 홀수 먼저 구하고 짝수를 빼면 된다. 홀수는 i+2이고 짝수는 i+1이다
		
		int n = sc.nextInt();
		int sum = 0;
		while(true) {
			if(n % 2 == 1) {
				sum = sum + n;
			} else {
				sum = sum - n;
			}
			if(sum >= 100) {
				break;
			}
			n++;
		}
		System.out.println("sum = " + sum + ", n = " + n);
		
		
		// ================================================
		
//		int n = sc.nextInt();
//		int sum = 0;
//		int i = 1;
//		for(i=1; i<=n; i++) { //1부터 시작해 n까지 1씩 증가시키면서 반복한다.
//			  if(i%2 == 0) // i가 짝수면 건너띄고 계산한다.
//				  continue; 
//			  int sum1 = sum+=i;
//		}
//		System.out.println(sum1);	
//		
//		for (i=1; i <= n; i++) {
//			if(i%2 == 1) // i가 홀수면 건너띄고 계산
//				continue;
//			int sum2 = sum += i;
//		}
//		System.out.println(sum2);
//		==================================================
//		for(int i = 1; i <= n; i++) {
//			sum += i;
//			System.out.println(sum);  // 의도는 i값이 2의 배수일때는 -1을 곱한값을 i에 저장하고나서 다시 위에 sum 계산식이 실행되는것
//			if(i%2==0) { 			  // 이었으나 제대로 안됨
//				i=i*-1;
//				System.out.println(sum);
//			}
//		}
		
//		4. 다음과 같이 출력하는 프로그램(보너스 문제)
//		*
//		**
//		***
//		****
//		*****
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i >= j)
					System.out.print("*");
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i > j) {
					System.out.print(" ");
					
				} else {
					System.out.print("*");
				}	
			}	
		}
			
		
		
//		*****
//		 ****
//		  ***
//		   **
//		    *
		
		
	} // end main()

	private static void printf(String string, double i) {
		// TODO Auto-generated method stub
		
	}

} // end 박정민_HW1


