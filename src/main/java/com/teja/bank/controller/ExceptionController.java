package com.teja.bank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teja.bank.exceptions.AccountBalanceException;
import com.teja.bank.exceptions.AccountIdNotFoundException;
import com.teja.bank.exceptions.InsufficientFundException;
import com.teja.bank.exceptions.InvalidDetailsException;
import com.teja.bank.exceptions.PasswordDetailsWrongException;
import com.teja.bank.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value=UserNotFoundException.class)
	public String handleError(HttpServletRequest request,UserNotFoundException exception) {
		System.out.println(exception);
		System.out.println(exception.getCause());
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	
	@ExceptionHandler(value=AccountIdNotFoundException.class)
	public String handleAccountNotFoundException(HttpServletRequest request,AccountIdNotFoundException exception) {
		System.out.println(exception);
		System.out.println(exception.getCause());
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	
	@ExceptionHandler(value=AccountBalanceException.class)
	public String handleAccountBalanceException(HttpServletRequest request,AccountBalanceException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=InsufficientFundException.class)
	public String handleInsufficientFundException(HttpServletRequest request,InsufficientFundException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=InvalidDetailsException.class)
	public String handleInvalidDetailsException(HttpServletRequest request,InvalidDetailsException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=PasswordDetailsWrongException.class)
	public String handlePasswordDetailsWrongException(HttpServletRequest request,PasswordDetailsWrongException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	
}
