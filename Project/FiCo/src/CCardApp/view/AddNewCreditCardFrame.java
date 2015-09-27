package CCardApp.view;

import javax.swing.JTextField;

import CCardApp.controller.CreditCardController;
import framework.view.AddAccountFrame;
import framework.view.MainFrame;

public class AddNewCreditCardFrame extends AddAccountFrame {

	/**
	 * Dung Le
	 */
	private static final long serialVersionUID = 1L;
	javax.swing.JLabel lblCCNumber = new javax.swing.JLabel();
	javax.swing.JLabel lblExpDate = new javax.swing.JLabel();
	javax.swing.JTextField txtfieldCCNumber = new javax.swing.JTextField();
	javax.swing.JRadioButton radiobtnGold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton radiobtnSilver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton radiobtnBronze = new javax.swing.JRadioButton();
	CreditCardController control;

	public AddNewCreditCardFrame(MainFrame parent) {
		super(parent);
	
		control = CreditCardController.getInstance();
		
		getContentPane().setLayout(null);
		setSize(301,400);
		
		radiobtnGold.setText("Gold");
		radiobtnGold.setActionCommand("Gold");
		getContentPane().add(radiobtnGold);
		radiobtnGold.setBounds(36, 12, 84, 24);

		radiobtnSilver.setText("Silver");
		radiobtnSilver.setActionCommand("Silver");
		getContentPane().add(radiobtnSilver);
		radiobtnSilver.setBounds(36, 36, 84, 24);

		radiobtnBronze.setText("Bronze");
		radiobtnBronze.setActionCommand("Bronze");
		getContentPane().add(radiobtnBronze);
		radiobtnBronze.setBounds(36, 60, 84, 24);

		// move email up one line in credit card
		super.emailLabel.setBounds(12,228,60,24);
		super.emailTextField.setBounds(100,228,156,20);
		
		lblCCNumber.setText("CC number");
		getContentPane().add(lblCCNumber);
		lblCCNumber.setForeground(java.awt.Color.black);
		lblCCNumber.setBounds(12, 252, 96, 24);
		
		getContentPane().add(txtfieldCCNumber);
		txtfieldCCNumber.setBounds(100, 252, 156, 20);

		
		lblExpDate.setText("Exp. Date");
		getContentPane().add(lblExpDate);
		lblExpDate.setForeground(java.awt.Color.black);
		lblExpDate.setBounds(12, 276, 72, 24);
		
		getContentPane().add(super.txtfieldExpDate);
		super.txtfieldExpDate.setBounds(100, 276, 156, 20);

		
		JButton_OK.addActionListener(control.getAddNewCreditCardOkListener(this));
		radiobtnSilver.addMouseListener(control.getRadioButtonSilverListener());
		radiobtnBronze.addMouseListener(control.getRadioButtonBronzeListener());
		radiobtnGold.addMouseListener(control.getRadioButtonGoldListener());

	}

}
