package edu.java.project;

public interface HistoryQuery extends OracleQuery {
	
	public static final String TABLE_HISTORY = "EX_HISTORY";
	public static final String COL_H_NUMBER = "HISTORY_NUMBER";
	public static final String COL_H_DATE = "HISTORY_DATE";
	public static final String COL_MEMHIST = "MEMBER_HISTORY";
	public static final String COL_PRODHIST = "PRODUCT_HISTORY";
	public static final String COL_PCHIST = "PC_HISTORY";
	public static final String COL_H_M_ID = "MEMBER_ID";
	public static final String COL_H_P_NAME = "PRODUCT_NAME";
	public static final String COL_H_PC_NUMBER = "PC_NUMBER";
	public static final String COL_H_Order_NUM = "ORDER_NUMBER";
	
//    HISTORY_NUMBER NUMBER PRIMARY KEY,
//    HISTORY_DATE TIMESTAMP DEFAULT LOCALTIMESTAMP UNIQUE,
//    MEMBER_HISTORY VARCHAR2(200), -- 사용시간 내역
//    PRODUCT_HISTORY VARCHAR2(200), -- 상품주문 내역
//    PC_HISTORY VARCHAR2(200), -- PC 사용 내역
//    MEMBER_NUMBER NUMBER,
//    PRODUCT_NUMBER NUMBER,
//    PC_NUMBER NUMBER,
	
	// 데이터 등록
	public static final String SQL_H_INSERT = "INSERT INTO " + TABLE_HISTORY
			+ " VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, ?, ?, ?, ?, ?)";
	// 회원 변동 내역 이용 정보
	public static final String SQL_H_INSERT_M_HIST = "INSERT INTO " + TABLE_HISTORY +
			" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, NULL, ?, ?, NULL, ?)";
	// 회원 내역중 상품구매에 들어갈 내용
	public static final String memProdHist = "? " + "회원님이 " + "? " + "을(를) " + "주문하셧습니다.";
	public static final String memPcHist = "? " + "회원님이 " + "? " + "자리에서 사용을 시작했습니다.";
	public static final String memTimeHist = "? " + "회원님이 " + "? " + "에 " + "?" + " 만큼 추가하셧습니다."; 
	// 상품 변동내역 - 판매, 구매 또는 재고 변화에 관한 정보들 
	public static final String SQL_H_INSERT_P_HIST = "INSERT INTO " + TABLE_HISTORY +
			" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, ?, NULL, ?, ?, NULL)";
	// 상품 변동내역 - 판매, 구매 또는 재고 변화에 관한 정보들 
	public static final String SQL_H_INSERT_P_MANAGE_HIST = "INSERT INTO " + TABLE_HISTORY +
			" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, NULL, ?, NULL, NULL, ?, NULL)";
	// PC 변동 내역
	public static final String SQL_H_INSERT_PC_HIST = "INSERT INTO " + TABLE_HISTORY +
			" VALUES (SEQ_HISTORY.NEXTVAL, sysdate, NULL, NULL, ?, NULL, NULL, ?)";
	// 히스토리 데이터 삭제
	public static final String SQL_H_DELETE = 
			"DELETE " + TABLE_HISTORY + " WHERE " + COL_H_NUMBER + " = ?";
	// 히스토리 전체 검색
	public static final String SQL_H_SELECT = 
	         "SELECT * FROM " + TABLE_HISTORY + " ORDER BY " + COL_H_M_ID;
	// 히스토리 상세 검색
	public static final String SQL_SELECT_BY_H_NUMBER = 
			"SELECT * FROM " + TABLE_HISTORY + " WHERE " + COL_H_NUMBER + " = ?";	
	// 사용자 상세 검색
	public static final String SQL_SELECT_BY_USER_HISTORY = 
			"SELECT H."+ COL_H_DATE + ", H." + COL_MEMHIST + ", H." + COL_PRODHIST + 
			", M." + COL_H_M_ID + ", PC." + COL_PC_NUMBER + " FROM " + TABLE_HISTORY + " H " +
			"JOIN " + TABLE_PRODUCT + " P ON H." + COL_H_P_NAME + " = P." + COL_P_NUMBER +
			" JOIN " + TABLE_MEMBER + " M ON H." + COL_H_M_ID + " = M." + COL_M_NUMBER +
			" JOIN " + TABLE_PC + "PC ON H." + COL_H_PC_NUMBER + " = PC." + COL_PC_NUMBER +
			" WHERE H." + COL_H_M_ID + " = ?";
	// 관리자 상품관리 내역
	public static final String SQL_SELECT_BY_MANAGE_HISTORY = 
			"SELECT H."+ COL_H_DATE + ", P." + COL_P_NUMBER + ", H." + COL_PRODHIST +
			" FROM " + TABLE_HISTORY + " H " + 
			"JOIN " + TABLE_PRODUCT + " P ON H." + COL_H_P_NAME + " = P." + COL_P_NUMBER +
			" WHERE H." + COL_H_P_NAME + " = ?";	
	// PC 내역
	public static final String SQL_SELECT_BY_PC_HISTORY = 
			"SELECT H."+ COL_H_DATE + ", PC." + COL_PCHIST + ", PC." + COL_PC_NUMBER + 
			" FROM " + TABLE_HISTORY + " H " +
			"JOIN " + TABLE_PC	+ "PC ON H." + COL_H_PC_NUMBER + " = PC." + COL_PC_NUMBER +
			" WHERE H." + COL_H_PC_NUMBER + " = ?";	
	// 판매 기록 검색
	public static final String SQL_SELECT_BY_SELL_PROD = 
			"SELECT H."+ COL_H_DATE + ", H." + COL_PRODHIST + " P." + COL_P_NUMBER + 
			" FROM " + TABLE_HISTORY + " H JOIN " + TABLE_PRODUCT + " P " +
			"ON H." + COL_H_P_NAME + " = P." + COL_P_NUMBER +
			" WHERE H." + COL_PRODHIST + " LIKE " + "'%판매%'";
	
	// 관리자 날짜 기준전체 히스토리
//	SELECT H.HISTORY_DATE, H.PRODUCT_HISTORY, PC.PC_HISTORY
//	FROM EX_HISTORY H
//	JOIN EX_MEMBER M ON H.MEMBER_HISTORY
//	JOIN EX_PRODUCT P ON H.PRODUCT_HISTORY = P.PRODUCT_HISTORY
//	JOIN EX_PC PC ON H.PC_HISTORY = PC.PC_HISTORY
//	WHERE H.HISTORY_DATE = ?;
	
	
	// 사용자 번호, 이름 아이디 남은시간 JOIN으로 PC 상태, 사용자 번호
}
