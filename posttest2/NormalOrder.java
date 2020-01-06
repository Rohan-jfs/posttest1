package com.practical;

public class NormalOrder extends Order {
	int orderId;
	int quantity;
	String orderItemName;
	

	public NormalOrder(int orderId, int quantity, String orderItemName) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.orderItemName = orderItemName;
	}

	@Override
	public void sellerName() {
		System.out.println("Normal Seller");
		
	}

	@Override
	public void confirm() {
		System.out.println("Normal order confirmed!!");
		
	}

	@Override
	public void close() {
		System.out.println("Normal order closed");
		
	}
	public void dispatch() {
		System.out.println("Normal Order Dispatched");
	}
	public void recieve() {
		System.out.println("Normal Order Recieved");
	}

}
