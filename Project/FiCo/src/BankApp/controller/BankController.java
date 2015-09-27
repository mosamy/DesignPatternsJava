package BankApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JDialog;

import framework.model.AcctType;
import framework.model.CustomerType;
import framework.model.IAddress;
import framework.model.Address;
import framework.view.AddAccountFrame;
import framework.view.TransactionFrame;
import BankApp.view.AddPersonAccountFrame;
import BankApp.view.AddCompanyAccountFrame;
import BankApp.view.BankFrame;
import BankApp.BankApplication;

// Singleton for BankController
public class BankController {

	private static BankController instance = new BankController();
	private BankApplication	bankApplication;
	private BankFrame bankFrame;
	private AddAccountFrame addAccountFrame;
	private AcctType acctType;
	private int currentSelection;
	private String accountNo;
	private BankApp.view.DepositFrame depositFrame;
	private BankApp.view.WithdrawFrame withdrawFrame;
	// must have private constructor in Singleton pattern used
	private BankController()
	{
		
	}
	
	public static BankController getInstance()
	{
		if(instance == null)
			instance = new BankController();
		
		return instance;
	}
	
	// set bank application
	public void setbank(BankApplication bank) {
			this.bankApplication = bank;
	}
	
	public void setbankfrm(BankFrame frm) {
		bankFrame = frm;
	}
	
	
//	class WithdrawActionListener implements ActionListener
//	{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			JDialog depositeDialog = new TransactionFrame(bankFrame, "Withdraw", "123456");
//			depositeDialog.setVisible(true);
//		}
//		
//	}
	
	
//	class DepositeActionListener implements ActionListener
//	{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			JDialog depositeDialog = new TransactionFrame(bankFrame, "Deposit", "123456");
//			depositeDialog.setVisible(true);
//		}
//		
//	}
	// ActionListener for PersonAccountListner 
	class PersonAccountListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JDialog personalDialog = new AddPersonAccountFrame(bankFrame);
			personalDialog.setVisible(true);
		}
	}
	// set setPersonAccountListener
	public ActionListener setPersonAccountListener() {
		// TODO Auto-generated method stub
		
		return new PersonAccountListner();
	}
	
	class AddPersonAccount implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// // TODO Auto-generated method stub
			String[] fields = addAccountFrame.getAccountInfo();
			/* field value:
			 * 0: name
			 * 1: street
			 * 2: city
			 * 3: state
			 * 4: zip
			 * 5: birthdate
			 * 6: email
			 * 7: num of employees
			 * */
			IAddress addr = new Address(fields[1], fields[2], fields[3],fields[4]);

			bankApplication.addAccount(fields[0], addr, fields[5],
					acctType, CustomerType.PERSONAL, fields[6]);
			String[] rowdata = new String[9];
			rowdata[0] = fields[1];
			rowdata[1] = fields[2];
			rowdata[2] = fields[3];
			rowdata[3] = fields[4];
			rowdata[4] = "P";
			if(acctType == AcctType.CHECKING)
				rowdata[5] = "C";
			else if(acctType == AcctType.SAVINGS)
				rowdata[5] = "S";
			
			rowdata[6] = "0.0";
			rowdata[7] = fields[7];//acctNo
			
			bankFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);
			
		}

	}
	public ActionListener getAddPersonAccountFrameOkListener(AddAccountFrame frame) {
		addAccountFrame = frame;
		return new AddPersonAccount();
	}
	
	
	class SavingBoxListener extends java.awt.event.MouseAdapter {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent event) {
			acctType = AcctType.SAVINGS;
		}
	}

	class CheckingBoxListener extends java.awt.event.MouseAdapter {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent event) {
			acctType = AcctType.CHECKING;
		}
	}

	public MouseListener getSavingBoxListener() {
		return new SavingBoxListener();

	}

	public MouseAdapter getCheckingBoxListener() {
		return new CheckingBoxListener();

	}

	// set CompanyAccountListner
	public ActionListener setCompanyAccountListener() {
		return new CompanyAccountListner();
	}
	
	class CompanyAccountListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog companyDialog = new AddCompanyAccountFrame(bankFrame);
			companyDialog.setVisible(true);

		}
	}

	// section for Deposit
	public ActionListener setDepositActionListener() {
		// TODO Auto-generated method stub
		return new DepositeActionListener();
	}
	class DepositeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			currentSelection = bankFrame.infoTable.getSelectionModel().getMinSelectionIndex();
			
			if (currentSelection >= 0) {
				String[] fields = addAccountFrame.getAccountInfo();
				depositFrame = new BankApp.view.DepositFrame(bankFrame, fields[0]);// fields[0]: name

				depositFrame.setVisible(true);
			}
		}

	}
	
	public ActionListener getDepositOKListener(BankApp.view.DepositFrame depositframe) {
		depositFrame = depositframe;
		
		return new DepositOKListener();
	}
	
	class DepositOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			double amount = Double.parseDouble(depositFrame.getAmount().toString());
			System.out.println("Amount is " + amount);
			bankFrame.model.setValueAt(amount, currentSelection, 6);
			depositFrame.dispose();
		}
	}
	
	// section for Withdraw
	public ActionListener setWithdrawActionListener() {
		// TODO Auto-generated method stub
		return new WithdrawActionListener();
	}

	class WithdrawActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentSelection = bankFrame.infoTable.getSelectionModel().getMinSelectionIndex();
			
			if (currentSelection >= 0) {
				String[] fields = addAccountFrame.getAccountInfo();
				withdrawFrame = new BankApp.view.WithdrawFrame(bankFrame, fields[0]);// fields[0]: name

				withdrawFrame.setVisible(true);
			}
		}
		
	}

	public ActionListener getWithdrawOKListener(BankApp.view.WithdrawFrame withdrawframe) {
		withdrawFrame = withdrawframe;
		
		return new WithdrawOKListener();
	}
	
	class WithdrawOKListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			double amount = Double.parseDouble(withdrawFrame.getAmount().toString());
			System.out.println("Amount is " + amount);
			
			double balance = (double)bankFrame.model.getValueAt(currentSelection, 6);
			if(amount < balance)
			{
				bankFrame.model.setValueAt(balance - amount, currentSelection, 6);
			}
			withdrawFrame.dispose();
		}
	}
	
	public ActionListener getAddCompanynAccountFrameOkListener(AddAccountFrame frame) {
		addAccountFrame = frame;
		return new AddCompanyAccount();
	}
	
	class AddCompanyAccount implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// // TODO Auto-generated method stub
			String[] fields = addAccountFrame.getAccountInfo();
			/* field value:
			 * 0: name
			 * 1: street
			 * 2: city
			 * 3: state
			 * 4: zip
			 * 5: birthdate
			 * 6: email
			 * 7: num of employees
			 * */
			IAddress addr = new Address(fields[1], fields[2], fields[3],fields[4]);

			bankApplication.addAccount(fields[0], addr, fields[5],
					acctType, CustomerType.ORGANIZATION, fields[6]);
			String[] rowdata = new String[9];
			rowdata[0] = fields[1];
			rowdata[1] = fields[2];
			rowdata[2] = fields[3];
			rowdata[3] = fields[4];
			rowdata[4] = "C";
			if(acctType == AcctType.CHECKING)
				rowdata[5] = "C";
			else if(acctType == AcctType.SAVINGS)
				rowdata[5] = "S";
			
			rowdata[6] = "0.0";
			rowdata[7] = fields[7];
			bankFrame.updateTable(rowdata);
			addAccountFrame.setVisible(false);
			
		}


	}
}
