package com.teja.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teja.bank.exceptions.AccountIdNotFoundException;
import com.teja.bank.model.Customer;
import com.teja.bank.service.BankAccountService;
import com.teja.bank.service.CustomerService;

@Controller
public class BankController {

	
	@Autowired
	BankAccountService bankAccountService;
	@RequestMapping("balanceEnquiry")
	public String getBalanceEnquiryPage()
	{
		return "balanceEnquiry";
	}
	
	@RequestMapping("fundTransfer")
	public String getfundTransferPage ()
	{
		return "fundTransfer";
	}
	
	@RequestMapping("fundTransfer.do")
	public String fundTransfer (HttpSession session,HttpServletRequest request, @RequestParam long payeeAccountNumber,@RequestParam double amount) throws AccountIdNotFoundException
	{
		session = request.getSession();
		Customer customer= (Customer) session.getAttribute("customer");
		
		if(bankAccountService.fundTransfer(customer.getBankAccount().getAccountId(), payeeAccountNumber, amount))
		{
			customer.getBankAccount().setBalance(bankAccountService.getBalance(customer.getBankAccount().getAccountId())); 
			session.setAttribute("customer", customer);
			return "transferSuccess";
		}
		
		return "transferFail";
	}
	
}
