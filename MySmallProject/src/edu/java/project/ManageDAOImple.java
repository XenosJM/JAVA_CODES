package edu.java.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class ManageDAOImple implements ManageDAO, OracleQuery {

	// 싱글톤 디자인패턴
	private static ManageDAOImple instance = null;

	// private 생성자 = 함수를 사용하고 싶을때 생성자에서 부름
	private ManageDAOImple() {
		// TODO 생성자에 들어가야할 함수가 생기면 넣을것
	}

	// public static 메소드 - 인스턴스를 리턴하도록 구현
	public static ManageDAOImple getInstance() {
		if (instance == null) {
			instance = new ManageDAOImple();
		}
		return instance;
	}


//	- 상품 판매

//	- 회원 정보 창

//	- 회원 정보에서 관리자 체크 기능( 관리자인지 아닌지)	

//	- 로그인 기능( 관리자면 로그인 성공 아닐시 실패)

//	- 회원 남은 시간 추가 기능(상품결제와는 다르게 추가로)

//	- PC사용 현황 체크

//	- PC사용 정보 수정
// 멤버 히스토리에 먼저 저장후 히스토리에 저장. 이렇게 하면 멤버 히스토리는 덮어씌우기를 하고 
	// 그 데이터를 가져와 넣기 멤버 히스토리에는 최근 정보해서 넣고 히스토리에는 변동사항만 넣기
//	- 히스토리 insert( 모든 변동사항, PC사용자 로그인/아웃, 상품 판매 등)
//	public abstract int insertHist(HistoryVO hv);
	
	@Override
	public int insertHist(HistoryVO hv) { 
		int result = 0;
		System.out.println("DB에 히스토리 저장 시작");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
//			"INSERT INTO EX_HISTORY VALUES (SEQ_HISTORY.NEXTVAL, sysdate, ?, ?, ?, ?, ?, ?)"
			pstmt = conn.prepareStatement(SQL_H_INSERT);
			
			pstmt.setString(1, hv.getHistMem());
			pstmt.setString(2, hv.getHistProd());
			pstmt.setString(3, hv.getHistPC());
			pstmt.setInt(4, hv.getHistMemNum());
			pstmt.setInt(5, hv.getHistProdNum());
			pstmt.setInt(6, hv.getHistPcNum());			

			result = pstmt.executeUpdate();
			System.out.println(result + "히스토리가 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("히스토리 저장 완료");
		} // end try-catch-finally
		return result;
	} // end insertHist()
	
	public int insertMemHist(HistoryVO hv) {
		int result = 0;
		System.out.println("DB 회원 내역 저장 시작");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String prodHist = null;
		String memHist = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 연결 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
//			public static final String memProdHist = "? " + "회원님이 " + "? " + "을(를) " + "? " + 
//					"개 주문하셧습니다.";
			prodHist = memProdHist;
			prodHist.substring(1, hv.getHistMemID());
			prodHist.substring(2, hv.getHistProdName());
			
			memHist = memPcHist;
			
			pstmt = conn.prepareStatement(SQL_H_INSERT_M_HIST);
			pstmt.setString(1, memHist);
			pstmt.setString(2, prodHist);
			pstmt.setInt(3, hv.getHistMemID());
			pstmt.setInt(4, hv.getHistPcNum());
			
			result = pstmt.executeUpdate();
			System.out.println("회원내역 저장 성공");
						
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
		return result;
	}
	
	public int insertProdHist(HistoryVO hv) {
		System.out.println("DB 상품내역 저장 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt = conn.prepareStatement(SQL_H_INSERT_P_HIST);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		
	public int insertPcHist(PcVO pv) {
		// TODO Auto-generated method stub
		return 0;
	}

//	- 회원 추가 ( 가입, 등록) insert
//	public abstract int insertMember(MemberVO mv);
	@Override
	public int insertMem(MemberVO mv) {
		int result = 0;
		System.out.println("DB에 회원정보 저장 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_M_INSERT);

			pstmt.setString(1, mv.getMemberId());
			pstmt.setString(2, mv.getMemberPw());
			pstmt.setString(3, mv.getMemberName());
			pstmt.setString(4, mv.getMemberPhone());
			pstmt.setString(5, mv.getMemberEmail());
			pstmt.setInt(6, mv.getMemberTime());
			pstmt.setInt(7, mv.getMemberManager());

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} // end insertMember()

//	- 재고 구매 ( 구매한 날짜, 가격, 갯수, 회사) insert
//	public abstract int insertProd(ProductVO pv);
	@Override
	public int insertProd(ProductVO pv) {
		int result = 0;
		System.out.println("DB에 상품정보 입력 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_P_INSERT);

			pstmt.setString(1, pv.getProdName());
			pstmt.setString(2, pv.getProdInfo());
			pstmt.setInt(3, pv.getProdBuyPrice());
			pstmt.setInt(4, pv.getProdSellPrice());
			pstmt.setInt(5, pv.getProdQuantity());

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} // end insertProd()

//	- 기록 검색 select
//	public abstract List<HistoryVO> selectHist();
	@Override
	public List<HistoryVO> selectHist() {
		System.out.println("DB 기록 전체검색 시작");
		ArrayList<HistoryVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");

			pstmt = conn.prepareStatement(SQL_H_SELECT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int histNumber = rs.getInt(COL_H_NUMBER);
				Date histDate = rs.getTimestamp(COL_H_DATE);
				int histMemberNumber = rs.getInt(COL_H_M_ID);
				int histProdNumber = rs.getInt(COL_H_P_NAME);
				String history = rs.getString(COL_HISTORY);

				HistoryVO hv = new HistoryVO(histNumber, histDate, histMemberNumber, histProdNumber, history);
				list.add(hv);
				System.out.println("DB 기록정보 검색 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 기록정보 검색 완료");
		return list;
	} // end selectHist

//	- 회원 내역 검색
//	public abstract List<MemberVO> selectMember();
	@Override
	public List<MemberVO> selectMem() {
		System.out.println("DB 멤버정보 전체검색");
		ArrayList<MemberVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");

			pstmt = conn.prepareStatement(SQL_M_SELECT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int memberNumber = rs.getInt(COL_M_NUMBER);
				String memberId = rs.getString(COL_M_ID);
				String memberPw = rs.getString(COL_M_PW);
				String memberName = rs.getString(COL_M_NAME);
				String memberPhone = rs.getString(COL_M_PHONE);
				String memberEmail = rs.getString(COL_M_EMAIL);
				int memberTime = rs.getInt(COL_M_TIME);
				int memberManager = rs.getInt(COL_M_MANAGER_ID);

				MemberVO mv = new MemberVO(memberNumber, memberId, memberPw, memberName, memberPhone, memberEmail,
						memberTime, memberManager);
				list.add(mv);
				System.out.println("DB 멤버정보 검색 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 멤버정보 검색 완료");
		return list;
	} // end selectMember()

//	- 상품 검색
//	public abstract List<ProductVO> selectProd();
	@Override
	public List<ProductVO> selectProd() {
		System.out.println("DB 상품정보 전체 검색");
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_P_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int prodNumber = rs.getInt(COL_P_NUMBER);
				String prodName = rs.getString(COL_P_NAME);
				String prodInfo = rs.getString(COL_P_INFO);
				int prodBuyPrice = rs.getInt(COL_P_BUY_PRICE);
				int prodSellPrice = rs.getInt(COL_P_SELL_PRICE);
				int prodQuantity = rs.getInt(COL_P_QUANTITY);

				ProductVO pv = new ProductVO(prodNumber, prodName, prodInfo, prodBuyPrice, prodSellPrice, prodQuantity);
				list.add(pv);
				System.out.println("DB 상품정보 전체검색 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 상품정고 전체검색 완료");
		return list;
	}

//	- 기록 상세 검색 select
//	public abstract HistoryVO selectHist(int histNumber);
	@Override
	public HistoryVO selectHist(int histNumber) {
		System.out.println("기록 상세검색 시작");
		HistoryVO hv = new HistoryVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_H_NUMBER);
			pstmt.setInt(1, histNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				histNumber = rs.getInt(COL_H_NUMBER);
				Date histDate = rs.getTimestamp(COL_H_DATE);
				int histMemberNumber = rs.getInt(COL_H_M_ID);
				int histProdNumber = rs.getInt(COL_H_P_NAME);
				String history = rs.getString(COL_HISTORY);

				hv = new HistoryVO(histNumber, histDate, histMemberNumber, histProdNumber, history);
				System.out.println(hv);
			}
			System.out.println("DB 기록 상세검색 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 기록 상세검색 완료");
		return hv;
	}

//	- 회원 정보 상세 검색 select
//	public abstract MemberVO selectMember(int memberNumber);
	@Override
	public MemberVO selectMem(int memberNumber) {
		System.out.println("DB 멤버정보 상세검색 시작");
		MemberVO mv = new MemberVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_H_NUMBER);
			pstmt.setInt(1, memberNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberNumber = rs.getInt(COL_M_NUMBER);
				String memberId = rs.getString(COL_M_ID);
				String memberPw = rs.getString(COL_M_PW);
				String memberName = rs.getString(COL_M_NAME);
				String memberPhone = rs.getString(COL_M_PHONE);
				String memberEmail = rs.getString(COL_M_EMAIL);
				int memberTime = rs.getInt(COL_M_TIME);
				int memberManager = rs.getInt(COL_M_MANAGER_ID);

				mv = new MemberVO(memberNumber, memberId, memberPw, memberName, memberPhone, memberEmail, memberTime,
						memberManager);
				System.out.println(mv);
			}
			System.out.println("DB 멤버정보 상세검색 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 멤버정보 상세검색 완료");
		return mv;
	}

//	- 상품 정보 상세 검색 select
//	public abstract ProductVO selectProd(int prodNumber);
	@Override
	public ProductVO selectProd(int prodNumber) {
		System.out.println("DB 상품정보 상세검색 시작");
		ProductVO pv = new ProductVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_H_NUMBER);
			pstmt.setInt(1, prodNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				prodNumber = rs.getInt(COL_P_NUMBER);
				String prodName = rs.getString(COL_P_NAME);
				String prodInfo = rs.getString(COL_P_INFO);
				int prodBuyPrice = rs.getInt(COL_P_BUY_PRICE);
				int prodSellPrice = rs.getInt(COL_P_SELL_PRICE);
				int prodQuantity = rs.getInt(COL_P_QUANTITY);

				pv = new ProductVO(prodNumber, prodName, prodInfo, prodBuyPrice, prodSellPrice, prodQuantity);
				System.out.println(pv);
			}
			System.out.println("DB 상품정보 상세검색 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 상품정보 상세검색 완료");
		return pv;
	}

//	- 기록 수정 update
//	public abstract int updateHist(int histNumber, HistoryVO hv);
	@Override
	public int updateHist(int histNumber, HistoryVO hv) {
		System.out.println("DB 기록 수정 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_H_UPDATE);
			pstmt.setTimestamp(1, (Timestamp) hv.getHistDate());
			pstmt.setInt(2, hv.getHistMemberNumber());
			pstmt.setInt(3, hv.getHistProdNumber());
			pstmt.setString(4, hv.getHistory());
			pstmt.setInt(5, histNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 기록 수정완료");
		return result;
	}

//	- 회원 정보 수정 update
//	public abstract int updateMember(int memberNumber, MemberVO mv);
	@Override
	public int updateMem(int memberNumber, MemberVO mv) {
		System.out.println("DB 멤버정보 수정 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_UPDATE);
			pstmt.setString(1, mv.getMemberId());
			pstmt.setString(2, mv.getMemberPw());
			pstmt.setString(3, mv.getMemberName());
			pstmt.setString(4, mv.getMemberPhone());
			pstmt.setString(5, mv.getMemberEmail());
			pstmt.setInt(6, mv.getMemberTime());
			pstmt.setInt(7, mv.getMemberManager());
			pstmt.setInt(8, memberNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 멤버정보 수정완료");
		return result;
	}

//	- 상품 정보 수정 update	
//	public abstract int updateProd(int prodNumber, ProductVO pv);
	@Override
	public int updateProd(int prodNumber, ProductVO pv) {
		System.out.println("DB 상풍정보 수정 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_UPDATE);
			pstmt.setString(1, pv.getProdName());
			pstmt.setString(2, pv.getProdInfo());
			pstmt.setInt(3, pv.getProdBuyPrice());
			pstmt.setInt(4, pv.getProdSellPrice());
			pstmt.setInt(5, pv.getProdQuantity());
			pstmt.setInt(6, prodNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 상품정보 수정완료");
		return result;
	}

//  - 기록 정보 삭제 delete
//	public abstract int deleteHist(int histNumber);
	@Override
	public int deleteHist(int histNumber) {
		System.out.println("DB 기록 삭제 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_H_DELETE);
			pstmt.setInt(1, histNumber);
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삭제됐습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 기록 삭제완료");
		return result;
	}

//	- 회원 정보 삭제 delete 
//	public abstract int deleteMember(int memberNumber);
	@Override
	public int deleteMem(int memberNumber) {
		System.out.println("DB 멤버정보 삭제 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_M_DELETE);
			pstmt.setInt(1, memberNumber);
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삭제됐습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 멤버정보 삭제완료");
		return result;
	}

//	- 상품 정보 삭제 delete
//	public abstract int deleteProd(int prodNumber);
	@Override
	public int deleteProd(int prodNumber) {
		System.out.println("DB 상품정보 삭제 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_P_DELETE);
			pstmt.setInt(1, prodNumber);
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삭제됐습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 상품정보 삭제완료");
		return result;
	}
	
	 public static String maskPW(String password) {
	        StringBuilder pw = new StringBuilder();
	        for (int i = 0; i < password.length(); i++) {
	            pw.append("*");
	        }
	        return pw.toString();
	    }




	public int updateMemManager(int memberNumber, MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateMemUser(int memberNumber, MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
