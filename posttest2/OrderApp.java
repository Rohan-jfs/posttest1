package com.practical;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class OrderApp {

	static Set customerDetails=new HashSet();
	public static void main(String[] args) {
		//take input for order details
		int orderId=1;
		int quantity=2;
		String orderItemName="Mobile";
		Order order=new SpecialOrder(orderId, quantity, orderItemName);
		
		try {
			Customer customer=new Customer(1,"Rohan","Hyderabad",order);
//			addCustomer(customer);
//			System.out.println(customerDetails);
			//findCustomer(customer);
			//updateCustomer(customer);
			//deleteCustomer(customer);
			searchOrder(1, (SpecialOrder)order);
		}
		catch(CustomerException customerexception)
		{
			System.out.println(customerexception.getMessage());
		}
		
	}
	//add customer
	static void addCustomer(Customer customer) {
		try {
			customerDetails.add(customer);
			System.out.println("Customer details added successfuly");
			}
		catch (CustomerException orderException) {
				System.out.println("Unable to add order!");
			}
	}
	//find customer
	static void findCustomer(Customer customer) {
		if(customerDetails.contains(customer))
			System.out.println("Customer details found!!");
	}
	//update customer
	static void updateCustomer(Customer customer)
	{
		if(customerDetails.contains(customer))
		{
			customerDetails.remove(customer);
			int orderId=2;
			int quantity=3;
			String orderItemName="Laptop";
			Order order=new SpecialOrder(orderId, quantity, orderItemName);
			Customer customernew=new Customer(1,"Kanha","Hyderabad",order);
			customerDetails.add(customer);
			System.out.println("updated successfully");
		}
		else
			System.err.println("customer not found!!");
	}
	//delete customer
	static void deleteCustomer(Customer customer)
	{
		if(customerDetails.contains(customer))
		{
			customerDetails.remove(customer);
		}
		else
			System.err.println("customer not found!!");
	}

	static void searchOrder(int orderId,SpecialOrder order)
	{
		if(orderId==order.getId())
			System.out.println(order);
	}

	
	
}
