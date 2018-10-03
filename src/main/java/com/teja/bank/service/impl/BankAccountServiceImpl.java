package com.teja.bank.service.impl;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.teja.bank.exceptions.AccountIdNotFoundException;
import com.teja.bank.repository.BankAccountDao;
import com.teja.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountDao bankAccountDao;

	@Override
	public double getBalance(long accountId) throws AccountIdNotFoundException {
		try {
			return bankAccountDao.getBalance(accountId);

			
		} catch (DataAccessException e) {
			// TODO: handle exception
			AccountIdNotFoundException accountIdNotFoundException = new AccountIdNotFoundException("account id not found for bank account");
			accountIdNotFoundException.initCause(e);
			throw accountIdNotFoundException;
		}

	}

	@Override
	public double withdraw(long accountId, double amount) throws AccountIdNotFoundException{
	
		double balance=bankAccountDao.getBalance(accountId);
		if(balance+amount>=0)
		{
		if(bankAccountDao.updateBalance(accountId, -1*amount))
			return bankAccountDao.getBalance(accountId);
		}
		return bankAccountDao.getBalance(accountId);
		
	}

	@Override
	public double deposit(long accountId, double amount) {
		if(bankAccountDao.updateBalance(accountId, amount))
			return bankAccountDao.getBalance(accountId);
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)  {
	
		if(bankAccountDao.getBalance(toAcc)<0)
		{
			return false;
		}
		
		else if(bankAccountDao.updateBalance(fromAcc, -1*amount))
		{
			if(bankAccountDao.updateBalance(toAcc, amount))
			{
				return true;
			}
		}
		return false;
	}

}
