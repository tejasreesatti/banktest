package com.teja.bank.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.teja.bank.model.BankAccount;
import com.teja.bank.model.Customer;
import com.teja.bank.repository.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	@SuppressWarnings("serial")
	@Override
	public Customer authenticate(Customer customer) throws DataAccessException{
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select * from customers where customerId=? and password=?",new Object[] {customer.getCustomerId(),customer.getPassword()}, new CustomerRowMapper());
		}
		catch(DataAccessException ex)
		{
			ex.initCause(new EmptyResultDataAccessException("no user found,expected 1 actual 0",1));
			ex.getCause();
			throw ex;
		}
	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("UPDATE customers SET address=?,email=?  WHERE customerId=?",new Object[] {customer.getAddress(),customer.getEmail(),customer.getCustomerId()});
		return customer;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		int count=0;
		String originalPassword=jdbcTemplate.queryForObject("select password from customers where customerId=?",new Object[] {customer.getCustomerId()},String.class);
		if(oldPassword.equals(originalPassword))
		{
			count=jdbcTemplate.update("UPDATE customers SET password=?  WHERE customerId=?",new Object[] {newPassword,customer.getCustomerId()});
		}
		if(count==1)
		{
			return true;
		}
		return false;
	}


	private class CustomerRowMapper implements RowMapper<Customer>{
		@Override
		public Customer mapRow (ResultSet rs , int rowNum) throws SQLException {
			Customer customer = new Customer();
			BankAccount bankAccount= new BankAccount();
			customer.setAddress(rs.getString(4));
			customer.setCustomerId(rs.getInt(2));
			customer.setCustomerName(rs.getString(1));
			customer.setDateOfBirth(rs.getDate(6).toLocalDate());
			customer.setEmail(rs.getString(5));
			customer.setPassword(rs.getString(3));
			bankAccount= jdbcTemplate.queryForObject("select * from bankaccount where accountId=?", new Object[] {rs.getInt(7)},new BankAccountRowMapper());
			customer.setBankAccount(bankAccount);
			return customer;
		}
	}


	private class BankAccountRowMapper implements RowMapper<BankAccount>
	{
		@Override
		public BankAccount mapRow (ResultSet rs , int rowNum) throws SQLException{
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccountId(rs.getInt(1));
			bankAccount.setAccountType(rs.getString(3));
			bankAccount.setBalance(rs.getInt(2));
			return bankAccount;

		}

	}

}
