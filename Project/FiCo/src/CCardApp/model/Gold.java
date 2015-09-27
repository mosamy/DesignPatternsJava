package CCardApp.model;

import framework.model.ICustomer;


public class Gold extends CreditCardAccount {
	private double interestRate = 0.1;

	public Gold(ICustomer cust, String accnr, String expDate) {
		super(cust, accnr, expDate);
	}

	@Override
	public double getCurrentMonthlyBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMonthlyDues() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
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
