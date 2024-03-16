package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class MemberLogin extends JFrame {
	private static ManageDAO dao;
	private int hour, minute, seconds;
	protected JLabel lblMemberTime, lblMemberId, lblPcNumber, lblMemberNumber;
	private JPanel contentPane;
	private int time;
	private JOptionPane pane;
	private JFrame frame;
	protected String idFromPM;
	protected int numFromPM;
	private int startTime, endTime, lastTime, orderNumber;
	private JButton btnUserQuit;
	private ProjectMain pm;
	private CheckPw cp;

	public MemberLogin() {
		dao = ManageDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 300);
//	  = this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // = Frame.getContantPane()과 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUserOrderProd = new JButton("상품 주문");
		btnUserOrderProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderProduct op = new OrderProduct();
				op.lblOrderMember.setText(idFromPM);
				System.out.println(idFromPM);
				op.setVisible(true);
				
			}
		});
		btnUserOrderProd.setBounds(12, 10, 131, 47);
		contentPane.add(btnUserOrderProd);

		JButton btnUserUpdate = new JButton("회원 정보수정");
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp = new CheckPw();
				cp.setVisible(true);

			}
		});
		btnUserUpdate.setBounds(12, 124, 131, 47);
		contentPane.add(btnUserUpdate);

		btnUserQuit = new JButton("사용 종료");
		btnUserQuit.setBounds(12, 181, 131, 47);
		contentPane.add(btnUserQuit);

		lblPcNumber = new JLabel("좌석 번호");
		lblPcNumber.setBounds(155, 10, 96, 47);
		contentPane.add(lblPcNumber);

		lblMemberId = new JLabel();
		lblMemberId.setText("회원 아이디");
		lblMemberId.setBounds(263, 17, 166, 32);
		contentPane.add(lblMemberId);

		lblMemberTime = new JLabel("현재 남은 시간");
		lblMemberTime.setBounds(155, 67, 274, 47);
		contentPane.add(lblMemberTime);

		lblMemberNumber = new JLabel("회원 번호");
		lblMemberNumber.setBounds(263, 0, 166, 15);
		contentPane.add(lblMemberNumber);
		
		JButton btnSelectOrder = new JButton("주문 내역");
		btnSelectOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderHist oh = new OrderHist();
				System.out.println(idFromPM);
				int showOrderNum = dao.selectOrderChk(idFromPM).getOrderNumber();
				System.out.println(showOrderNum);
				String showOdNum = String.valueOf(showOrderNum);
				OrderVO ov = dao.selectOrder(showOrderNum);
				oh.setVisible(true);
				oh.lblShowOrderNumber.setText(showOdNum);
				oh.lblShowOrderName.setText(ov.getOrderProdName());
				String showOdName = String.valueOf(ov.getOrderProdQty());
				oh.lblShowOrderQty.setText(showOdName);
				
			}

		});
		btnSelectOrder.setBounds(12, 67, 131, 47);
		contentPane.add(btnSelectOrder);


	} // end MemberLogin()


	public void setLblMember() {
		lblMemberId.setText("회원 아이디 : " + idFromPM);
		String numPM = String.valueOf(numFromPM);
		lblMemberNumber.setText("회원 번호 : " + numPM);
	}

	public void setInfoFromPM(String id, int memNum) {
		this.idFromPM = id;
		this.numFromPM = memNum;
	}

// 시간 충전시 값을 다시 받아와서 진행. 진행전 타이머 캔슬시키고 진행할것
	protected void currentTime() {
		System.out.println("시간표시");
//		MemberVO mv = dao.selectMem(idFromPM);
		time = refreshMem().getMemberTime();
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
//				System.out.println("시작");
				time--;
				hour = time / 3600;
				minute = (time % 3600) / 60;
				seconds = time % 60;
				String timeString = String.format("이용시간은 %02d:%02d:%02d 남았습니다", hour, minute, seconds);
				lblMemberTime.setText(timeString);
				lastTime = time;
//				System.out.println(lastTime); lastTime이 Time과 일치하는 체크용
				if (time == 0) {
					pm = new ProjectMain();
					endTime();
					updateMemTime();
					timer.cancel();
					pm.frame.setVisible(true);
				}
			}
//					System.out.println("시간 표시 왜 안돼니?");
		};
		timer.schedule(timerTask, 1, 1000);
		btnUserQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("사용자 종료");
				timer.cancel();
				updateMemTime();
				dispose();
				pm = new ProjectMain();
				pm.frame.setVisible(true);
				System.out.println("로그인창 표시");
			}
		});

	}

	protected void updateMemTime() {
		// 시간을 실시간으로 저장 시키기 위해서 필요한것. 현재 시간 정보가 필요.
		dao.updateTime(idFromPM, lastTime);
	}

	public int startTime() {
		startTime = (int) System.currentTimeMillis();
		return startTime;
	}

//		int x = (startTime() - endTime()); // 총사용 시간을 나타낼때 사용하면 딱이긴한데..
	public int endTime() {
		endTime = (int) System.currentTimeMillis();
		return endTime;
	}

	protected MemberVO refreshMem() { // select 기능할 녀석
		MemberVO mv = dao.selectMem(idFromPM);
		return mv;

	}
}// end MemberLogin
