package BankApp.view;

import javax.swing.*;

import BankApp.controller.BankController;
import framework.view.MainFrame;


public class BankFrame extends MainFrame {

	private JButton personAccountButton = new JButton("Add personal account");
	private JButton companyAccountButton = new JButton("Add company account");
	private BankController control;
	
	
	public BankFrame() {
		super();
		this.control = BankController.getInstance();
		super.setTitle("Bank Application.");
		
		super.withdrawButton.setText("Withdraw");
		
		personAccountButton.setBounds(24, 20, 192, 33);
		companyAccountButton.setBounds(240, 20, 192, 33);
		
		super.frameJPanel.add(personAccountButton);
		super.frameJPanel.add(companyAccountButton);
		
		
		super.model.addColumn("Street");
		super.model.addColumn("City");
		super.model.addColumn("State");
		super.model.addColumn("Zip");
		super.model.addColumn("P/C");
		super.model.addColumn("Ch/S");
		super.model.addColumn("Amount");
		super.model.addColumn("ID");
		
		
		personAccountButton.addActionListener(control.setPersonAccountListener());
		companyAccountButton.addActionListener(control.setCompanyAccountListener());
		depositButton.addActionListener(control.setDepositActionListener());
		withdrawButton.addActionListener(control.setWithdrawActionListener());
		
		
	}

	public void updateTable(String[] data) {
		System.out.println(data[8]);
		super.rowdata[0] = data[0];	//street
		super.rowdata[1] = data[1];	//city
		super.rowdata[2] = data[2]; //state
		super.rowdata[3] = data[3]; //zip
		super.rowdata[4] = data[4]; //customer type
		super.rowdata[5] = data[5]; //account type type
		super.rowdata[6] = data[6]; //amount
		super.rowdata[7] = data[7]; //email
		super.rowdata[8] = data[8]; //acctNo
		super.model.addRow(super.rowdata);
		super.infoTable.getSelectionModel().setAnchorSelectionIndex(-1);
		
	}


}
