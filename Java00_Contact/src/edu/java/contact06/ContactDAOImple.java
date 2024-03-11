package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleDriver;

//DAO(Data Access Object) :
//- 데이터의 전송을 담당하는 역할
public class ContactDAOImple implements ContactDAO, OracleQuery {

	// 싱글톤 디자인 패턴 적용

	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() { // 함수를 사용하기 위해 생성자에서 부른다.
		
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 연락처 임시 저장 배열
	private static ArrayList<ContactVO> list = new ArrayList<>();
	
	private void selectDB() {
		System.out.println("DB에 연결 시작");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELECT);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) { // 레코드가 존재할 때까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼

				ContactVO vo = new ContactVO(contactId, name, phone, email);
				list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end DBInsert
	
	public ContactVO selectDB(int index) {
		System.out.println("JDBC 7 - 입력된 번호로 select");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과를 저장할 클래스
		ContactVO vo = null;
		try {
//			3. JDBC 드라이버를 메모리에 로드
				DriverManager.registerDriver(new OracleDriver());
				System.out.println("드라이버 로드 성공!");
				
//			4. DB와 Connection(연결)을 맺음
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB 연결 성공!");
				
//			5. Connection 객체를 사용하여 Statement 객체 생성
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
			
			pstmt.setInt(1, index);
		
			rs = pstmt.executeQuery();
			if(rs.next()) { 
//				index = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼
				
				vo = new ContactVO(index, name, phone, email);
				list.add(vo);
				System.out.println(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close(); // 안닫으면 메모리 누수가 너무 크기때문에 닫아준다. 반 드 시
					conn.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return vo;
	} // end selectDB(int index)

	// DB에 데이터 입력 저장
	public void insertDB(ContactVO vo) { // 메인에 들어갈 int result = dao.insert(vo);
		System.out.println("DB에 저장 시작");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
//		int result = 0;
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입 됐습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		return result;
	} // end insertDB

	public int updateDB(int index, ContactVO vo) {
		System.out.println("JDBC 6 - 입력받은 데이터를 쿼리에 적용하여 update, delete");
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		//						Statement와 상속 관계
		
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, index);
			// SQL 쿼리의 ? 순서와 parameterIndex의 값을 동일하게 지정
			// 컬럼 순서와 헷갈리지 말 것
			// 예시) ?가 첫 번째이면 parameterIndex = 1
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			
			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 수정됐습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	} // end updateDB
	
	public int deleteDB(int index) {
		System.out.println("JDBC 6 - 입력받은 데이터를 쿼리에 적용하여 delete");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		//						Statement와 상속 관계
		
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			
			// 6. SQL 문장 완성 - SQL_DELETE 쿼리의 ?를 채워주는 코드
			pstmt.setInt(1, index);
			System.out.println("딥");
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			
			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삭제됐습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getSize() {
//		return list.size();
		return select().size();
	}

	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		insertDB(vo);

		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {
//		list.get(getSize())
		selectDB();
		return list;
	}

	@Override
	public ContactVO select(int index) {
//		readDataFromFile();
//		selectDB();
		return selectDB(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
//		writeDataToFile();
		int result = 0;
		updateDB(index, vo);
		return result;
	}

	@Override
	public int delete(int index) {
		int result = 0;
		list.remove(index);
		deleteDB(index);
//		writeDataToFile();
		return result;
	}

}
