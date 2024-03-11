package edu.java.interface01;

public interface DataBaseQuery { // 기본적으로 껍데기만 사용
	// 인터페이스 멤버 변수 : public static final
	// 인터페이스는 객체 생성이 불가능하기 때문에 반드시 static이 있어야함.
	public static final int DATABASE_VERSION = 1;
	
	// 인터페이스의 메소드 : public abstract
	public abstract int insert(String id, String pw);
	
} // end DataBaseQuery





