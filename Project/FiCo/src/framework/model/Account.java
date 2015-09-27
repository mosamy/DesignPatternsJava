package framework.model;

import java.util.*;

public abstract class  Account implements IAccount {

	private double balance;
	private String acctNumber;
	private ICustomer accountOwner;
	private double interestRate;
	private List<ITransaction> transactions;
	
	public Account(String acctNumber, ICustomer cust) {
		this.acctNumber = acctNumber;
		this.accountOwner = cust;
		this.transactions = new ArrayList<ITransaction>();
	}


    public Customer Subject;

	@Override
	public String getAcctNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public void deposit(double amount) {
		ITransaction t = new Transaction(this.getAcctNo(), amount);
		transactions.add(t);
		
		
	}

	@Override
	public List<String> generateReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICustomer getAcctOwner() {
		// TODO Auto-generated method stub
		return accountOwner;
	}

	@Override
	public double getInterestRate() {
		// TODO Auto-generated method stub
		return interestRate;
	}

	


}