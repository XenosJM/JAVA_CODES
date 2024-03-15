package edu.java.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public int insertHist(HistoryVO hv) {
		System.out.println("사용할 일 없는 코드");
		int result = 0;
		return result;
	}

	@Override
	public int insertMem(MemberVO mv) {
		System.out.println("DB 회원 등록 시작");
		int result = 0;
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
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입됐습니다.");

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
	} // end insertMem

	@Override
	public int insertProd(ProductVO pv) {
		System.out.println("DB 상품 등록 시작");
		int result = 0;
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
			pstmt.setInt(3, pv.getProdSellPrice());
			pstmt.setInt(4, pv.getProdQuantity());
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입됐습니다.");

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
	}// end 상품등록

	@Override
	public int insertPc(PcVO pc) {
		System.out.println("DB PC 등록 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_PC_INSERT);
			pstmt.setString(1, pc.getPcInfo());
			pstmt.setInt(2, pc.getPcState());
			pstmt.setString(3, pc.getPcMemberId());
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입됐습니다.");

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
	} // end PC등록

	@Override
	public int insertOrder(OrderVO ov) {
		System.out.println("DB 상품주문 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_ORDER_ADD);
			pstmt.setString(1, ov.getOrderMemId());
			pstmt.setString(2, ov.getOrderProdName());
			pstmt.setInt(3, ov.getOrderProdQty());
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입됐습니다.");

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
	} // end 주문추가

	@Override
	public ArrayList<HistoryVO> selectHist() {
		System.out.println("DB 히스토리 검색 시작");
		ArrayList<HistoryVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_H_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 레코드가 존재할 때까지
				int histNumber = rs.getInt(1); // histnumber
				Date histDate = rs.getDate(2); // date 컬럼
				String histMem = rs.getString(2); // member
				String histProd = rs.getString(3); // Product
				String histPc = rs.getString(4); // PC
				String histOrder = rs.getString(5); // 주문내역

				HistoryVO hv = new HistoryVO(histNumber, histDate, histMem, histProd, histPc, histOrder);
				list.add(hv); // TODO 나중에 이 리스트의 값에서 각 테이블의 히스토리값을 불러와서 나누는 작업을 메인해서 할것.
			}
			System.out.println("DB 작업완료");
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
		return list;
	} // end 히스토리 전체검색

	@Override
	public ArrayList<MemberVO> selectMem() {
		System.out.println("DB 회원정보 검색 시작");
		ArrayList<MemberVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_SELECT);
			System.out.println("쿼리 실행 준비");
			rs = pstmt.executeQuery();
			System.out.println("쿼리 실행");

			while (rs.next()) { // 레코드가 존재할 때까지
				int memberNumber = rs.getInt(1); // member number
				System.out.println(memberNumber);
				String memberId = rs.getString(2); // member id
				System.out.println(memberId);
				String memberPw = rs.getString(3); // member pw
				System.out.println(memberPw);
				String memberName = rs.getString(4); // member name
				System.out.println(memberName);
				String memberPhone = rs.getString(5); // member phone
				System.out.println(memberPhone);
				String memberEmail = rs.getString(6); // member email
				System.out.println(memberEmail);
				int memberTime = rs.getInt(7); // member Time
				System.out.println(memberTime);
				int memberManager = rs.getInt(8); // ManagerId
				System.out.println(memberManager);
				MemberVO mv = new MemberVO(memberNumber, memberId, memberPw, memberName, memberPhone, memberEmail,
						memberTime, memberManager);
				list.add(mv); 
			}
			System.out.println("DB 작업완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	} // end 멤버 전체검색

	@Override
	public ArrayList<ProductVO> selectProd() {
		System.out.println("DB 상품정보 검색 시작");
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_P_SELECT_MANAGER);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 레코드가 존재할 때까지
				int pcNumber = rs.getInt(1); // histnumber
				String pcInfo = rs.getString(2); // date 컬럼
				int pcState = rs.getInt(3); // member
				int pcMemId = rs.getInt(4); // Product
				ProductVO pv = new ProductVO(pcNumber, pcInfo, pcInfo, pcState, pcMemId);
				list.add(pv); // TODO 나중에 이 리스트의 값에서 각 테이블의 히스토리값을 불러와서 나누는 작업을 메인해서 할것.
			}
			System.out.println("DB 작업완료");
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
		return list;
	}

	@Override
	public ArrayList<PcVO> selectPc() {
		System.out.println("DB pc내역 검색 시작");
		ArrayList<PcVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_PC_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 레코드가 존재할 때까지
				int pcNumber = rs.getInt(1); // pc number
				String pcInfo = rs.getString(2); // pc info
				int pcState = rs.getInt(3); // pc state
				String memberId = rs.getString(4); // pc member id
				PcVO pc = new PcVO(pcNumber, pcInfo, pcState, memberId);
				list.add(pc); // 나중에 이 리스트의 값에서 각 테이블의 히스토리값을 불러와서 나누는 작업을 메인해서 할것.
			}
			System.out.println("DB 작업완료");
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
		return list;
	}

	@Override
	public ArrayList<OrderVO> selectOrder() {
		System.out.println("DB 히스토리 검색 시작");
		ArrayList<OrderVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_ORDER_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 레코드가 존재할 때까지
				int orderNumber = rs.getInt(1);
				String memberId = rs.getString(2); // member id
				String orderProdName = rs.getString(3); // Prod Name
				int orderProdQty = rs.getInt(4); // Prod Qty

				OrderVO pc = new OrderVO(orderNumber, memberId, orderProdName, orderProdQty);
				list.add(pc); // 나중에 이 리스트의 값에서 각 테이블의 히스토리값을 불러와서 나누는 작업을 메인해서 할것.
			}
			System.out.println("DB 작업완료");
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
		return list;
	} // end orderselect

	@Override
	public HistoryVO selectHist(int histNumber) {
		HistoryVO hv = new HistoryVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_H_NUMBER);

			pstmt.setInt(1, histNumber);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 레코드가 존재할 때까지
				histNumber = rs.getInt(1);
				String histMEm = rs.getString(2);
				String histProd = rs.getString(3);
				String histPc = rs.getString(4);
				String histOrder = rs.getString(5);
				hv = new HistoryVO(histNumber, null, histMEm, histProd, histPc, histOrder);
				System.out.println(hv);
			}

		} catch (SQLException e) {
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

		return hv;
	}

	@Override
	public MemberVO selectMem(String memberId) {
		MemberVO mv = new MemberVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_M_ID);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();
			System.out.println("쿼리 성공");
			if (rs.next()) { // 레코드가 존재할 때까지
				int memberNumber = rs.getInt(1);
				memberId = rs.getString(2);
				String memberPw = rs.getString(3);
				String memberName = rs.getString(4);
				String memberPhone = rs.getString(5);
				String memberEmail = rs.getString(6);
				int memberTime = rs.getInt(7);
				int memberManager = rs.getInt(8);

				mv = new MemberVO(memberNumber, memberId, memberPw, memberName, memberPhone, memberEmail, memberTime, memberManager);
				System.out.println(mv);
			}
		} catch (SQLException e) {
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
		System.out.println("선택검색 완료");
		return mv;
	}

	
	public MemberVO selectMemAni(int memberNumber, String memberId, String memberName) {
		System.out.println("아무거나 쿼리 시작");
		MemberVO mv = new MemberVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_M_ANY);
			pstmt.setInt(1, memberNumber);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberName);

			rs = pstmt.executeQuery();
			System.out.println("아무거나 쿼리 성공");
			if (rs.next()) { // 레코드가 존재할 때까지
				memberNumber = rs.getInt(1);
				memberId = rs.getString(2);
				String memberPw = rs.getString(3);
				memberName = rs.getString(4);
				String memberPhone = rs.getString(5);
				String memberEmail = rs.getString(6);
				int memberTime = rs.getInt(7);
				int memberManager = rs.getInt(8);

				mv = new MemberVO(memberNumber, memberId, memberPw, memberName, memberPhone, memberEmail, memberTime, memberManager);
				System.out.println(mv);
			}
		} catch (SQLException e) {
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
		System.out.println("아무거나 검색 완료");
		return mv;
	}
	
	@Override
	public ProductVO selectProd(int prodNumber) {
		ProductVO pv = new ProductVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_PC_NUMBER);
			pstmt.setInt(1, prodNumber);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 레코드가 존재할 때까지
				prodNumber = rs.getInt(1);
				String prodName = rs.getString(2);
				String prodInfo = rs.getString(3);
				int prodSellPrice = rs.getInt(4);
				int prodQty = rs.getInt(5);

				pv = new ProductVO(prodNumber, prodName, prodInfo, prodSellPrice, prodQty);
				System.out.println(pv);
			}
		} catch (SQLException e) {
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
		return pv;
	}

	@Override
	public PcVO selectPc(int pcNumber) {
		System.out.println("PC내역 상세검색 시작");
		PcVO pc = new PcVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_PC_NUMBER);
			pstmt.setInt(1, pcNumber);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 레코드가 존재할 때까지
				pcNumber = rs.getInt(1);
				String pcInfo = rs.getString(2);
				int pcState = rs.getInt(3);
				String pcMemId = rs.getString(4);

				pc = new PcVO(pcNumber, pcInfo, pcState, pcMemId);
				System.out.println(pc);
			}
		} catch (SQLException e) {
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
		return pc;
	}

	@Override
	public OrderVO selectOrder(int orderNumber) {
		System.out.println("주문 상세 검색 시작");
		OrderVO ov = new OrderVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_ORDER_SELECT_BY_NUMBER);
			pstmt.setInt(1, orderNumber);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				orderNumber = rs.getInt(1);
				String orderMemId = rs.getString(2);
				String orderProdName = rs.getString(3);
				int orderProdQty = rs.getInt(4);

				ov = new OrderVO(orderNumber, orderMemId, orderProdName, orderProdQty);
				System.out.println(ov);
			}
		} catch (SQLException e) {
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
		return ov;
	}

	@Override
	public int updateHist(int histNumber, HistoryVO hv) {
		System.out.println("히스토리 내역 업데이트 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_H_UPDATE);

			pstmt.setDate(1, (java.sql.Date) hv.getHistDate());
			pstmt.setString(2, hv.getHistMem());
			pstmt.setString(3, hv.getHistProd());
			pstmt.setString(4, hv.getHistPC());
			pstmt.setString(5, hv.getHistOrder());
			pstmt.setInt(6, histNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("DB작업 완료");
		return result;
	}

	@Override
	public int updateMem(String memberId, MemberVO mv) {
		System.out.println("회원정보 수정 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_UPDATE_MANAGER);

			pstmt.setInt(1, mv.getMemberNumber());
			pstmt.setString(2, mv.getMemberPw());
			pstmt.setString(3, mv.getMemberName());
			pstmt.setString(4, mv.getMemberPhone());
			pstmt.setString(5, mv.getMemberEmail());
			pstmt.setInt(6, mv.getMemberTime());
			pstmt.setInt(7, mv.getMemberManager());
			pstmt.setString(8, memberId);
			result = pstmt.executeUpdate();

			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("DB작업 완료");
		return result;
	}

	@Override
	public int updateMemUser(String memberId, MemberVO mv) {
		System.out.println("사용자 정보 수정 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_UPDATE_USER);

//			pstmt.setInt(1, mv.getMemberNumber());
			pstmt.setString(1, mv.getMemberPw());
			pstmt.setString(2, mv.getMemberName());
			pstmt.setString(3, mv.getMemberPhone());
			pstmt.setString(4, mv.getMemberEmail());
//			pstmt.setInt(5, mv.getMemberTime());
			pstmt.setString(5, memberId);
			result = pstmt.executeUpdate();

			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("DB작업 완료");
		return result;
	}

	@Override
	public int updateTime(String memberId, int memberTime) {
		System.out.println("회원 시간 변동 수정");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_M_UPDATE_TIME_CHANGE);


			pstmt.setInt(1, memberTime);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();

			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("시간 저장 완료");
		return result;
	}
	
	@Override
	public int updateProd(int prodNumber, ProductVO pv) {
		System.out.println("상품정보 업데이트 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_P_UPDATE_MANAGER);

			pstmt.setString(1, pv.getProdName());
			pstmt.setString(2, pv.getProdInfo());
			pstmt.setInt(3, pv.getProdSellPrice());
			pstmt.setInt(4, pv.getProdQuantity());
			pstmt.setInt(5, prodNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("DB작업 완료");
		return result;
	}
	
	@Override
	public int updatePc(int pcNumber, PcVO pc) {
		System.out.println("PC내역 업데이트 시작");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_PC_UPDATE);

			pstmt.setString(1, pc.getPcInfo());
			pstmt.setInt(2, pc.getPcState());
			pstmt.setString(3, pc.getPcMemberId());
			pstmt.setInt(4, pcNumber);

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정됐습니다.");
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
		System.out.println("DB작업 완료");
		return result;
	}
	
	@Override
	public int deleteHist(int histNumber) {
		System.out.println("히스토리 내역 삭제 시작");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 작업완료");
		return result;
	}

	@Override
	public int deleteMem(int memberNumber) {
		System.out.println("회원기록 삭제 시작");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 작업완료");
		return result;
	}

	@Override
	public int deleteProd(int prodNumber) {
		System.out.println("상품정보 삭제 시작");
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_H_DELETE);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("DB 작업완료");
		return result;
	}

	@Override
	public int deletePc(int pcNumber) {
		System.out.println("PC내역 삭제 시작");
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_H_DELETE);

			pstmt.setInt(1, pcNumber);

			result = pstmt.executeUpdate();

			System.out.println(result + "행이 삭제됐습니다.");

		} catch (SQLException e) {

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
		System.out.println("DB 작업완료");
		return result;
	}

	@Override
	public int deleteOrder(int orderNumber) {
		System.out.println("주문내역 삭제 시작");
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_H_DELETE);

			pstmt.setInt(1, orderNumber);

			result = pstmt.executeUpdate();

			System.out.println(result + "행이 삭제됐습니다.");

		} catch (SQLException e) {

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
		System.out.println("DB 작업완료");
		return result;
	}



//	- 상품 판매

//	- 회원 정보 창

//	- 회원 정보에서 관리자 체크 기능( 관리자인지 아닌지)	

//	- 로그인 기능( 관리자면 로그인 성공 아닐시 실패)


//	- PC사용 현황 체크

//	- PC사용 정보 수정
// 멤버 히스토리에 먼저 저장후 히스토리에 저장. 이렇게 하면 멤버 히스토리는 덮어씌우기를 하고 
	// 그 데이터를 가져와 넣기 멤버 히스토리에는 최근 정보해서 넣고 히스토리에는 변동사항만 넣기
//	- 히스토리 insert( 모든 변동사항, PC사용자 로그인/아웃, 상품 판매 등)
//	public abstract int insertHist(HistoryVO hv);

}
