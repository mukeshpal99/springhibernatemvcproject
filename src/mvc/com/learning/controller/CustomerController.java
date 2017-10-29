package mvc.com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.com.learning.entity.Customer;
import mvc.com.learning.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		//get customer list form DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customer list to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
