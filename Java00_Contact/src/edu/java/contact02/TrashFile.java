package edu.java.contact02;

public class TrashFile {

//	package edu.java.contact02;
//
//	/* * 인터페이스 DAO 메소드 설계 방식
//	 * - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
//	 * - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
//	 * - 함수의 이름 : 역할에 따라 이름 작성 
//	 */
//
//	public interface ContactDAO {
//		
//			// 연락처 정보 등록
//			public abstract int insert(ContactDTO dto);
//			// 입력을 한다. ContactDTO dto에
//			
//			// 연락처 정보 전체 검색
//			public abstract ContactDTO[] select();
//			
//			// 연락처 정보 인덱스 검색
//			public abstract ContactDTO select(int index);
//			
//			// 연락처 정보 인덱스 수정
//			public abstract int update(int index, ContactDTO dto);
//
//	}
	
//	package edu.java.contact02;
//
//
//	public class ContactDAOImple implements ContactDAO {
//		
//		// 싱글톤 디자인 패턴 적용
//			// 1. private static 자기 자신 타입의 변수 선언
//			private static ContactDAOImple instance = null;
//			// 2. private 생성자
//			private ContactDAOImple() {}
//			// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
//			public static ContactDAOImple getInstance() {
//				if(instance == null) {
//					instance = new ContactDAOImple();
//				}
//				return instance;
//			} // end 메소드
//			
//			private final int MAX = 100; // 최대 회원수
//			private ContactDTO[] contact = new ContactDTO[MAX]; // 회원 정보를 저장할 배열
//			private int count; // 배열에 저장될 데이터 개수
//			
//			public int getCount() {
//				return count;
//			}
//		
//
//		@Override
//		public int insert(ContactDTO dto) {
//			System.out.println("insert()");
//			System.out.println("dto = " + dto);
//			contact[count] = dto;
//			count++;
//			return 1;
//			
//		}
//
//		@Override
//		public ContactDTO[] select() {
//			System.out.println("select()");
//			return contact;
//		}
//
//		@Override
//		public ContactDTO select(int index) {
//			System.out.println("select(int index)");
//			return contact[index];
//		}
//		@Override
//		public int update(int index, ContactDTO dto) {
//			System.out.println("update");
//			contact[index].setName(dto.getName()); // index에 위치한 이름을 바꾼다.
//			contact[index].setPhone(dto.getPhone()); // index에 위치한 전화번호를 바꾼다.
//			contact[index].setEmail(dto.getEmail()); // index에 위치한 이메일을 바꾼다.
//			return 1;
//		}
//
//	}

//	package edu.java.contact02;
//
//	public class ContactDTO {
//		
//			// 멤버 변수	
//			String name;
//			String phone;
//			String email;		
//			
//			public ContactDTO() { // 기본 생성자
//				super();
//			}
//
//			public ContactDTO(String name, String phone, String email) { // 매개변수 생성자
//				super();
//				this.name = name;
//				this.phone = phone;
//				this.email = email;
//			}
//				// getter, setter들
//			public String getName() { 
//				return name;
//			}
//
//			public void setName(String name) {
//				this.name = name;
//			}
//
//			public String getPhone() {
//				return phone;
//			}
//
//			public void setPhone(String phone) {
//				this.phone = phone;
//			}
//
//			public String getEmail() {
//				return email;
//			}
//
//			public void setEmail(String email) {
//				this.email = email;
//			}
//
//
//
//			@Override
//			public String toString() {
//				return "ContactDTO [name=" + name + ", phone=" + phone + ", email=" + email + "]";
//			}
//			
//			
//			
//	}
	
//	package edu.java.contact02;
//
//	import java.util.Scanner;
//
//	public class ContactMain02 {
//		private static Scanner sc;
//		private static ContactDAO dao;
//
//		public static void main(String[] args) {
//			System.out.println("연락처 프로그램 version 0.2");
//			sc = new Scanner(System.in);
//
//			dao = ContactDAOImple.getInstance();
//			
//			boolean run = true;
//			while (run) {
//				showMainMenu();
//				int choice = sc.nextInt();
//				switch (choice) {
//				case Menu.INSERT: // 메뉴 입력
//					insertMenu();
//					break;
//				case Menu.SELECT_ALL: // 모든 연락처 조회
//					selectAll();
//					break;
//				case Menu.SELECT_BY_INDEX: // 선택한 인덱스의 연락서 조회
//					selectByIndex();
//					break;
//				case Menu.UPDATE_INDEX: // 선택한 인덱스 정보 변경
//					updateIndex();
//					break;
//				case Menu.QUIT:
//					System.out.println("프로그램을 종료합니다.");
//					run = false;
//					break;
//				default:
//					System.out.println("다시 선택해 주세요.");
//					break;
//				}// end switch
//			} // end while
//			sc.close();
//		} // end main()
//
//		
//		private static void updateIndex() {
//			System.out.println("인덱스 입력>");
//			int index = sc.nextInt();
//			
//			int count = ((ContactDAOImple)dao).getCount();
//			if(index >= 0 && index < count) {
//				System.out.println("이름 입력");
//				String name = sc.next();
//				System.out.println("전화번호 입력");
//				String phone = sc.next();
//				System.out.println("이메일 입력");
//				String email = sc.next();
//				
//				ContactDTO dto = new ContactDTO(name, phone, email);
//				System.out.println("log");
//				int result = dao.update(index, dto);
//				if (result == 1) {
//					System.out.println("회원 정보 수정 완료");
//				}
//			} 
//		} // end updateIndex
//
//
//		private static void selectByIndex() {
//			System.out.println("검색할 인덱스 입력>");
//			int index = sc.nextInt();
//			
//			int count = ((ContactDAOImple)dao).getCount();
//			if(index >= 0 && index < count) {
//				ContactDTO dto = dao.select(index);
//				System.out.println(dto);
//			} else {
//				System.out.println("존재하지 않는 인덱스 입니다.");
//			}
//		} // end selectByindex
//
//
//		private static void selectAll() {
//			ContactDTO[] list = dao.select();
//			
//			int count = ((ContactDAOImple)dao).getCount();
//			for(int i = 0; i < count; i++) {
//				System.out.println("회원 정보 [" + i + "]");
//				System.out.println(list[i]);
//			}
//		} // end selectAll
//
//
//		private static void insertMenu() {
//			System.out.println("-------------");
//			System.out.println("연락처 등록 메뉴");
//			System.out.println("-------------");
//			System.out.println("이름 입력>");
//			String name = sc.next(); // 연락처에 들어갈 이름 입력
//			System.out.println("전화번호 입력>");
//			String phone = sc.next(); // 연락처에 들어갈 전화번호 입력
//			System.out.println("이메일 입력>");
//			String email = sc.next(); // 연락처에 들어갈 이메일 입력
//					
//			ContactDTO contact = new ContactDTO(name, phone, email);
//			int result = dao.insert(contact);
//		//	int count = ((ContactDAOImple)dao).getCount();
//			if(result == 1) {
//				System.out.println("회원 정보 등록 완료");
//			}
//		} // end insertMenu
//
//		private static void showMainMenu() {
//			System.out.println("------------------------------------------------");
//			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
//			System.out.println("------------------------------------------------");
//			System.out.println("선택>");
//		} // end showMainMenu
//
//	} // end ContactMain02

//	package edu.java.contact02;
//
//	public interface Menu {
//		public static final int QUIT = 0; // 종료
//		int INSERT = 1; // 등록
//		int SELECT_ALL = 2; // 전체 검색
//		int SELECT_BY_INDEX = 3; // 상세 인덱스검색
//		int UPDATE_INDEX = 4; // 인덱스 수정
//
//	}

// menu ->

}
