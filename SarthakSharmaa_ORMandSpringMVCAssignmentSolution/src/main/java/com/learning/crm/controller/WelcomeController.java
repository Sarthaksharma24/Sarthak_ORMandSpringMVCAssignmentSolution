package com.learning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.crm.model.Customer;
import com.learning.crm.service.CustomerInterface;

@Controller
public class WelcomeController {

	// Autowiring customer interface object to be recognised by spring
	@Autowired
	private CustomerInterface customerInterface;

	// Root mapping directing to home page
	@RequestMapping("/")
	public String showHome(Model model) {
		List<Customer> customers = customerInterface.findAllCustomer();
		System.out.println("data on custeomrs" + customers);
		model.addAttribute("customers", customers);
		return "home";
	}

	// Mapping to display the add student form
	@RequestMapping("/addform")
	public String addForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customerObj", customer);
		model.addAttribute("mode", "Save");
		return "customer-form";

	}

	// Mapping to save details from student form
	@PostMapping("/save")
	public String saveCustomer(@RequestParam(name = "id") int id, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "emailId") String emailId) {

		Customer customer = null;
		if (id == 0) {
			customer = new Customer(firstName, lastName, emailId);
			System.out.println(customer);
		} else {
			customer = customerInterface.findCustomer(id);
			customer.setEmailId(emailId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
		}
		System.out.println("Cusomer at save" + customer);
		customerInterface.saveCustomer(customer);
		return "redirect:/";
	}

	// mapping to student form with fetched student details for updatye
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam(name = "id") int id, Model model) {
		Customer customer = customerInterface.findCustomer(id);
		System.out.println("found cuter" + customer);
		model.addAttribute("customerObj", customer);
		model.addAttribute("mode", "Update");
		return "customer-form";
	}

	// mapping for deleting the selected user
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam(name = "id") int id) {
		customerInterface.deleteCustomer(id);
		return "redirect:/";
	}

}
