package edu.java.project;

public class OrderVO {
	private int orderNumber;
	private String orderMemId;
	private String orderProdName;
	private String orderProdKind;
	private int orderProdQty;
	
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public OrderVO(int orderNumber, String orderMemId, String orderProdName, String orderProdKind, int orderProdQty) {
		super();
		this.orderNumber = orderNumber;
		this.orderMemId = orderMemId;
		this.orderProdName = orderProdName;
		this.orderProdKind = orderProdKind;
		this.orderProdQty = orderProdQty;
	}



	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderMemId() {
		return orderMemId;
	}

	public void setOrderMemId(String orderMemId) {
		this.orderMemId = orderMemId;
	}

	public String getOrderProdName() {
		return orderProdName;
	}

	public void setOrderProdName(String orderProdName) {
		this.orderProdName = orderProdName;
	}

	public int getOrderProdQty() {
		return orderProdQty;
	}

	public void setOrderProdQty(int orderProdQty) {
		this.orderProdQty = orderProdQty;
	}

	public String getOrderProdKind() {
		return orderProdKind;
	}

	public void setOrderProdKind(String orderProdKind) {
		this.orderProdKind = orderProdKind;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNumber=" + orderNumber + ", orderMemId=" + orderMemId + ", orderProdName=" + orderProdName
				+ ", orderProdQty=" + orderProdQty + ", orderProdKind=" + orderProdKind + "]";
	}

	
	
	
	
	
}
