package com.teja.bank.service;

import com.teja.bank.exceptions.UserNotFoundException;
import com.teja.bank.model.Customer;

public interface CustomerService {
	public Customer authenticate(Customer customer) throws UserNotFoundException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

}
