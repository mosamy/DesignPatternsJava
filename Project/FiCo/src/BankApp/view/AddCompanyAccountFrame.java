package BankApp.view;

import javax.swing.*;

import BankApp.controller.BankController;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;

public class AddCompanyAccountFrame extends AddAccountFrame {
	
	BankController control;

	JTextField noOfEmployeeTextField = new JTextField();
	JLabel noOfEmployeeLabel = new JLabel();
	protected JRadioButton ChkRadioButton = new JRadioButton();
	protected JRadioButton SavRadioButton = new JRadioButton();
	private static int acctNo = 0;
	public AddCompanyAccountFrame(MainFrame parent) {
		super(parent);
		control = BankController.getInstance();
		
		setTitle("Add Company Account");
		ChkRadioButton.setText("Checking");
		ChkRadioButton.setActionCommand("Checkings");
		getContentPane().add(ChkRadioButton);
		ChkRadioButton.setBounds(12, 12, 100, 24);
		
		SavRadioButton.setText("Saving");
		SavRadioButton.setActionCommand("Savings");
		getContentPane().add(SavRadioButton);
		SavRadioButton.setBounds(12, 36, 100, 24);
		
		noOfEmployeeLabel.setText("No of employees");
		getContentPane().add(noOfEmployeeLabel);
		noOfEmployeeLabel.setForeground(java.awt.Color.black);
		noOfEmployeeLabel.setBounds(12,228,100,24);
		getContentPane().add(noOfEmployeeTextField);
		noOfEmployeeTextField.setBounds(100,228,156,20);
		
		super.JButton_OK.addActionListener(control.getAddCompanynAccountFrameOkListener(this));
		ChkRadioButton.addMouseListener(control.getCheckingBoxListener());
		SavRadioButton.addMouseListener(control.getSavingBoxListener());
		
		acctNo++;
	}
	
	public String[] getAccountInfo() {
		String[] fields = new String[8];
		fields[0] = nameTextField.getText();
		fields[1] = streetTextField.getText();
		fields[2] = cityTextField.getText();
		fields[3] = stateTextField.getText();
		fields[4] = zipTextField.getText();
		fields[5] = birthDateLabel.getText();
		fields[6] = emailTextField.getText();
		fields[7] = "" + acctNo;

		return fields;
	}
}
