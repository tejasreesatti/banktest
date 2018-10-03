package com.teja.bank.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teja.bank.repository.BankAccountDao;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public double getBalance(long accountId) throws DataAccessException{
		try {
			return jdbcTemplate.queryForObject("select accountbalance from bankaccount where accountId=?", new Object[] {accountId},double.class);

		} catch (DataAccessException e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) throws DataAccessException {
			try {
					double balance = getBalance(accountId);
					jdbcTemplate.update("update bankaccount set accountbalance = ? where accountId = ?", new Object[] {newBalance+balance,accountId});
				
						return true;
				

			} catch (DataAccessException e) {
				// TODO: handle exception
				throw e;
				
			}

	}

}
