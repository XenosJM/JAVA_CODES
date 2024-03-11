package edu.java.contact04;

import java.util.List;

/* * 인터페이스 DAO 메소드 설계 방식
 * - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
 * - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
 * - 함수의 이름 : 역할에 따라 이름 작성 
 */

public interface ContactDAO {

	// 연락처 정보 등록
	public abstract int insert(ContactVO vo);
	// 입력을 한다. ContactDTO dto에
	
	// 연락처 정보 전체 검색
	public abstract List<ContactVO> select();
	
	// 연락처 정보 인덱스 검색
	public abstract ContactVO select(int index);
	
	// 연락처 정보 인덱스 수정
	public abstract int update(int index, ContactVO vo);
	
	// 연락처 정보 인덱스 삭제
	public abstract int delete(int index);
	
	// 등록된 연락처 정보를 파일에 저장

	// 파일에 저장된 연락처 정보를 불러오기

}
