package edu.java.file04;

import java.io.Serializable;

/* 객체(Object) 타입을 파일에 쓰거나, 파일에서 읽어오고 싶을 때
 * Serializable 인터페이스를 구현하는 클래스로 선언
 * Serializable는 데이터 스트림의 직렬화를 통해 상호작용을 돕는다.
 */
public class ContactVO implements Serializable {
	// 멤버(필드) 변수
	private int no;
	private String id;
	private String pw;
	
	// 기본 생성자
	public ContactVO() {
		super();
		
	}
	// 매개변수가 있는 생성자
	public ContactVO(int no, String id, String pw) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", pw=" + pw + "]";
	}
	
} // end MemberVO
