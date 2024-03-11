package edu.java.homework;

// 문제 이해를 제대로 못해서 클래스를 만들고 메인까지 다시 만듬...

public class MemberService {

	// 만들어진 메인을 바탕으로 만들어진 클래스
	public boolean login(String id, String password) {
		// id, password는 주소값이 전송됨
		// id == "hong" : 주소값 비교
		// id.equals("hong") : 실제 데이터 비교
		// 참조값을 쓸 때는 equals를 사용 거의 무조건 해결
		// 리터럴값은 주소값이 정해져있어서 equals가 아니면 해결이안됨
		if(id.equals("hong") && password.equals("1234")) { // 같으면
			return true;
		} else { // 다르면
			return false;
		}
	}

	public void logout(String id) {
		System.out.println(id + " 님이 로그아웃 되었습니다.");
		
	}

	// 글 제대로 안읽고 만든 클래스..
//	String id;
//	String passWord;
//	
//	public MemberService () {
//		
//	}
//	
//	public MemberService (String id, String passWord) {
//		this.id = id;
//		this.passWord = passWord;
//	}
//	
//	public boolean login() { 
//		return id.equals("hong") && passWord.equals("12345");
//		
//	}
//	
//	public void logout() {
//		if(id.equals("hong")) {
//			System.out.println("로그아웃 되었습니다.");			
//		} else {
//			System.out.println();
//		}
//	}

}
