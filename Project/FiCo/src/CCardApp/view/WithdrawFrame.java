package CCardApp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CCardApp.controller.CreditCardController;
import framework.view.MainFrame;

import javax.swing.*;

public class WithdrawFrame extends JDialog {
	
	CreditCardController control;
	
	JLabel nameLabel = new JLabel();
	JLabel amountLabel = new JLabel();
	JTextField nameTextField = new JTextField();
	public JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	public JTextField withdrawTextField = new JTextField();
	
	private MainFrame parentframe;
	private String accnr;
	
	public WithdrawFrame(MainFrame parent, String aaccnr) {
		
		control = CreditCardController.getInstance();
		
		parentframe=parent;
		accnr=aaccnr;

		setLocationRelativeTo(null); // at middle of screen 
		
		setTitle("Withdraw");

		getContentPane().setLayout(null);
		setSize(300,200);
		setVisible(false);
		nameLabel.setText("Acc Nr");
		getContentPane().add(nameLabel);
		nameLabel.setForeground(java.awt.Color.black);
		nameLabel.setBounds(12,12,48,24);

		amountLabel.setText("Amount");
		getContentPane().add(amountLabel);
		amountLabel.setForeground(java.awt.Color.black);
		amountLabel.setBounds(12,48,55,24);
		
		nameTextField.setEditable(false);
		getContentPane().add(nameTextField);
		nameTextField.setBounds(84,12,144,24);
		nameTextField.setText(accnr);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		
		getContentPane().add(withdrawTextField);
		withdrawTextField.setBounds(84,48,144,24);
		
	    
	    
		JButton_OK.addActionListener(control.getWithdrawOKListener(this));
		JButton_Cancel.addActionListener(new CloseListener() );
	}

	public String getAmount() {
		
		return withdrawTextField.getText();
	}
	
	private class CloseListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
	}
}
