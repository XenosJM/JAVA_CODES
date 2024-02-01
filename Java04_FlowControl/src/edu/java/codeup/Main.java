package edu.java.codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		3 6 9 게임을 하던 영일이는 3 6 9 게임에서 잦은 실수로 계속해서 벌칙을 받게 되었다.
//		3 6 9 게임의 왕이 되기 위한 마스터 프로그램을 작성해 보자.
//
//		참고
//		중첩의 원리
//		반복 실행 구조 안에 선택 실행 구조를 자유롭게 중첩할 수 있다.
//
//		예시
//		int i;
//		for(i=1; i<=100; i++) //1부터 100까지 반복
//		{
//		  if(i%3==0 || i%5==0) printf("%d ", i); //3또는 5의 배수인 경우 그 수 출력
//		}
//
//		** 3 6 9 게임은?
//		여러 사람이 순서를 정해 순서대로 수를 부르는 게임이다.
//		만약 3, 6, 9 가 들어간 수를 자신이 불러야 하는 상황이면, 대신 "박수" 를 쳐야 한다.
//		33까지 진행했다면? "짝짝"과 같이 박수를 두 번 치는 형태도 있다.
		
		//1 부터 그 수까지 순서대로 공백을 두고 수를 출력하는데,
		//3 또는 6 또는 9인 경우 그 수 대신 영문 대문자 X 를 출력한다.
		// 3 6 9 마다 짝, 3 6 9 가 들어간 횟수만큼 짝
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			 if (i % 3 == 0) { // i를 3으로 나눈 몫이 0일때
				 System.out.print("X" + " "); // 짝을 출력
			 } else {
				 System.out.print(i + " ");
			 }
		}	 
	} // end main()

} // end Main
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		1, 2, 3 ... 을 계속 더해 나갈 때,
//		그 합이 입력한 정수(0 ~ 1000)보다 같거나 작을 때까지
//		계속 더하는 프로그램을 작성해보자.
//
//		즉, 1부터 n까지 정수를 계속 더한다고 할 때,
//		어디까지 더해야 입력한 수보다 같거나 커지는지 알아보고자 하는 문제이다.
		
		// 1 ~ 1000 까지의 숫자중 하나를 입력했을ㅐ
		// n을 입력하면 어디까지 더해야 n을 넘어서거나 같나 	//예시) 8을 입력하면 4까지만 더하면 나오도록
		
//		
//		int n = sc.nextInt(); // n은 '입력' 받는 정수		
//		int sum = 0;		
//		for (int i = 1; i <= 1000; i++) {
//			sum += i;
//			if(sum >= n) {
//				System.out.print(i + " ");
//				break;
//			}
//		}
//	}		
//		
		
			
			//
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			int c = sc.nextInt();
//			
//			if (a <= b) { // a 가 가장 작을 경우
//				if (a <= c) {
//					if (b <= c) {
//						System.out.println(a + " " + b + " " + c); // a b c
//					} else {
//						System.out.println(a + " " + c + " " + b); // a c b
//					}
//				} else {
//					System.out.println(c + " " + a + " " + b); // c a b
//				}
//			} else if (b <= c) {
//				if (b <= a) {
//					if (a <= c) {
//						// b a c
//					} else {
//						// b c a
//					}
//				} else {
//					// a b c
//				}
//			} else if (c <= a) {
//				if (c <= b) {
//					if (b <= a) {
//						// c b a
//					} else {
//						// c a b
//					}
//				} else {
//					// b c a
//				}
//			}

			// ==============================================================================

//			int first = 0;
//			int second = 0;
//			int third = 0;
//			// 변수 생성해 코드 정리 
//			
//			// && 사용한 코드
//			if (a <= b && a <= c) {
//				if (b <= c) {
//					first = a;
//					second = b;
//					third = c;
//				} else {
//					first = a;
//					second = c;
//					third = b;
//				}
//			} else if (b <= c && b <= a) {
//				if (a <= c) {
//					// b a c
//					first = b;
//					second = a;
//					third = c;
//				} else {
//					// b c a
//					first = b;
//					second = c;
//					third = a;
//				}
//			} else if (c <= a && c <= b) {
//				if (b <= a) {
//					// c b a
//					first = c;
//					second = b;
//					third = a;
//				} else {
//					// c a b
//					first = c;
//					second = a;
//					third = b;
//				}
	//
//			}
	//
//			System.out.println(first + " " + second + " " + third);
		
//	} // end main()
//
//} // end Main
