package edu.java.project;

public interface OracleQuery {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_HISTORY = "EX_HISTORY";
	public static final String COL_H_NUMBER = "HISTORY_NUMBER";
	public static final String COL_H_DATE = "HISTORY_DATE";
	public static final String COL_MEMHIST = "MEMBER_HISTORY";
	public static final String COL_PRODHIST = "PRODUCT_HISTORY";
	public static final String COL_PCHIST = "PC_HISTORY";
	
	public static final String TABLE_MEMBER = "EX_MEMBER";
	public static final String COL_M_NUMBER = "MEMBER_NUMBER";
	public static final String COL_M_ID = "MEMBER_ID";
	public static final String COL_M_PW = "MEMBER_PW";
	public static final String COL_M_NAME = "MEMBER_NAME"; 
	public static final String COL_M_PHONE = "MEMBER_PHONE";
	public static final String COL_M_EMAIL = "MEMBER_EMAIL";
	public static final String COL_M_TIME = "MEMBER_TIME";
	public static final String COL_M_MANAGER_ID = "MANAGER_ID";
	
	public static final String TABLE_PRODUCT = "EX_PRODUCT";
	public static final String COL_P_NUMBER = "PRODUCT_NUMBER";
	public static final String COL_P_NAME = "PRODUCT_NAME";
	public static final String COL_P_INFO = "PRODUCT_INFO";
	public static final String COL_P_PRICE = "PRODUCT_SELL_PRICE";
	public static final String COL_P_QUANTITY = "PRODUCT_QUANTITY";
	
	String TABLE_PC = "EX_PC";
	String COL_PC_NUMBER = "PC_NUMBER";
	String COL_PC_INFO = "PC_INFO";
	String COL_PC_STATE = "PC_STATE";
	String COL_PC_M_NUM = "MEMBER_NUMBER";
	
	//=================================================== 히스토리 쿼리
	//  

			
						

		
		

		
		
			

		
		

		


		
		/*  TODO 상세검색 쿼리를 좀더 다양하게 짜야한다.
		 *  이를테면 선택 또는 정한 회원/상품정보의 히스토리가 나오도록
		 *  JOIN을 사용한 쿼리 만들것. 예를 들어 LIKE %판매%해서 어떤 상품이
		 *  얼마에 몇개 팔렸는지를 히스토리 내역 또는 어떤 사람이 어떤
		 *  재고관리 쿼리를 따로 만들어서 사용할것...판매 가격이나 구매 가격은 한버ㅏㄴ
		 *  정해지면 변할일이 잘 없으니 수정하거나 입력할때 빼고 사용될 쿼리...
		 */
		
}// END OracleQuery
