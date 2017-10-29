package mvc.com.learning.dao;

import java.util.List;

import mvc.com.learning.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
