package mvc.com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
		
		//get the customer from DB using id
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set the fetched customer as model attribute
		theModel.addAttribute("customer", theCustomer);
		
		// populate customer details to form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		//delete the customer from DB using id
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String searchName, Model theModel){
		
		// saerch customer from using customer search service
		
		List<Customer> theCustomers = customerService.searchCustomer(searchName);
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

}
