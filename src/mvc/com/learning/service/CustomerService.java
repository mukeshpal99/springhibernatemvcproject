package mvc.com.learning.service;

import java.util.List;

import mvc.com.learning.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

}
