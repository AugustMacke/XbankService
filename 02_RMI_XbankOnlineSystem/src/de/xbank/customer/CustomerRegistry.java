package de.xbank.customer;

import java.util.HashMap;

import de.xbank.common.Customer;

public class CustomerRegistry 
{
	private static CustomerRegistry singleInstance = new CustomerRegistry();
	
	private HashMap<String, Customer> customers;
	
	private CustomerRegistry()
	{
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerRegistry getInstance()
	{
		return singleInstance;
	}
	
	public Customer findCustomerByName(String userName)
	{
		return this.customers.get(userName);
	}
	
	public void addCustomer(Customer newCustomer)
	{
		this.customers.put(newCustomer.getUserName(), newCustomer);
	}
}
