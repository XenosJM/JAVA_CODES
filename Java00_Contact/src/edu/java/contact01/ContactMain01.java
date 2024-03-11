package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SELECT_ALL = 2; // 전체 검색
	public static final int MENU_SELECT = 3; // 상세 검색
	public static final int MENU_UPDATE = 4; // 수정

	public static final int MAX = 100; // 연락처 최대 저장 개수 - 유지보수 측면에서 유리
	// 연락처 저장 배열
	public static Contact[] contactList = new Contact[MAX];
	// Contact 클래스를 사용하여 크기가 MAX인 배열을 생성하여 contactList에 할당
	public static int count = 0; // 배열에 데이터를 저장하면 증가

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("연락처 프로그램 version 0.1");

		boolean run = true; // while문 종료 여부를 나타내는 변수
		while (run) { // run이 true일 때 루프를 반복한다. 변수 run이 false로 변할 경우 종료된다.
			System.out.println("------------------------------------------------");
			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택>");

			int choice = sc.nextInt(); // 사용자의 선택을 저장하는 변수
			switch (choice) {
			case MENU_INSERT:
				System.out.println("-------------");
				System.out.println("연락처 등록 메뉴");
				System.out.println("-------------");
				System.out.println("이름 입력>");
				String name = sc.next(); // 연락처에 들어갈 이름 입력
				System.out.println("전화번호 입력>");
				String phone = sc.next(); // 연락처에 들어갈 전화번호 입력
				System.out.println("이메일 입력>");
				String email = sc.next(); // 연락처에 들어갈 이메일 입력
				Contact contact = new Contact(name, phone, email);
				// 입력받은 연락처가 저장되는 배열

				// 1) 연락처 등록(배열에 저장) : 배열 크기는 100
				// - 0번 인덱스부터 순차적으로 저장 : 0, 1, 2, 3, 4
				for (int i = 0; i < MAX; i++) {
					// i값이 MAX(100으로 초기화 되있는)보다 작거나 같을때까지 i값이 증가
					if (i == count) { // i가 count값과 같아지면 contactList 배열의 i번자리에 초기화
						contactList[i] = contact;
					}
				}
//		            System.out.println(count + "번째 연락처" + contactList[count]);
				// i번 자리에 초기화 된 값이 제대로 들어갔는지 확인
				count++; // i에 contact 값 초기화 후 count 값 1 증가
				System.out.println("등록된 연락처 개수" + count);
				// 올라간 count값만큼 연락처가 등록됨
				System.out.println("연락처 등록 완료!");
				break;
			case MENU_SELECT_ALL: // 등록된 모든 연락처 검색기능
				System.out.println("연락처 개수 : " + count);
				// 저장된 연락처의 개수 = count
				for(int i = 0; i < count; i++) {
					// 정수 i가 0부터 시작해 count값만큼 증가하면서 아래 내용 반복
					System.out.println("--- 연락처 " + i + " ---");
					System.out.println(contactList[i]);
					// contactList 배열의 i번째에 저장된 값 출력
				}
				break;
			case MENU_SELECT: // 등록된 연락처중 원하는 연락처 상세 검색
				System.out.println("---------------");
				System.out.println("검색할 인덱스 입력>");
				int n = sc.nextInt(); // 정수 n값을 입력받는다
				System.out.println(contactList[n]); // 입력받은 n값에 해당하는 인덱스의 값을 출력
				break;
			case MENU_UPDATE: // 등록된 연락처 수정하기
				System.out.println("---------------");
				System.out.println("수정할 인덱스 입력>");
				int m = sc.nextInt();
				System.out.println("이름 입력>");
				contactList[m].setName(sc.next()); 
				// 입력받은 m값에 해당하는 인덱스의 값중 변경할 내용의 이름을 입력
				System.out.println("전화번호 입력>");
				contactList[m].setPhone(sc.next()); 
				// 입력받은 m값에 해당하는 인덱스의 값중 변경할 내용의 전화번호를 입력
				System.out.println("이메일 입력>");
				contactList[m].setEmail(sc.next()); 
				// 입력받은 m값에 해당하는 인덱스의 값중 변경할 내용의 이메일을 입력
				System.out.println("연락처 수정 완료!");
//				System.out.println(contactList[m]);
				// setter 메소드를 이용해 변경한 인덱스값이 제대로 됬는지 확인용
				
				break;
			case MENU_QUIT:
				System.out.println("종료합니다.");
				run = false; // 프로그램을 종료하기 위해 run 변수를 false로 변경한다.
				break;
			default:
				break;
			}
		}
	} // end main()
} // end ContactMain01
