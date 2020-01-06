package com.practical;

public class SpecialOrder extends Order  {
	int orderId;
	int quantity;
	String orderItemName;
	
	public SpecialOrder(int orderId, int quantity, String orderItemName) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.orderItemName = orderItemName;
	}

	@Override
	public void sellerName() {
		System.out.println("Special Seller");
		
	}

	@Override
	public void confirm() {
		System.out.println("Special Order Confirmed!!");
		
	}

	@Override
	public void close() {
		System.out.println("Special Order closed!!");
		
	}
	public void dispatch() {
		System.out.println("Speical Order Dispatched");
	}

	@Override
	public String toString() {
		return "SpecialOrder [orderId=" + orderId + ", quantity=" + quantity + ", orderItemName=" + orderItemName + "]";
	}

	public int getId()
	{
		return this.orderId;
	}
}
