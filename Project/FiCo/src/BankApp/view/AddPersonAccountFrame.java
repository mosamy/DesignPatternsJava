package BankApp.view;

import javax.swing.*;

import BankApp.controller.BankController;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;

public class AddPersonAccountFrame extends AddAccountFrame {
	
	private BankController control;

	JTextField birthDateTextField = new JTextField();
	protected JRadioButton ChkRadioButton = new JRadioButton();
	protected JRadioButton SavRadioButton = new JRadioButton();
	
	private static int acctNo = 0;
	public AddPersonAccountFrame(MainFrame parent) {
		super(parent);
		control = BankController.getInstance();

		setTitle("Add Personal Account");
		ChkRadioButton.setText("Checking");
		ChkRadioButton.setActionCommand("Checkings");
		getContentPane().add(ChkRadioButton);
		ChkRadioButton.setBounds(12, 12, 100, 24);
		
		SavRadioButton.setText("Saving");
		SavRadioButton.setActionCommand("Savings");
		getContentPane().add(SavRadioButton);
		SavRadioButton.setBounds(12, 36, 100, 24);
		
		super.birthDateLabel.setText("Birth date");
		getContentPane().add(birthDateLabel);
		birthDateLabel.setForeground(java.awt.Color.black);
		birthDateLabel.setBounds(12,228,60,24);
		
		getContentPane().add(birthDateTextField);
		birthDateTextField.setBounds(100,228,156,20);
		
		super.JButton_OK.addActionListener(control.getAddPersonAccountFrameOkListener(this));
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
		System.out.println(acctNo);
		return fields;
	}

}
