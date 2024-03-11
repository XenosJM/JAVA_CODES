package edu.java.project;

public interface MemberQuery extends OracleQuery {
	public static final String TABLE_MEMBER = "EX_MEMBER";
	public static final String COL_M_NUMBER = "MEMBER_NUMBER";
	public static final String COL_M_ID = "MEMBER_ID";
	public static final String COL_M_PW = "MEMBER_PW";
	public static final String COL_M_NAME = "MEMBER_NAME"; 
	public static final String COL_M_PHONE = "MEMBER_PHONE";
	public static final String COL_M_EMAIL = "MEMBER_EMAIL";
	public static final String COL_M_TIME = "MEMBER_TIME";
	public static final String COL_M_MANAGER_ID = "MANAGER_ID";
	// 첫 관리자 등록
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
	public static final String SQL_M_UPDATE_MANAGER =  
			"UPDATE " + TABLE_MEMBER + " SET " + 
					COL_M_ID + " = ?, " +
					COL_M_PW + " = ?, " +
					COL_M_NAME + " = ?, " +
					COL_M_PHONE + " = ?, " +
					COL_M_EMAIL + " = ?, " +
					COL_M_TIME + " = ?, " +
					COL_M_MANAGER_ID + " = ? " +
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
	public static final String SQL_M_UPDATE_USER = // 회원가입 당시 정보를 db에서 받아오고 SET 시킨다음 바꿀정보를 바꾸고 나머지는 다시 그대로 저장하도록. 
			"UPDATE " + TABLE_MEMBER + " SET " + 
					COL_M_ID + " = ?, " +
					COL_M_PW + " = ?, " +
					COL_M_NAME + " = ?, " +
					COL_M_PHONE + " = ?, " +
					COL_M_EMAIL + " = ? " +
					"WHERE " + COL_M_NUMBER + " = ?";
	// 회원 정보 삭제 데이터 삭제시 히스토리에 기록
	public static final String SQL_M_DELETE = 
			"DELETE " + TABLE_MEMBER + " WHERE "
			+ COL_M_NUMBER + " = ?";
	// 회원 전체 검색
	public static final String SQL_M_SELECT = 
	         "SELECT * FROM " + TABLE_MEMBER + " ORDER BY " + COL_M_NUMBER;
	// 회원 상세 검색
	public static final String SQL_SELECT_BY_M_NUMBER = 
			"SELECT * FROM " + TABLE_MEMBER +
			" WHERE " + COL_M_NUMBER + " = ?";
	
}
