package com.teja.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teja.bank.exceptions.UserNotFoundException;
import com.teja.bank.model.Customer;
import com.teja.bank.service.CustomerService;
@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("loginCustomer")
	public String getLoginCustomerPage(Model model) {
		model.addAttribute("customer",new Customer());
		return "loginCustomer";
	}

/*
	@RequestMapping("login.do")
	public String displayDetails(HttpSession session,HttpServletRequest request, @RequestParam int customerId,@RequestParam String password)throws UserNotFoundException {
		session=request.getSession();
		Customer customer = new Customer(null, customerId, password, null, null, null, null);
		Customer authenticatedCustomer=null;
		authenticatedCustomer=customerService.authenticate(customer);
		session.setAttribute("customer", authenticatedCustomer);
		return "displayDetails";
	}
*/
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String authenticateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		Customer c = customerService.authenticate(customer);

		customer.setBankAccount(c.getBankAccount());
		customer.setAddress(c.getAddress());
		customer.setEmail(c.getEmail());
		customer.setCustomerName(c.getCustomerName());
		customer.setDateOfBirth(c.getDateOfBirth());
		model.addAttribute("customer", customer);
		return "displayDetails";
	}
	
	@RequestMapping("changePassword")
	public String getChangePasswordPage() {
		return "changePassword";
	}
	@RequestMapping("changePassword.do")
	public String changePassword(HttpSession session,HttpServletRequest request, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword) {
		session=request.getSession();
		if(newPassword.equals(confirmNewPassword))
		{
			if(customerService.updatePassword((Customer) session.getAttribute("customer"), oldPassword, confirmNewPassword))
			{
				return "passworSuccessfullyChanged";
			}
		}
		return "passwordFail";
	}
	
	@RequestMapping("editProfile")
	public String getEditProfilePage(HttpServletRequest request,HttpSession session,Model model) {
		model.addAttribute("customer",session.getAttribute("customer"));
		return "editProfile";
	}

	@RequestMapping("editProfile.do")
	public String editProfile(HttpSession session,HttpServletRequest request, @ModelAttribute Customer customer) {
		session=request.getSession();
		Customer customerInSession = (Customer) session.getAttribute("customer");
		customer = customerService.updateProfile(customer);
		customer.setBankAccount(customerInSession.getBankAccount());
		session.setAttribute("customer", customer);
		return "profileUpdatedSuccessfully";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session,HttpServletRequest request) {
		session=request.getSession();
		session.invalidate();
		return "index";
	}
	@RequestMapping("displayDetails")
	public String displayUser() {
		return "displayDetails";
	}
	
}
