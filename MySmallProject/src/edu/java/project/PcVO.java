package edu.java.project;

public class PcVO {
	private int pcNumber;
	private String pcInfo;
	private int pcState;
	private int pcMemNum;
			
	public PcVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PcVO(int pcNumber, String pcInfo, int pcState, int pcMemNum) {
		super();
		this.pcNumber = pcNumber;
		this.pcInfo = pcInfo;
		this.pcState = pcState;
		this.pcMemNum = pcMemNum;
	}

	public int getPcNumber() {
		return pcNumber;
	}

	public void setPcNumber(int pcNumber) {
		this.pcNumber = pcNumber;
	}

	public String getPcInfo() {
		return pcInfo;
	}

	public void setPcInfo(String pcInfo) {
		this.pcInfo = pcInfo;
	}

	public int getPcState() {
		return pcState;
	}

	public void setPcState(int pcState) {
		this.pcState = pcState;
	}

	public int getPcMemberNumber() {
		return pcMemNum;
	}

	public void setPcMemberNumber(int pcMemNum) {
		this.pcMemNum = pcMemNum;
	}

	@Override
	public String toString() {
		return "PcVO [pcNumber=" + pcNumber + ", pcInfo=" + pcInfo + ", pcState=" + pcState + ", pcMemNum="
				+ pcMemNum + "]";
	}
	
	
}
