package edu.java.project;

public class MemberVO {
	private int memberNumber;
	private String memberId;
	private String memberPw;
	private String memberName; 
	private String memberPhone;
	private String memberEmail;
	private int memberTime;
	private int memberManager;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	} // end 기본생성자

	public MemberVO(int memberNumber, String memberId, String memberPw, String memberName, String memberPhone,
			String memberEmail, int memberTime, int memberManager) {
		super();
		this.memberNumber = memberNumber;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberTime = memberTime;
		this.memberManager = memberManager;
	}


	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberTime() {
		return memberTime;
	}

	public void setMemberTime(int memberTime) {
		this.memberTime = memberTime;
	}

	public int getMemberManager() {
		return memberManager;
	}

	public void setMemberManager(int memberManager) {
		this.memberManager = memberManager;
	}

	@Override
	public String toString() {
		int time = memberTime;
		int hour = time / 3600;
		int minute = (time % 3600) / 60;
		int seconds = time % 60;
		return "MemberVO [회원 번호 = " + memberNumber + ", 아이디 = " + memberId + ", 비밀번호 = " + maskPassword(memberPw)
				+ ", 이름 = " + memberName + ", 전화번호 = " + memberPhone + ", 이메일 = " + memberEmail
				+ ", 남은 시간 =" + hour + "시간 " + minute + "분 " + seconds +"초, 관리자 여부 =" + memberManager + "]";
	}
	
	private String maskPassword(String memberPw) {
	    // 비밀번호를 마스킹 처리하는 로직을 구현
	    return "********";
	}
	
	
	
} // end MemberVO
