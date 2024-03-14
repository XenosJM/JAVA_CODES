package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	protected String idFromPM;
	protected int numFromPM;
	private int startTime;
	private int endTime;
	private int lastTime;
	private JButton btnUserQuit;
	private ProjectMain pm;
	private CheckPw cp = new CheckPw();

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
				ProdOrder();
			}
		});
		btnUserOrderProd.setBounds(12, 10, 131, 47);
		contentPane.add(btnUserOrderProd);

		JButton btnUserUpdate = new JButton("회원 정보수정");
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 창 열어서 비밀번호 입력 후 맞으면 업데이트 창이 열리고 진행후 저장
//				uu = new UserUpdate();
				cp.setVisible(true);			
				
			}
		});
		btnUserUpdate.setBounds(12, 124, 131, 47);
		contentPane.add(btnUserUpdate);

		btnUserQuit = new JButton("사용 종료");
		btnUserQuit.setBounds(12, 181, 131, 47);
		contentPane.add(btnUserQuit);

		lblPcNumber = new JLabel("좌석 번호");
		lblPcNumber.setBounds(155, 10, 131, 47);
		contentPane.add(lblPcNumber);

		lblMemberId = new JLabel();
		lblMemberId.setText("회원 이름");
		lblMemberId.setBounds(298, 10, 131, 47);
		contentPane.add(lblMemberId);

		lblMemberTime = new JLabel("현재 남은 시간");
		lblMemberTime.setBounds(155, 67, 187, 47);
		contentPane.add(lblMemberTime);

		JButton btnSelectOrder = new JButton("주문 내역");
		btnSelectOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}

		});
		btnSelectOrder.setBounds(12, 67, 131, 47);
		contentPane.add(btnSelectOrder);

		lblMemberNumber = new JLabel("회원 번호");
		lblMemberNumber.setBounds(372, 0, 57, 15);
		contentPane.add(lblMemberNumber);

	} // end MemberLogin()

	protected void ProdOrder() {
		// TODO Auto-generated method stub

	}

	public void setLblMember() {
		lblMemberId.setText("회원 아이디 : " + idFromPM);
		String numPM = String.valueOf(numFromPM);
		lblMemberNumber.setText(numPM);
	}

	public void setInfoFromPM(String id, int memNum) {
		this.idFromPM = id;
		this.numFromPM = memNum;
	}

//	protected void startTimer() {
//		boolean isStop = false;
//		TimerTask timerTask = new TimerTask() {
//			@Override
//			public void run() {
//				if (isStop) {
//					timer.cancel();
//				}
//				if (time > 0) {
//					time--;
//				} else {
//					timer.cancel();
//				}
//			}
//		};
//		timer = new Timer();
//		timer.schedule(timerTask, 1, 1000);
//	}

	protected void currentTime() {
		System.out.println("시간표시");
//		id = idFromProjectMain;
//		idFromPM = lblMemberId.getText();
		System.out.println(idFromPM);
		MemberVO mv = dao.selectMem(idFromPM);
		time = mv.getMemberTime();
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
				if (time == 0) {
					endTime();
//					updateMem(); TODO
					userQuit();
					timer.cancel();
				}
//					System.out.println("시간 표시 왜 안돼니?");

			}
		};
		timer.schedule(timerTask, 1, 1000);
		btnUserQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("사용자 종료");
				timer.cancel();
				lastTime = time;
				dispose();
//				로그인을 하면 기존창은 보이지않게 되고(닫고 싶었으나 닫게 되면..?은 닫아도 상관이 없어진다. 저기는 로그인만 하는 장소니까.
//				그런데 창을 닫으면 새로 불러와야하는데 저기는 부를수가 없다. 숨겨져있으니까.
//				프로젝트메인안에 있는 프라이빗 이니셜라이즈안에 있는 프레임을 보이게 해야한다.	
				pm = new ProjectMain();
				pm.frame.setVisible(true);
				System.out.println("로그인창 표시");
			}
		});

	}

	protected void userQuit() {
		pm = new ProjectMain();
		if (time == 0) {
			dispose();
		}
		pm.frame.setVisible(true);
	}
// TODO 요기 수정할것
//	protected void updateMemUser() {
//		String id = lblMemberId.getText();
//		System.out.println(id);
//		char[] pwChar = uu.inputPassword.getPassword();
//		String pw = String.valueOf(pwChar);
//		System.out.println(pw);
//		String name = uu.textMemberName.getText();
//		System.out.println(name);
//		String phone = uu.textMemberPhone.getText();
//		System.out.println(phone);
//		String email = uu.textMemberEmail.getText();
//		System.out.println(email);
//		MemberVO mv = new MemberVO(0, id, pw, name, phone, email, lastTime, 0);
//		dao.updateMemUser(id, mv);
//		System.out.println("수정 완료");
//	}

	public int startTime() {
		// TODO Auto-generated method stub
		startTime = (int) System.currentTimeMillis();

		return startTime;
	}

	public int endTime() {
		// TODO
		endTime = (int) System.currentTimeMillis();
		return endTime;
	}
}// end MemberLogin

//		int x =(startTime() - endTime()); // 총사용 시간을 나타낼때 사용하면 딱이긴한데..