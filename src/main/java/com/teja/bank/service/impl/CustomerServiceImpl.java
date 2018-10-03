package com.teja.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.teja.bank.exceptions.UserNotFoundException;
import com.teja.bank.model.Customer;
import com.teja.bank.repository.CustomerDao;
import com.teja.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer authenticate(Customer customer) throws UserNotFoundException{
		// TODO Auto-generated method stub
		try {
			return customerDao.authenticate(customer);
		}
		catch (DataAccessException ex) {
			UserNotFoundException uex = new UserNotFoundException("no user found");
			uex.initCause(ex);
			throw uex;
		}

	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return customerDao.updatePassword(customer, oldPassword, newPassword);
	}

}
