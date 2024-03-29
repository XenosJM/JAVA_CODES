package edu.java.project;

import java.util.ArrayList;

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
//	- PC 등록
	public abstract int insertPc(PcVO pc);
//	- 주문 추가
	public abstract int insertOrder(OrderVO ov);
//	- 기록 검색 select
	public abstract ArrayList<HistoryVO> selectHist();
//	- 회원 내역 검색 - 기본을 관리자, 다른 메소드를 정의해서 사용자용으로 만들것
	public abstract ArrayList<MemberVO> selectMem();	
//	- 상품 검색
	public abstract ArrayList<ProductVO> selectProd();
//	- 상품 종류별 검색 select
	public abstract ArrayList<ProductVO> selectProdKind(String prodKind);
//	- PC 검색
	public abstract ArrayList<PcVO> selectPc();
//	- 주문 검색 - 현재 활성화된 주문의 내역들만 볼수있게
	public abstract ArrayList<OrderVO> selectOrder();
//	- 기록 상세 검색 select
	public abstract HistoryVO selectHist(int histNumber);
//	- 회원 정보 상세 검색 select
	public abstract MemberVO selectMem(String memberId);
//	- 회원 정보 아무거나 검색
	public abstract MemberVO selectMemAni(int memberNumber, String memberId, String memberName);
//	- 상품 정보 상세 검색 select
	public abstract ProductVO selectProd(String prodName);
//	- PC 정보 상세 검색 select
	public abstract PcVO selectPc(int pcNumber);
//	- 주문 내역 상세 검색 select
	public abstract OrderVO selectOrder(int orderNumber);
//	- 기록 수정 update
	public abstract int updateHist(int histNumber, HistoryVO hv);
//	- 회원 정보 수정 update - 관리자용
	public abstract int updateMem(String memberId, MemberVO mv);
//	- 회원 정보 수정 update - 유저용
	public abstract int updateMemUser(String memberId, MemberVO mv);
//	- 회원 시간 정보 변동 TODO 시간 변동 사항 저장할 쿼리를 이용하기위한 임플 작성및 기능 멤버 로그인에 만들기
	public abstract int updateTime(String memberId, int memberTime);
//	- 상품 정보 수정 update	
	public abstract int updateProd(int prodNumber, ProductVO pv);
//  - 상품 판매 수정 update
	public abstract int updateProdUser(int prodNumber, ProductVO pv);
//	- PC 정보 수정 update
	public abstract int updatePc(int pcNumber, PcVO pc);
//  - 기록 정보 삭제 delete
	public abstract int deleteHist(int histNumber);
//	- 회원 정보 삭제 delete 	
	public abstract int deleteMem(int memberNumber);
//	- 상품 정보 삭제 delete
	public abstract int deleteProd(int prodNumber);
//	- PC 정보 삭제 delete
	public abstract int deletePc(int pcNumber);
//	- 주문 내역 삭제(주문취소)
	public abstract OrderVO selectOrderChk(String orderMemId);
//	- 주문 취소
	public abstract int orderCancel(int orderNumber);
//	- 키워드 검색
	public abstract ArrayList<ProductVO> selectSearchByText(String keyword);
	


	
//	- 구매 가격판매 가격 제외한 내용 업데이트
	
//	- 상품 판매
	
//	- 회원 정보 창
	
//	- 회원 남은 시간 추가 기능(상품결제와는 다르게 추가로)
	
//	- PC사용 현황 체크
	
//	- PC사용 정보 수정
	
	
	
}
