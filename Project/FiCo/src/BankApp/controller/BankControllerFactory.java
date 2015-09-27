package BankApp.controller;

import BankApp.view.DepositFrame;
import BankApp.view.WithdrawFrame;

public class BankControllerFactory {

	private  static BankControllerFactory instance;
	
	private DepositController  depositControllerInstance ;

	private WithdrawController withdrawControllerInstance;
	
	public static BankControllerFactory getInstance()
	{
		if(instance == null)
			instance = new BankControllerFactory();
		
		return instance;
	}

	public BankController getBankController()
	{
		return BankController.getInstance();
	}
	
	public DepositController getDepositController(DepositFrame df)
	{
		if (depositControllerInstance == null)
		{
			depositControllerInstance = new DepositController(df);
		}
		else
		{
			depositControllerInstance.setDepositFrame(df);
		}
		return depositControllerInstance;
	}
	
	public WithdrawController getWithDrawController(WithdrawFrame df)
	{
		if (withdrawControllerInstance == null)
		{
			withdrawControllerInstance = new WithdrawController(df);
		}
		else
		{
			withdrawControllerInstance.setWithdrawframe(df);
		}
		return withdrawControllerInstance;
	}
	
}