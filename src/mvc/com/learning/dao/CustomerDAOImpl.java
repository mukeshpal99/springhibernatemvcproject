package mvc.com.learning.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvc.com.learning.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		//execute the query and get the result
		List<Customer> customers = theQuery.getResultList();
		
		//return the result.
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		//currentSession.save(theCustomer);
		
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public void updateCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Query<Customer> theQuery = currentSession.createQuery("from Customer where id="+theId, Customer.class);
		//Customer tempCustomer = theQuery.getSingleResult();
		
		Customer tempCustomer = currentSession.get(Customer.class, theId);
		return tempCustomer;
	}

}
