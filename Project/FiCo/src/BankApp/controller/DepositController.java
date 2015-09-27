package BankApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BankApp.view.DepositFrame;

public class DepositController {
	
	private DepositFrame depositFrame;
	
	
	public void setDepositFrame(DepositFrame depositFrame) {
		this.depositFrame = depositFrame;
	}
	public DepositController(DepositFrame newDF) {
		depositFrame = newDF;
	}
	
	class OKButtonActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

	class CancelActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			depositFrame.dispose();
		}
		
	}
	
	public CancelActionListener getCancelAnswerListener()
	{
		return new CancelActionListener();
	}
}
