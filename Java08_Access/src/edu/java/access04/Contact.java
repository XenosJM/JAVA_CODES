package edu.java.access04;

// 데이터 클래스(번호, 이름, 전화번호, 이메일)
public class Contact {
	// 멤버 변수
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public Contact() {} // 기본 생성자

	public Contact(int no, String name, String phone, String email) { // source 버튼에서 생성 가능
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	
	// 각 변수에 맞는 getter와 setter 메소드들
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() { // 모든 변수값을 나타내는 메소드
		return "Contact [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	
} // end Contact
