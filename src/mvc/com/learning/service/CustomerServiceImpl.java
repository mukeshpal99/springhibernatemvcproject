package mvc.com.learning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.com.learning.dao.CustomerDAO;
import mvc.com.learning.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		 customerDAO.saveCustomer(theCustomer);
		
	}


}
