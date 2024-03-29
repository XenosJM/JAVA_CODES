package edu.java.project;

public class ProductVO {
	private int prodNumber;
	private String prodName;
	private String prodKind;
	private String prodInfo;
	private int prodSellPrice;
	private int prodQty;
	
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	} // end 기본생성자

	public ProductVO(int prodNumber, String prodName, String prodKind, String prodInfo, int prodSellPrice,
			int prodQty) {
		super();
		this.prodNumber = prodNumber;
		this.prodName = prodName;
		this.prodKind = prodKind;
		this.prodInfo = prodInfo;
		this.prodSellPrice = prodSellPrice;
		this.prodQty = prodQty;
	}

	public int getProdNumber() {
		return prodNumber;
	}

	public void setProdNumber(int prodNumber) {
		this.prodNumber = prodNumber;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdKind() {
		return prodKind;
	}

	public void setProdKind(String prodKind) {
		this.prodKind = prodKind;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public int getProdSellPrice() {
		return prodSellPrice;
	}

	public void setProdSellPrice(int prodSellPrice) {
		this.prodSellPrice = prodSellPrice;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	@Override
	public String toString() {
		return "ProductVO [prodNumber=" + prodNumber + ", prodName=" + prodName + ", prodKind=" + prodKind
				+ ", prodInfo=" + prodInfo + ", prodSellPrice=" + prodSellPrice + ", prodQty=" + prodQty + "]";
	}

	
	
} // end ProductVO
