package BankApp.model;

import framework.model.Account;
import framework.model.AcctType;
import framework.model.ICustomer;


public class Savings extends Account{

	private double interestRate = 0.2;

	public Savings(ICustomer cust, String acctNo) {
		super(acctNo, cust);
	}

	public double getInterstRate() {
		return interestRate;
	}

	public AcctType getAccountType() {
		return AcctType.SAVINGS;
	}

	@Override
	public void deposit(double amount, String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(double amount, String date) {
		// TODO Auto-generated method stub
		
	}
}
