package com.teja.bank.service;

import com.teja.bank.exceptions.AccountIdNotFoundException;

public interface BankAccountService {

	
	public double getBalance(long accountId) throws AccountIdNotFoundException;
	public double withdraw(long accountId, double amount) throws AccountIdNotFoundException;
	public double deposit(long accountId, double amount);
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) ;

}
