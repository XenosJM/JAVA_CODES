package edu.java.interface06;

import java.util.Scanner;

/* MVC 디자인 패턴에서 View 클래스
 * - UI를 담당하는 역할
 * * 현재 시스템은 규모가 작으므로 Controller 역할도 수행
 */
public class MemberMain {
	private static Scanner sc;
	private static MemberDAO dao; // MemberDAOImple 인스턴스를 저장할 변수
	
	public static void main(String[] args) {
		System.out.println("회원 관리 프로그램");
		sc = new Scanner(System.in);
		
		dao = MemberDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성
		
		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case Menu.INSERT:
				insertMember();
				break;
			case Menu.SELECT_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;
			case Menu.UPDATE:
				updateMember();
				break;
			case Menu.QUIT:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("다시 선택해주세요.");
				break;
			}
		} // end while
		
		sc.close();
	} // end main()

	private static void updateMember() {
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) {
			System.out.println("비밀번호 입력");
			String pw = sc.next();
			System.out.println("이메일 입력");
			String email = sc.next();
			
			MemberVO vo = new MemberVO("", pw, email);
			int result = dao.update(index, vo);
			if (result == 1) {
				System.out.println("회원 정보 수정 완료");
			}
		} 
	} // end updateMember

	private static void selectByIndex() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) {
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("존재하지 않는 인덱스 입니다.");
		}
		
	} // end selectByindex

	private static void selectAll() {
		MemberVO[] list = dao.select();
		
		int count = ((MemberDAOImple)dao).getCount();
		for(int i = 0; i < count; i++) {
			System.out.println("회원 정보 [" + i + "]");
			System.out.println(list[i]); // 에러가 났을때 내가 만든 클래스중 가장 위에것이 문제의 시작점.
		}
	} // end selectAll

	private static void insertMember() {
		System.out.println("--- 회원 정보 등록 ---");
		System.out.println("아이디 입력>");
		String id = sc.next();
		System.out.println("비밀번호 입력>");
		String pw = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();
		
		MemberVO vo = new MemberVO(id, pw, email);
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("회원 정보 등록 완료");
		}
		
	} // end insertMember()

	private static void showMainMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체 검색 | 3. 상세 검색 | 4. 수정 | 0. 종료");
		System.out.println("--------------------------------------------------");
		System.out.println("선택>");
	} // end showMainMenu

} // end MemberMain
