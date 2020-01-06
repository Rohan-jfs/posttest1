package com.practical;

public class Customer {

	int customerId;
	String name;
	String loction;
	Order order;
	
	
	public Customer(int customerId, String name, String loction, Order order) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.loction = loction;
		this.order = order;
	}

	

	public void sendOrder() {
		System.out.println("Order is sent!!");
	}
	
	public void recieveOrder() {
		System.out.println("Order is received!!");
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", loction=" + loction + ", order=" + order
				+ "]";
	}
	
}
