package framework.model;

import java.util.*;
import framework.view.MainFrame;

public class FinCo implements IFinCo, IFinCoSubject {

	protected List<ICustomer> customerList;
	protected List<IAccount> accountList;
	
	public FinCo()
	{
		this.customerList = new ArrayList<ICustomer>();
		this.accountList = new ArrayList<IAccount>();
	}
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deattach() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewAccount(String custType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(String acctNum, String name, Double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		
	}

	// stand alone framework application
    public static void main(String args[])
    {
    	
		(new MainFrame()).setVisible(true);
	}
}