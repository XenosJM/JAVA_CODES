package edu.java.project;

import java.util.Date;

public class HistoryVO {

	private int histNumber;
	private Date histDate;
	private String histMem;
	private String histProd;
	private String histPC;
	private int histMemID;
	private int histProdName;
	private int histPcNum;
	private int histOrderNum;
	
	public HistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	} // end 기본생성자

	public HistoryVO(int histNumber, Date histDate, String histMem, String histProd, String histPC, int histMemID,
			int histProdName, int histPcNum, int histOrderNum) {
		super();
		this.histNumber = histNumber;
		this.histDate = histDate;
		this.histMem = histMem;
		this.histProd = histProd;
		this.histPC = histPC;
		this.histMemID = histMemID;
		this.histProdName = histProdName;
		this.histPcNum = histPcNum;
		this.histOrderNum = histOrderNum;
	}

	public int getHistOrderNum() {
		return histOrderNum;
	}

	public void setHistOrderNum(int histOrderNum) {
		this.histOrderNum = histOrderNum;
	}

	public int getHistNumber() {
		return histNumber;
	}

	public void setHistNumber(int histNumber) {
		this.histNumber = histNumber;
	}

	public Date getHistDate() {
		return histDate;
	}

	public void setHistDate(Date histDate) {
		this.histDate = histDate;
	}

	public String getHistMem() {
		return histMem;
	}

	public void setHistMem(String histMem) {
		this.histMem = histMem;
	}

	public String getHistProd() {
		return histProd;
	}

	public void setHistProd(String histProd) {
		this.histProd = histProd;
	}

	public String getHistPC() {
		return histPC;
	}

	public void setHistPC(String histPC) {
		this.histPC = histPC;
	}

	public int getHistMemID() {
		return histMemID;
	}

	public void setHistMemID(int histMemID) {
		this.histMemID = histMemID;
	}

	public int getHistProdName() {
		return histProdName;
	}

	public void setHistProdName(int histProdName) {
		this.histProdName = histProdName;
	}

	public int getHistPcNum() {
		return histPcNum;
	}

	public void setHistPcNum(int histPcNum) {
		this.histPcNum = histPcNum;
	}

	@Override
	public String toString() {
		return "HistoryVO [histNumber=" + histNumber + ", histDate=" + histDate + ", histMem=" + histMem + ", histProd="
				+ histProd + ", histPC=" + histPC + ", histMemID=" + histMemID + ", histProdName=" + histProdName
				+ ", histPcNum=" + histPcNum + ", histOrderNum=" + histOrderNum + "]";
	}


} // end HistoryVO
