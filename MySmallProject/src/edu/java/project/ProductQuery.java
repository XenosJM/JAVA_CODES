package edu.java.project;

public interface ProductQuery {
	public static final String TABLE_PRODUCT = "EX_PRODUCT";
	public static final String COL_P_NUMBER = "PRODUCT_NUMBER";
	public static final String COL_P_NAME = "PRODUCT_NAME";
	public static final String COL_P_INFO = "PRODUCT_INFO";
	public static final String COL_P_PRICE = "PRODUCT_SELL_PRICE";
	public static final String COL_P_QUANTITY = "PRODUCT_QUANTITY";
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

	
	
	
	
	
	
}
