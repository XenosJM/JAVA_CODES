package edu.java.project;

public interface PcQuery extends OracleQuery {
	String TABLE_PC = "EX_PC";
	String COL_PC_NUMBER = "PC_NUMBER";
	String COL_PC_INFO = "PC_INFO";
	String COL_PC_STATE = "PC_STATE";
	String COL_PC_M_NUM = "MEMBER_NUMBER";
	
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
	
	
	
	
	
	
	
	
	
	
	
}
