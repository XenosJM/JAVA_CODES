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
	public static final String COL_ORDERHIST = "ORDER_HISTORY";
	
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
	public static final String COL_P_QTY = "PRODUCT_QUANTITY";
	
	String TABLE_PC = "EX_PC";
	String COL_PC_NUMBER = "PC_NUMBER";
	String COL_PC_INFO = "PC_INFO";
	String COL_PC_STATE = "PC_STATE";
	String COL_PC_M_NUM = "MEMBER_NUMBER";
	
	String TABLE_ORDER = "EX_ORDER";
	String COL_ORDER_NUM = "ORDER_NUMBER";
	String COL_ORDER_M_ID = "MEMBER_ID";
	String COL_ORDER_P_NAME = "PRODUCT_NAME";
	String COL_ORDER_P_QTY = "PRODUCT_QTY";
	//=================================================== 히스토리 쿼리
	// 데이터 등록
		public static final String SQL_H_INSERT = "INSERT INTO " + TABLE_HISTORY
				+ " VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, ?, ?, ?, ?, ?)";
//		// 회원 변동 내역 이용 정보
//		public static final String SQL_H_INSERT_M_HIST = "INSERT INTO " + TABLE_HISTORY +
//				" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, NULL, ?, ?, NULL, ?)";
		// 회원 내역중 상품구매에 들어갈 내용
		public static final String memProdHist = "? " + "회원님이 " + "? " + "을(를) " + "주문하셧습니다.";
		public static final String memPcHist = "? " + "회원님이 " + "? " + "자리에서 사용을 시작했습니다.";
		public static final String memTimeHist = "? " + "회원님이 " + "? " + "에 " + "?" + " 만큼 추가하셧습니다."; 
//		// 상품 변동내역 - 판매, 구매 또는 재고 변화에 관한 정보들 
//		public static final String SQL_H_INSERT_P_HIST = "INSERT INTO " + TABLE_HISTORY +
//				" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, ?, NULL, ?, ?, NULL)";
//		// 상품 변동내역 - 판매, 구매 또는 재고 변화에 관한 정보들 
//		public static final String SQL_H_INSERT_P_MANAGE_HIST = "INSERT INTO " + TABLE_HISTORY +
//				" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, NULL, ?, NULL, NULL, ?, NULL)";
//		// PC 변동 내역
//		public static final String SQL_H_INSERT_PC_HIST = "INSERT INTO " + TABLE_HISTORY +
//				" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, NULL, NULL, ?, NULL, NULL, ?)";
		// 히스토리 데이터 삭제
		public static final String SQL_H_DELETE = 
				"DELETE " + TABLE_HISTORY + " WHERE " + COL_H_NUMBER + " = ?";
		// 히스토리 전체 검색
		public static final String SQL_H_SELECT = 
		         "SELECT * FROM " + TABLE_HISTORY + " ORDER BY " + COL_H_NUMBER;
		// 히스토리 상세 검색
		public static final String SQL_SELECT_BY_H_NUMBER = 
				"SELECT * FROM " + TABLE_HISTORY + " WHERE " + COL_H_NUMBER + " = ?";	
		// 사용자 이용내역 상세 검색 (?에는 사용자 ID)
		public static final String SQL_SELECT_BY_USER_HISTORY = 
				"SELECT " + COL_H_NUMBER + ", " + COL_H_DATE + ", " + COL_MEMHIST + 
				", " + COL_ORDERHIST + " FROM " + TABLE_HISTORY + " WHERE " + COL_MEMHIST + " LIKE '%?%'";
		// 판매 기록 검색
		public static final String SQL_SELECT_BY_SELL_PROD = 
				"SELECT " + COL_H_NUMBER + ", " + COL_H_DATE + ", " + COL_PRODHIST + 
				" FROM " + TABLE_HISTORY + " WHERE " + COL_PRODHIST + " LIKE '%판매%'";
		// 관리자 상품관리(재고관리 내역 검색)
		public static final String SQL_SELECT_BY_MANAGE_HISTORY = 
				"SELECT " + COL_H_NUMBER + ", " + COL_H_DATE + ", " + COL_PCHIST +
				" FROM " + TABLE_HISTORY + " WHERE " + COL_PRODHIST + " NOT LIKE '%판매%' OR '%손실%'";	
		// PC 내역 상세 검색 (?에는 PC넘버)
		public static final String SQL_SELECT_BY_PC_HISTORY = 
				"SELECT " + COL_H_NUMBER + ", " + COL_H_DATE + ", " + COL_PCHIST + 
				" FROM " + TABLE_HISTORY + " WHERE " + COL_PCHIST + " LIKE '%?%'";	
		// PC 내역 전체 검색
		public static final String SQL_SELECT_PC_HISTORY = 
				"SELECT " + COL_H_NUMBER + ", " + COL_H_DATE + ", " + COL_PCHIST + 
				" FROM " + TABLE_HISTORY + " ORDER BY " + COL_H_NUMBER ;
		
		// ===========================================================
	
	public static final String SQL_M_INSERT_MANAGER = "INSERT INTO " + TABLE_MEMBER
			+ " VALUES (SEQ_MEMBER.NEXTVAL, 'admin', 'admin1234', '박정민', '010-1111-1111', wjdalstest@test.com', '0', '1')";
	// 회원 등록 - 기본적으로 시간과 관리자 여부는 0으로 고정
	public static final String SQL_M_INSERT = "INSERT INTO " + TABLE_MEMBER
			+ " VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, '0', '0')";
	// 사용자 내역에 들어갈 내용은 사용시간, 충전시간, 구매기록, 시작시간, 종료시간
	public static final String SQL_M_UPDATE_HIST = 
			"UPDATE " + TABLE_HISTORY + " SET " + 
					COL_MEMHIST + " = ? " + // ?에는 String 값
					"WHERE " + COL_H_NUMBER + " = ?";
	// 관리자 회원 정보 수정
//	public static final String SQL_M_UPDATE_MANAGER =  
//			"UPDATE " + TABLE_MEMBER + " SET " + 
//					COL_M_ID + " = ?, " +
//					COL_M_PW + " = ?, " +
//					COL_M_NAME + " = ?, " +
//					COL_M_PHONE + " = ?, " +
//					COL_M_EMAIL + " = ?, " +
//					COL_M_TIME + " = ?, " +
//					COL_M_MANAGER_ID + " = ? " +
//					"WHERE " + COL_M_NUMBER + " = ?";
	public static final String SQL_M_UPDATE_MANAGER =  
		    "UPDATE " + TABLE_MEMBER + " SET " + 
		    		COL_M_ID + " = COALESCE(?, " + COL_M_ID + "), " +
		    		COL_M_PW + " = COALESCE(?, " + COL_M_PW + "), " +
		    		COL_M_NAME + " = COALESCE(?, " + COL_M_NAME + "), " +
		    		COL_M_PHONE + " = COALESCE(?, " + COL_M_PHONE + "), " +
		    		COL_M_EMAIL + " = COALESCE(?, " + COL_M_EMAIL + "), " +
		    		COL_M_TIME + " = COALESCE(?, " + COL_M_TIME + "), " +
		    		COL_M_MANAGER_ID + " = COALESCE(?, " + COL_M_MANAGER_ID + ") " +
		    "WHERE " + COL_M_NUMBER + " = ?";
	// 회원 남은시간 변화시 사용 충전, 사용종료, 등 시간종료시에는 SYS데이트 에 사용시간을 뺀 값을 저장
	public static final String SQL_M_UPDATE_TIME_CHANGE =  
			"UPDATE " + TABLE_MEMBER + " SET " + 
					COL_M_TIME + " = ? " +
					"WHERE " + COL_M_NUMBER + " = ?";
	// 시간 충전
//	public static final String SQL_M_TIME_CHARGE =  
//			"UPDATE " + TABLE_MEMBER + " SET " +
//					COL_M_TIME + " = ?, " + // 기존 시간값에 +한 값을 ?에
//					COL_H_NUMBER + " = SEQ_HISTORY.CURRVAL " + 
//					"WHERE " + COL_M_NUMBER + " = ?";
	// 회원 정보 변경
//	public static final String SQL_M_UPDATE_USER = // 회원가입 당시 정보를 db에서 받아오고 SET 시킨다음 바꿀정보를 바꾸고 나머지는 다시 그대로 저장하도록. 
//			"UPDATE " + TABLE_MEMBER + " SET " + 
//					COL_M_ID + " = ?, " +
//					COL_M_PW + " = ?, " +
//					COL_M_NAME + " = ?, " +
//					COL_M_PHONE + " = ?, " +
//					COL_M_EMAIL + " = ? " +
//					"WHERE " + COL_M_NUMBER + " = ?";
	public static final String SQL_M_UPDATE_USER =  
		    "UPDATE " + TABLE_MEMBER + " SET " + 
		    		COL_M_ID + " = COALESCE(?, " + COL_M_ID + "), " +
		    		COL_M_PW + " = COALESCE(?, " + COL_M_PW + "), " +
		    		COL_M_NAME + " = COALESCE(?, " + COL_M_NAME + "), " +
		    		COL_M_PHONE + " = COALESCE(?, " + COL_M_PHONE + "), " +
		    		COL_M_EMAIL + " = COALESCE(?, " + COL_M_EMAIL + "), " +
		    "WHERE " + COL_M_NUMBER + " = ?";
	// 회원 정보 삭제 
	public static final String SQL_M_DELETE = 
			"DELETE " + TABLE_MEMBER + " WHERE "
			+ COL_M_NUMBER + " = ?";
	// 회원 전체 검색
	public static final String SQL_M_SELECT = 
	         "SELECT " + COL_M_NUMBER + ", " + COL_M_ID + ", " + COL_M_NAME + 
	         " FROM " + TABLE_MEMBER + " ORDER BY " + COL_M_NUMBER;
	// 회원 상세 검색 (번호로 검색하는거라 굳이 번호까지 나올필요가 있겠냐만은 일단은 넣어놓고 변경 가능)
	//TODO
	public static final String SQL_SELECT_BY_M_NUMBER = 
			 "SELECT " + COL_M_NUMBER + ", " + COL_M_ID + ", " + COL_M_NAME + ", " + COL_M_PHONE +
			 ", " + COL_M_EMAIL + ", " + COL_M_TIME + " FROM " + TABLE_MEMBER +
			 " WHERE " + COL_M_NUMBER + " = ?";
	// ======================================================================================
	// 데이터 등록
		public static final String SQL_P_INSERT = "INSERT INTO " + TABLE_PRODUCT
				+ " VALUES (SEQ_PRODUCT.NEXTVAL, ?, ?, ?, ?, ?, SEQ_HISTORY.CURRVAL)";
		// 재고 관리
		public static final String SQL_P_UPDATE_MANAGER = 
				"UPDATE " + TABLE_PRODUCT + " SET " + 
						COL_P_NAME + " = ?, " +
						COL_P_INFO + " = ?, " +
						COL_P_PRICE + " = ?, " +
						COL_P_QUANTITY + " = ? " +					
						"WHERE " + COL_P_NUMBER + " = ?";
		// 회원 상품 구매시 사용
		public static final String SQL_P_UPDATE_USER = 
				"UPDATE " + TABLE_PRODUCT + " SET " +
						COL_P_QUANTITY + " = ? " +	// 0이하로는 안떨어지게할것				
						"WHERE " + COL_P_NUMBER + " = ?";
		// 데이터 삭제 시 히스토리에 삭제 내역 넣기 무슨 상품 삭제
		public static final String SQL_P_DELETE = 
				"DELETE " + TABLE_PRODUCT + " WHERE " + COL_P_NUMBER + " = ?";
		// 회원 상품정보 검색	
		public static final String SQL_P_SELECT_USER = 
				"SELECT "+ COL_P_NAME + ", " + COL_P_INFO + ", " + COL_P_PRICE +
				" FROM " + TABLE_PRODUCT + " ORDER BY " + COL_P_NUMBER;
		// 데이터 전체 검색
		public static final String SQL_P_SELECT_MANAGER = 
				"SELECT * FROM " + TABLE_PRODUCT + " ORDER BY " + COL_P_NUMBER;
		// 데이터 상세 검색
		public static final String SQL_SELECT_BY_P_NUMBER = 
				"SELECT * FROM " + TABLE_PRODUCT +
				" WHERE " + COL_P_NUMBER + " = ?";
// =====================================================================================
		// PC 데이터 등록 
		public static final String SQL_PC_INSERT =
				"INSERT INTO " + TABLE_PC + 
				" VALUES (SEQ_PC.NEXTVAL, NULL, '0', NULL)";
		// PC 데이터 검색
		public static final String SQL_PC_SELECT = 
				"SELECT * FROM " + TABLE_PC + " ORDER BY " + COL_PC_NUMBER;
		// PC 상세 검색
		public static final String SQL_SELECT_BY_PC_NUMBER = 
				"SELECT * FROM " + TABLE_PC + 
				" WHERE " + COL_PC_NUMBER + " = ?";
		// PC 데이터 수정(로그인 로그아웃)
		public static final String SQL_PC_UPDATE = 
				"UPDATE " + TABLE_PC + " SET " + 
						COL_PC_INFO + " = ?, " +
						COL_PC_M_NUM + " = ? " +
						"WHERE " + COL_PC_NUMBER + " = ?";
		// PC 사용 변경
		public static final String SQL_PC_USE_UPDATE = 
				"UPDATE " + TABLE_PC + " SET " +
						COL_PC_STATE + " = ? " +
						"WHERE " + COL_PC_NUMBER + " = ?";
		// PC 데이터 삭제
		public static final String SQL_PC_DELETE = 
				"DELETE " + TABLE_PC + " WHERE " + COL_PC_NUMBER + " = ?";
		
		

		
}// END OracleQuery
