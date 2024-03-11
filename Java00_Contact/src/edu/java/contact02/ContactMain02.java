package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("연락처 프로그램 version 0.2");
		
		boolean run = true; // 
		while(run) { // run이 참일동안 반복 실행
			sc = new Scanner(System.in);
			showMainMenu();
			
			int choice = sc.nextInt();
			switch(choice) {
			case Menu.INSERT:
				insertInfo();
				break;
			case Menu.SELECT_ALL:
				break;
			case Menu.SELECT_BY_INDEX:
				break;
			case Menu.UPDATE_INDEX:
				break;
			case Menu.QUIT:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("다시 선택하세요.");
				break;
			
			} // end switch
			
		} // end while
		
	} // end showMainMenu

	private static void insertInfo() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력>");
		String name = sc.next(); // 연락처에 들어갈 이름 입력
		System.out.println("전화번호 입력>");
		String phone = sc.next(); // 연락처에 들어갈 전화번호 입력
		System.out.println("이메일 입력>");
		String email = sc.next(); // 연락처에 들어갈 이메일 입력
		
	}

	private static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");		
	} // end showMainMenu

} // end ContactMain02
