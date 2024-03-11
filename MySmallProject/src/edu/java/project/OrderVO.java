package edu.java.project;

public class OrderVO {
	private int orderNum;
	private int orderMemNum;
	private int orderProdNum;
	private int orderProdQty;
	
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderVO(int orderNum, int orderMemNum, int orderProdNum, int orderProdQty) {
		super();
		this.orderNum = orderNum;
		this.orderMemNum = orderMemNum;
		this.orderProdNum = orderProdNum;
		this.orderProdQty = orderProdQty;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderMemNum() {
		return orderMemNum;
	}

	public void setOrderMemNum(int orderMemNum) {
		this.orderMemNum = orderMemNum;
	}

	public int getOrderProdNum() {
		return orderProdNum;
	}

	public void setOrderProdNum(int orderProdNum) {
		this.orderProdNum = orderProdNum;
	}

	public int getOrderProdQty() {
		return orderProdQty;
	}

	public void setOrderProdQty(int orderProdQty) {
		this.orderProdQty = orderProdQty;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNum=" + orderNum + ", orderMemNum=" + orderMemNum + ", orderProdNum=" + orderProdNum
				+ ", orderProdQty=" + orderProdQty + "]";
	}
	
	
	
	
}
