package BankApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BankApp.view.WithdrawFrame;
import framework.model.AccountFactory;

public class WithdrawController {

	private WithdrawFrame withdrawframe;
	
	
	class ButtonOKActionListener implements ActionListener
	{
			
		@Override
		public void actionPerformed(ActionEvent e) {
			 withdrawframe = (WithdrawFrame) e.getSource();
			 
			 //withdrawframe.getAccount().withdraw(withdrawframe.getAmount(), withdrawframe.getWithdrawDate());
			 
			
		}
		
	}

	
	class ButtonCancelActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	public WithdrawController(WithdrawFrame df) {
		this.withdrawframe = df;
	}

	public WithdrawFrame getWithdrawframe() {
		return withdrawframe;
	}

	public void setWithdrawframe(WithdrawFrame withdrawframe) {
		this.withdrawframe = withdrawframe;
	}

	

	public ActionListener getButtonOKActionListener() {
		// TODO Auto-generated method stub
		return new ButtonOKActionListener();
	}
}
