package com.training.entity;

import java.sql.Date;

public class OrderDetails {

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate + "]";
	}

	private int orderId;
	private String productName;
	private double productPrice;

	public OrderDetails() {

	}

	public OrderDetails(int orderId, String productName, double productPrice, int orderQuantity, Date orderDate) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	private int orderQuantity;
	private Date orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
