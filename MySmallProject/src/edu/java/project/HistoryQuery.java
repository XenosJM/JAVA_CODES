package edu.java.project;

public interface HistoryQuery extends OracleQuery {
	
	public static final String TABLE_HISTORY = "EX_HISTORY";
	public static final String COL_H_NUMBER = "HISTORY_NUMBER";
	public static final String COL_H_DATE = "HISTORY_DATE";
	public static final String COL_MEMHIST = "MEMBER_HISTORY";
	public static final String COL_PRODHIST = "PRODUCT_HISTORY";
	public static final String COL_H_M_ID = "MEMBER_ID";
	public static final String COL_H_P_NAME = "PRODUCT_NAME";
	public static final String COL_H_PC_NUMBER = "PC_NUMBER";
	public static final String COL_H_ORDER_NUM = "ORDER_NUMBER";
	
//    HISTORY_NUMBER NUMBER PRIMARY KEY,
//    HISTORY_DATE TIMESTAMP DEFAULT LOCALTIMESTAMP UNIQUE,
//    MEMBER_HISTORY VARCHAR2(200), -- 사용시간 내역
//    PRODUCT_HISTORY VARCHAR2(200), -- 상품주문 내역
//    PC_HISTORY VARCHAR2(200), -- PC 사용 내역
//    MEMBER_NUMBER NUMBER,
//    PRODUCT_NUMBER NUMBER,
//    PC_NUMBER NUMBER,
	
	
	
	// 관리자 날짜 기준전체 히스토리
//	SELECT H.HISTORY_DATE, H.PRODUCT_HISTORY, PC.PC_HISTORY
//	FROM EX_HISTORY H
//	JOIN EX_MEMBER M ON H.MEMBER_HISTORY
//	JOIN EX_PRODUCT P ON H.PRODUCT_HISTORY = P.PRODUCT_HISTORY
//	JOIN EX_PC PC ON H.PC_HISTORY = PC.PC_HISTORY
//	WHERE H.HISTORY_DATE = ?;
	
	
	// 사용자 번호, 이름 아이디 남은시간 JOIN으로 PC 상태, 사용자 번호
}
