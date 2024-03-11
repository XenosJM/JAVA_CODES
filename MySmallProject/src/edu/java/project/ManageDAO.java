package edu.java.project;

import java.util.List;

public interface ManageDAO {
	
	/* * 인터페이스 DAO 메소드 설계 방식
	 * - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
	 * - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
	 * - 함수의 이름 : 역할에 따라 이름 작성
	 * 1, 2, 3번의 테이블이 있다.
	 * 그 중 1번의 테이블에는 2, 3번 테이블에 있는 컬럼과 같은
	 * 값이기 때문에 외래키로 사용하려한다. 그렇다면 1번 테이블에
	 * 데이터를 저장할때 2, 3번과 같은 컬럼들도 값이 들어가지는가?(변경되는가)
	 */
	
//	- 기록 insert( 누구에게 무엇을 언제 몇개를 얼마에 팔았다.)
	public abstract int insertHist(HistoryVO hv);
//	- 회원 추가 ( 가입, 등록) insert
	public abstract int insertMem(MemberVO mv);
//	- 재고 구매 ( 구매한 날짜, 가격, 갯수, 회사) insert
	public abstract int insertProd(ProductVO pv);	
//	- 기록 검색 select
	public abstract HistoryVO selectHist(int histNumber);
//	- 회원 정보 상세 검색 select
	public abstract MemberVO selectMem(int memberNumber);
//	- 상품 정보 상세 검색 select
	public abstract ProductVO selectProd(int prodNumber);
//	- 기록 수정 update
	public abstract int updateHist(int histNumber, HistoryVO hv);
//	- 회원 정보 수정 update - 관리자용
	public abstract int updateMem(int memberNumber, MemberVO mv);
//	- 상품 정보 수정 update	
	public abstract int updateProd(int prodNumber, ProductVO pv);
//	- 기록 상세 검색 select
	public abstract List<HistoryVO> selectHist();
//	- 회원 내역 검색 - 관리자용
	public abstract List<MemberVO> selectMem();	
//	- 상품 검색
	public abstract List<ProductVO> selectProd();
//  - 기록 정보 삭제 delete
	public abstract int deleteHist(int histNumber);
//	- 회원 정보 삭제 delete 	
	public abstract int deleteMem(int memberNumber);
//	- 상품 정보 삭제 delete
	public abstract int deleteProd(int prodNumber);
	

	
//	- 구매 가격판매 가격 제외한 내용 업데이트
	
//	- 상품 판매
	
//	- 회원 정보 창
	
//	- 회원 정보에서 관리자 체크 기능( 관리자인지 아닌지)	
	
//	- 로그인 기능( 관리자면 로그인 성공 아닐시 실패)
	
//	- 회원 남은 시간 추가 기능(상품결제와는 다르게 추가로)
	
//	- PC사용 현황 체크
	
//	- PC사용 정보 수정
	
	
	
}