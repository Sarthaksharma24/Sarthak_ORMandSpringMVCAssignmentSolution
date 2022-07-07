package com.learning.crm.service;

import java.util.List;

import com.learning.crm.model.Customer;

public interface CustomerInterface {

	public List<Customer> findAllCustomer();

	public Customer findCustomer(int id);

	public void deleteCustomer(int id);

	public void saveCustomer(Customer customer);

}
