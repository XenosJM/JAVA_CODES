package edu.java.project;

import java.util.Date;

public class HistoryVO {

	private int histNumber;
	private Date histDate;
	private String histMem;
	private String histProd;
	private String histPC;
	private String histOrder;
	
	public HistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	} // end 기본생성자

	public HistoryVO(int histNumber, Date histDate, String histMem, String histProd, String histPC, String histOrder) {
		super();
		this.histNumber = histNumber;
		this.histDate = histDate;
		this.histMem = histMem;
		this.histProd = histProd;
		this.histPC = histPC;
		this.histOrder = histOrder;
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

	public String getHistOrder() {
		return histOrder;
	}

	public void setHistOrder(String histOrder) {
		this.histOrder = histOrder;
	}

	@Override
	public String toString() {
		return "HistoryVO [histNumber=" + histNumber + ", histDate=" + histDate + ", histMem=" + histMem + ", histProd="
				+ histProd + ", histPC=" + histPC + ", histOrder=" + histOrder + "]";
	}




} // end HistoryVO
