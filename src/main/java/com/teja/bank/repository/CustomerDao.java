package com.teja.bank.repository;

import org.springframework.dao.DataAccessException;

import com.teja.bank.model.Customer;

public interface CustomerDao {
	public Customer authenticate(Customer customer)throws DataAccessException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);
}
