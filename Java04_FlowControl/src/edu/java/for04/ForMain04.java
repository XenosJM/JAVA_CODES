package edu.java.for04;

public class ForMain04 {

	public static void main(String[] args) {
		// 1 ~ 10까지 더하시오.

		// 컴퓨터가 계산하는 방식 :
		// sum1 = 0
		// sum1 = sum1 + 1
		// sum1 = sum1 + 2
		// sum1 = sum1 + 3
		// ...

		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			sum1 = sum1 + i;
		}
		System.out.println(sum1);

		// 1 ~ 100 까지의 숫자 중 짝수들의합을 출력
		// 2 + 4 + 6 + 8 + ... + 96 + 98 + 100

		// 1 ~ 100까지 반복한다.
		// 그 중 짝수만 선택한다.
		// 선택한 수를 합한다.
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 = sum2 + i;
			}
		}
		System.out.println(sum2);

	} // end main()

} // end ForMain04
