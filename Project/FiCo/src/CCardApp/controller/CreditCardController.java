package CCardApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import CCardApp.view.AddNewCreditCardFrame;
import CCardApp.view.CreditcardFrame;
import CCardApp.CCreditApplication;
import framework.model.AcctType;
import framework.model.Address;
import framework.model.CustomerType;
import framework.model.IAddress;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;
import CCardApp.view.ReportFrame;

public class CreditCardController {

	private CreditcardFrame creditCardFrame;
	private CCreditApplication creditCardApplication;
	
	private static CreditCardController instance;

	private AddAccountFrame addAccountFrame;
	private AcctType accountType;
	private CustomerType customerType;
	
	private int currentSelection;
	private String accountNo;
	private CCardApp.view.WithdrawFrame withdrawFrame;
	private CCardApp.view.DepositFrame depositFrame;
	
	private CreditCardController() 
	{
		
	}

	public static CreditCardController getInstance() {
		if (instance == null) {
			instance = new CreditCardController();
		}
		return instance;
	}

	public void setCreditcardProcessor(CCreditApplication creditcardProcessor) {
		this.creditCardApplication = creditcardProcessor;
	}
	
	public void setCreditcardForm(CreditcardFrame creditcardForm) {
		this.creditCardFrame = creditcardForm;
	}
	
	class AddNewCCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddNewCreditCardFrame addCreditCardFrame = new AddNewCreditCardFrame(
					creditCardFrame);
			addCreditCardFrame.setVisible(true);
		}

	}

	class GenerateBillListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			List<String[]> report = creditCardApplication.generateReport();
			ReportFrame reportFrame = new ReportFrame(creditCardFrame);
			reportFrame.displayReport(report);
			reportFrame.setVisible(true);
		}

	}

	public ActionListener getAddNewCreditCardListener(MainFrame frame) {

		return new AddNewCCardListener();

	}

	public ActionListener getGenerateBillListener(MainFrame frame) {
		return new GenerateBillListener();

	}

	public ActionListener getAddNewCreditCardOkListener(AddAccountFrame frame) {
		
		
		addAccountFrame = frame;
		return new AddNewCreditCardOKListener();
	}
	
	class AddNewCreditCardOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String[] fields = addAccountFrame.getAccountInfo();
			IAddress address = new Address(fields[1], fields[2], fields[3], fields[4]);
			
			creditCardApplication.addAccount(fields[0], address, "","",
					accountType, customerType, fields[6], fields[5]);
			
			String[] rowdata = new String[8];
			rowdata[0] = fields[0];// name
			rowdata[1] = fields[5];// CC number
			rowdata[2] = fields[6];// expire date
			if(accountType == AcctType.BRONZE)
				rowdata[3] = "Bronze";
			else if(accountType == AcctType.SILVER)
				rowdata[3] = "Silver";
			else if(accountType == AcctType.GOLD)
				rowdata[3] = "Gold";
			
			rowdata[4] = "0.0";
			rowdata[5] = "";
			rowdata[6] = "0.0";
			rowdata[7] = fields[6];
			creditCardFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);
			
		}
	}
	
	public java.awt.event.MouseListener getRadioButtonGoldListener() {
		return new RadioButtonGoldListener();
	}

	public java.awt.event.MouseListener getRadioButtonSilverListener() {
		return new RadioButtonSilverListener();
	}

	public java.awt.event.MouseListener getRadioButtonBronzeListener() {
		return new RadioButtonBronzeListener();
	}
	
	class RadioButtonGoldListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = AcctType.GOLD;
		}
	}

	class RadioButtonBronzeListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = AcctType.BRONZE;
		}
	}

	class RadioButtonSilverListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountType = AcctType.SILVER;
		}
	}
	
	// section for Deposit
	public ActionListener getDepositListener(MainFrame frame) {
		return new DepositListener();

	}
	
	class DepositListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			currentSelection = creditCardFrame.infoTable.getSelectionModel().getMinSelectionIndex();
			
			if (currentSelection >= 0) {
				accountNo = (String) creditCardFrame.model.getValueAt(currentSelection, 1);
				depositFrame = new CCardApp.view.DepositFrame(creditCardFrame, accountNo);

				depositFrame.setVisible(true);
			}
		}

	}
	
	public ActionListener getDepositOKListener(CCardApp.view.DepositFrame depositframe) {
		depositFrame = depositframe;
		
		return new DepositOKListener();
	}
	
	class DepositOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			double amount = Double.parseDouble(depositFrame.getAmount().toString());
			System.out.println("Amount is " + amount);
			creditCardFrame.model.setValueAt(amount, currentSelection, 4);
			depositFrame.dispose();
		}
	}
	
	// section for Withdraw
	public ActionListener getWithdrawOKListener(CCardApp.view.WithdrawFrame withdrawframe) {
		withdrawFrame = withdrawframe;
		
		return new WithdrawOKListener();
	}
	
	class WithdrawOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			double amount = Double.parseDouble(withdrawFrame.getAmount().toString());
			System.out.println("Amount is " + amount);
			
			double balance = (double)creditCardFrame.model.getValueAt(currentSelection, 4);
			if(amount < balance)
			{
				creditCardFrame.model.setValueAt(balance - amount, currentSelection, 4);
			}
			withdrawFrame.dispose();
		}
	}
	
	
	public ActionListener getWithdrawListener(MainFrame frame) {
		return new WithdrawListener();

	}
	
	class WithdrawListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			currentSelection = creditCardFrame.infoTable.getSelectionModel().getMinSelectionIndex();
			
			if (currentSelection >= 0) {
				accountNo = (String) creditCardFrame.model.getValueAt(currentSelection, 1);
				withdrawFrame = new CCardApp.view.WithdrawFrame(creditCardFrame, accountNo);

				withdrawFrame.setVisible(true);
			}
		}

	}
}
