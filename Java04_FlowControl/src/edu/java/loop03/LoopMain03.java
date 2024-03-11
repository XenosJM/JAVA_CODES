package edu.java.loop03;

import java.util.Scanner;

public class LoopMain03 {

	public static void main(String[] args) {
		System.out.println("JAVA 은행");
		Scanner sc = new Scanner(System.in);
		
		boolean run = true; // while문 종료 여부를 나타내는 변수
		int balance = 0; // 계좌 잔액을 나타내는 변수. while문 안에서 무한 루프되면서 계속 0으로 초기화 되기 때문에 while문 밖으로 빼줘야한다.
		while(run) { // run이 true일 때 루프를 반복한다. 변수 run이 false로 변할 경우 종료된다.
		    System.out.println("---------------------------------");
		    System.out.println("1. 입금 | 2. 출금 | 3. 잔고 | 4. 종료");
		    System.out.println("---------------------------------");
		    System.out.println("선택>");
		    
		    int choice = sc.nextInt(); // 사용자의 선택을 저장하는 변수
		    switch(choice) {
		        case 1:
		            System.out.println("예금액>");
		            int money = sc.nextInt(); // 입금할 금액을 입력받는 변수. 변수선언 시 int를 넣어주면 새로운 변수를 선언하는 것이고, int를 제외하면 이미 선언된 변수를 사용하는 것이다.
		            balance += money; // 입금액을 계좌 잔액에 더한다.
		            break;
		        case 2:
		            System.out.println("출금액>");
		            money = sc.nextInt(); // 출금할 금액을 입력받는 변수. 이미 선언된 money 변수를 사용한다.
		            balance -= money; // 출금액을 계좌 잔액에서 뺀다.
		            if(balance < 0) {
		                System.out.println("잔고가 부족합니다.");
		            }
		            break;
		        case 3:
		            System.out.println("잔고> " + balance); // 현재 계좌의 잔액을 출력한다.
		            break;
		        case 4:
		            System.out.println("종료합니다.");
		            run = false; // 프로그램을 종료하기 위해 run 변수를 false로 변경한다.
		            break;
		        default:
		            break;    
		    }
		}
		
		
		

	} // end main()

}// end LoopMain03

// 1. 선택화면 출력한다.
// 2. 선택화면 출력을 반복한다.
//  ㄴ 종료를 선택하면 출력이 종료된다.
// 3. 사용자가 선택할 수 있도록 변수 선언
// ㄴ 변수의 타입 : 숫자
// ㄴ 선택지 개수 : 4개