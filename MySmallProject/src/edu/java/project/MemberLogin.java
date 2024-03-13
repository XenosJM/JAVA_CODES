package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.Main;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Frame;
import java.awt.event.ActionEvent;

public class MemberLogin extends JFrame {
	private static ManageDAO dao;
	private JPanel contentPane;
	private int hour, minute, seconds;
	private JFrame frame;
	private Timer timer;
	private int time;
	private JLabel lblMemberTime, lblMemberId;
	private ProjectMain projectMain;

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
			}
		});
		btnUserOrderProd.setBounds(12, 10, 131, 47);
		contentPane.add(btnUserOrderProd);

		JButton btnUserUpdate = new JButton("회원 정보수정");
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 창 열어서 비밀번호 입력
				

			}

		});
		btnUserUpdate.setBounds(12, 124, 131, 47);
		contentPane.add(btnUserUpdate);

		JButton btnUserQuit = new JButton("사용 종료");
		btnUserQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("사용자 종료");
				updateMem();
				dispose();
//				로그인을 하면 기존창은 보이지않게 되고(닫고 싶었으나 닫게 되면..?은 닫아도 상관이 없어진다. 저기는 로그인만 하는 장소니까.
//				그런데 창을 닫으면 새로 불러와야하는데 저기는 부를수가 없다. 숨겨져있으니까.
//				프로젝트메인안에 있는 프라이빗 이니셜라이즈안에 있는 프레임을 보이게 해야한다.				
				projectMain.frame.setVisible(true);
				System.out.println("로그인창 표시");
			}
		});
		btnUserQuit.setBounds(12, 181, 131, 47);
		contentPane.add(btnUserQuit);

		JLabel lblPcNumber = new JLabel("좌석 번호");
		lblPcNumber.setBounds(155, 10, 131, 47);
		contentPane.add(lblPcNumber);

		
		lblMemberId = new JLabel();
		lblMemberId.setBounds(297, 10, 131, 47);
		contentPane.add(lblMemberId);

		lblMemberTime = new JLabel("현재 남은 시간");
		currentTime();
		lblMemberTime.setBounds(155, 67, 273, 47);
		contentPane.add(lblMemberTime);

		JButton btnSelectOrder = new JButton("주문 내역");
		btnSelectOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelectOrder.setBounds(12, 67, 131, 47);
		contentPane.add(btnSelectOrder);
	}

	protected void currentTime() {
		System.out.println("시간표시");
		String id = lblMemberId.getText();
		MemberVO mv = dao.selectMem(id);
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
//					System.out.println("시간 표시 왜 안돼니?");
//	            cal.add(Calendar.SECOND, -1);			

			}
		};
		timer.schedule(timerTask, 1, 1000);
	}

	protected void userQuit() {
		dispose();

	}

	private void updateMem() {
		// TODO Auto-generated method stub

	}


}// end MemberLogin



